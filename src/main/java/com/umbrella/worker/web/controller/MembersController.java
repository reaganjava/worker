package com.umbrella.worker.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.umbrella.worker.dto.ContactDO;
import com.umbrella.worker.dto.CouponDO;
import com.umbrella.worker.dto.MemberCouponDO;
import com.umbrella.worker.dto.MemberDetailDO;
import com.umbrella.worker.dto.MembersDO;
import com.umbrella.worker.dto.SmsCodeDO;
import com.umbrella.worker.query.ContactQuery;
import com.umbrella.worker.query.MembersQuery;
import com.umbrella.worker.query.SmsCodeQuery;
import com.umbrella.worker.result.JsonResultDO;
import com.umbrella.worker.result.JsonResultSupport;
import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.result.ResultSupport;
import com.umbrella.worker.service.IContactService;
import com.umbrella.worker.service.ICouponService;
import com.umbrella.worker.service.IMemberService;
import com.umbrella.worker.service.ISmsService;
import com.umbrella.worker.util.Constant;
import com.umbrella.worker.util.GetHttpMemberInfo;
import com.umbrella.worker.util.MD5;
import com.umbrella.worker.util.StringUtil;

@Controller
@RequestMapping(value = "/members")
public class MembersController extends BaseController {
	
	@Autowired
	private IMemberService memberService;
	
	@Autowired
	private ISmsService smsService;
	
	@Autowired
	private IContactService contactService;
	
	@Autowired
	private ICouponService couponService;

	@RequestMapping(value = "/register.html", method = RequestMethod.GET)
	public ModelAndView register(ModelAndView mav, HttpServletRequest request) {
		mav.setViewName("members/register");
		String backPage = request.getHeader("Referer");
		backPage = StringUtil.getReferer(backPage, request.getContextPath());
		request.getSession().setAttribute("BACK_PAGE", backPage);
		return mav;
	}
	
	@RequestMapping(value = "/register.html", method = RequestMethod.POST)
	public ModelAndView register(ModelAndView mav, 
			MembersDO membersDO, HttpServletRequest request) {
		
		//String backPage = (String) request.getSession().getAttribute("BACK_PAGE");
		
		String registerIP = GetHttpMemberInfo.getIpAddr(request);
		String regDevice = "Mobile";
		if(!GetHttpMemberInfo.isMobileDevice(request)) {
			regDevice = "PC";
		}
	
		MD5 md5 = new MD5();
		String md5Pwd = md5.getMD5ofStr(membersDO.getwMPassword() 
				+ membersDO.getwMMobile());
		membersDO.setwMPassword(md5Pwd);
		membersDO.setwMNickname(membersDO.getwMMobile());
		membersDO.setwMRegIp(registerIP);
		membersDO.setwMRegDevice(regDevice);
		membersDO.setwMLoginIp(registerIP);
		membersDO.setCreateAuthor(membersDO.getwMMobile());
		membersDO.setModifiAuthor(membersDO.getCreateAuthor());
		
		
		ResultDO resultDO = memberService.create(membersDO);
		
		if(resultDO.isSuccess()) {
			Integer memberId = (Integer) resultDO.getModel(ResultSupport.FIRST_MODEL_KEY);
			resultDO = couponService.memberCoupon(1);
			CouponDO couponDO = (CouponDO) resultDO.getModel(ResultSupport.FIRST_MODEL_KEY);
			MemberCouponDO memberCouponDO = new MemberCouponDO();
			memberCouponDO.setwMcCouponTitle(couponDO.getwCTitle());
			memberCouponDO.setwMcCouponType(couponDO.getwCType());
			memberCouponDO.setwMcMemberId(memberId);
			memberCouponDO.setwMcMoney(couponDO.getwCMoney());
			memberCouponDO.setwMcDiscount(couponDO.getwCDiscount());
			memberCouponDO.setCreateAuthor(membersDO.getwMMobile());
			memberCouponDO.setwMcDeadline(new Date(System.currentTimeMillis() + (couponDO.getwCDays() * 24 * 60 * 60 * 1000)));
			memberService.createCoupon(memberCouponDO);
			return new ModelAndView("redirect:/members/login.html");
		} else {
			mav.setViewName("/members/regfail");
		}
		return mav;
	}
	
	@RequestMapping(value = "/login.html", method = RequestMethod.GET)
	public ModelAndView login(ModelAndView mav, HttpServletRequest request) {
		mav.setViewName("members/login");
		String backPage = request.getHeader("Referer");
		if(backPage != null) {
			backPage = StringUtil.getReferer(backPage, request.getContextPath());
			request.getSession().setAttribute("BACK_PAGE", backPage);
		}
		return mav;
	}
	
	@RequestMapping(value = "/login.html", method = RequestMethod.POST)
	public ModelAndView login(ModelAndView mav,  
			MembersDO membersDO, 
			HttpServletRequest request,
			HttpServletResponse response) {
		
		String backPage = (String) request.getSession().getAttribute("BACK_PAGE");
		System.out.println(backPage);
		String loginIP = GetHttpMemberInfo.getIpAddr(request);
		
		MD5 md5 = new MD5();
		String md5Pwd = md5.getMD5ofStr(membersDO.getwMPassword() 
				+ membersDO.getwMMobile());
		
		membersDO.setwMPassword(md5Pwd);
		membersDO.setwMLoginIp(loginIP);
		System.out.println(membersDO.getwMMobile() + ":" + membersDO.getwMPassword());
		ResultDO resultDO = memberService.validate(membersDO);
		System.out.println(resultDO);
		if(resultDO.isSuccess()) {
			membersDO = (MembersDO) resultDO.getModel(ResultSupport.FIRST_MODEL_KEY);
			//request.getSession().setAttribute("MEMBER_ID", membersDO.getId());
			//request.getSession().setAttribute("MEMBER_MOBILE", membersDO.getwMMobile());
			addCookie(response, "MEMBER_ID", membersDO.getId() + "", 86400);
			addCookie(response, "MEMBER_MOBILE", membersDO.getwMMobile() + "", 86400 );
			
			if(backPage == null) {
				return new ModelAndView("redirect:/");
			}
			if(backPage.indexOf("register") != -1) {
				return new ModelAndView("redirect:/");
			} else {
				return new ModelAndView("redirect:/" + backPage + ".html");
			}
		} else {
			mav.addObject("ERROR_INFO", "用户名或者密码错误!");
			mav.setViewName("members/login");
		}
		return mav;
	}
	
	@RequestMapping(value = "/loginout.html", method = RequestMethod.GET)
	public ModelAndView loginOut(ModelAndView mav, 
			HttpServletRequest request,
			HttpServletResponse response) {
		removeCookie(response, "MEMBER_ID");
		removeCookie(response, "MEMBER_MOBILE");
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/accountPassword.html", method = RequestMethod.GET)
	public ModelAndView editPwd(ModelAndView mav,  
			HttpServletRequest request) {
		mav.setViewName("members/accountPassword");
		return mav; 
	}
	
	@RequestMapping(value = "/accountPassword.html", method = RequestMethod.POST)
	public ModelAndView editPwd(ModelAndView mav,  
			MembersDO membersDO, HttpServletRequest request) {
		Cookie cookie = getCookieByName(request, "MEMBER_ID");
		Integer memberId = Integer.parseInt(cookie.getValue());
		cookie = getCookieByName(request, "MEMBER_MOBILE");
		String memberMobile = cookie.getValue();
		membersDO.setId(memberId);
		MD5 md5 = new MD5();
		
		String md5Pwd = md5.getMD5ofStr(membersDO.getOldPassword() 
				+ memberMobile);
		membersDO.setOldPassword(md5Pwd);
		System.out.println(membersDO.getId() + ":" + membersDO.getOldPassword());
		
		md5Pwd = md5.getMD5ofStr(membersDO.getwMPassword() 
				+ memberMobile);
		membersDO.setwMPassword(md5Pwd);
		membersDO.setModifiAuthor(memberMobile);
		System.out.println(membersDO.getId() + ":" + membersDO.getwMPassword());
		ResultDO resultDO = memberService.modifiPwd(membersDO);
		if(resultDO.isSuccess()) {
			return new ModelAndView("redirect:/members/accountInfo.html");
		} else {
			mav.addObject("ERROR_INFO", "修改密码错误，请检查旧密码是否正确");
			mav.setViewName("members/accountPassword");
		}
		
		return mav; 
	
	}
	
	@RequestMapping(value = "/accountInfo.html", method = RequestMethod.GET)
	public ModelAndView accountInfo(ModelAndView mav, 
			HttpServletRequest request) {
		Cookie cookie = getCookieByName(request, "MEMBER_ID");
		
		if(cookie == null) {
			return new ModelAndView("redirect:/members/login.html");
		} 
		Integer memberId = Integer.parseInt(cookie.getValue());
		ResultDO resultDO = memberService.get(memberId);
		if(resultDO.isSuccess()) {
			mav.addObject("MEMBER_INFO", resultDO.getModel(ResultSupport.FIRST_MODEL_KEY));
			mav.setViewName("members/accountInfo");
		} else {
			return new ModelAndView("redirect:/members/login.html");
		}
		
		return mav; 
	}
	
	@RequestMapping(value = "/change.html", method = RequestMethod.POST)
	public ModelAndView change(ModelAndView mav, 
			MemberDetailDO memberDetailDO,
			HttpServletRequest request) {

		ResultDO resultDO = memberService.modifi(memberDetailDO);	
		if(resultDO.isSuccess()) {
			mav.setViewName("members/accountInfo");
		} else {
			mav.setViewName("error");
		}
		
		return mav; 
	}
	
	
	
	@RequestMapping(value = "/getCode/{mobile}.json", method = RequestMethod.GET)
	public ModelAndView ajaxGetCode(ModelAndView mav,
			@PathVariable(value="mobile") String mobile,
			HttpServletRequest request) {
		
		SmsCodeDO smsCodeDO = new SmsCodeDO();
		smsCodeDO.setwSmMobile(mobile);
		smsCodeDO.setCreateAuthor(mobile);
		smsCodeDO.setwSmTempKey(Constant.SMS_MOBILE_VAIDATE_KEY);
		ResultDO  resultDO = smsService.create(smsCodeDO);
		if(resultDO.isSuccess()) {
			mav.addObject("JSON_DATA", resultDO.getModel(ResultSupport.FIRST_MODEL_KEY));
		} else {
			mav.addObject("JSON_DATA", "0");
		}
		
		return mav;
	}
	
	@RequestMapping(value = "/vaidateMobile/{mobile}/{smsCode}.json", method = RequestMethod.GET)
	public ModelAndView ajaxMobileVaidate(ModelAndView mav,
			@PathVariable(value="mobile") String mobile,
			@PathVariable(value="smsCode") String smsCode,
			HttpServletRequest request) {
		
		SmsCodeQuery smsCodeQuery = new SmsCodeQuery();
		smsCodeQuery.setMobile(mobile);
		smsCodeQuery.setCode(smsCode);
		
		ResultDO resultDO = smsService.validate(smsCodeQuery);
		
		if(resultDO.isSuccess()) {
			mav.addObject("JSON_DATA", "1");
		} else {
			mav.addObject("JSON_DATA", "0");
		}
		
		return mav;
	}
	
	@RequestMapping(value = "/checkMobile/{mobile}.json", method = RequestMethod.GET)
	public ModelAndView ajaxCheckMobile(ModelAndView mav,
			@PathVariable(value="mobile") String mobile,
			HttpServletRequest request) {
		
		MembersQuery query = new MembersQuery();
		
		query.setMobile(mobile);
		
		ResultDO result = memberService.isMobileReg(query);
		
		if(result.isSuccess()) {
			mav.addObject("JSON_DATA", 1);
		} else {
			mav.addObject("JSON_DATA", 0);
		}
		
		return mav;
	}
	
	@RequestMapping(value = "/contacts.json", method = RequestMethod.GET)
	public ModelAndView contacts(ModelAndView mav, HttpServletRequest request) {
		
		Cookie cookie = getCookieByName(request, "MEMBER_ID");
		Integer memberId = Integer.parseInt(cookie.getValue());
		ContactQuery query = new ContactQuery();
		query.setMemberId(memberId);
		ResultDO resultDO = contactService.list(query);
		System.out.println(resultDO);
		if(resultDO.isSuccess()) {
			String html = "";
			List<ContactDO> list = (List<ContactDO>) resultDO.getModel(ResultSupport.FIRST_MODEL_KEY);
			for(ContactDO contactDO : list) {
				if(contactDO.getwCDefault() != 1) {
					html = html + "<ul><li class=\"choose-2\" onClick=\"onDefault(" + contactDO.getId() + ") \" id=\"c" + contactDO.getId() + "\"><div class=\"choose-con1\">"
							+ "<span>" + contactDO.getwCAddress() + "</span>"
							+ "<span>" + contactDO.getwCContact() + "</span>"
							+ "<span>" + contactDO.getwCTelephone() + "</span>"
							+ "<a href=\"javascript:void(0);\" class=\"del\" style=\"float: right;margin-top: -20px;\" onclick=\"del(" + contactDO.getId() + ");\" >删除地址</a>"
							+ "</div><div class=\"choose-con2\">重庆</div></li></ul></div>";
				} else {
					html = html + "<ul><li onClick=\"onDefault(" + contactDO.getId() + ") \" id=\"c" + contactDO.getId() + "\"><div class=\"choose-con1\">"
						+ "<span>" + contactDO.getwCAddress() + "</span>"
						+ "<span>" + contactDO.getwCContact() + "</span>"
						+ "<span>" + contactDO.getwCTelephone() + "</span>"
						+ "<a href=\"javascript:void(0);\" class=\"del\" style=\"float: right;margin-top: -20px;\" onclick=\"del(" + contactDO.getId() + ");\" >删除地址</a>"
						+ "</div><div class=\"choose-con2\">重庆</div></li></ul></div>";
				}
				
			}
			mav.addObject("JSON_DATA", html);
		} else {
			mav.addObject("JSON_DATA", 0);
			return mav;
		}
		return mav;
	}
	
	@RequestMapping(value = "/addContact.html", method = RequestMethod.GET)
	public ModelAndView addContact(ModelAndView mav, HttpServletRequest request) {
		mav.setViewName("members/addContact");
		return mav;
	}
	
	@RequestMapping(value = "/addContact.html", method = RequestMethod.POST)
	public ModelAndView addContact(ModelAndView mav, ContactDO contactDO, HttpServletRequest request) {
		
		Cookie cookie = getCookieByName(request, "MEMBER_ID");
		Integer memberId = Integer.parseInt(cookie.getValue());
		cookie = getCookieByName(request, "MEMBER_MOBILE");
		String memberMobile = cookie.getValue();
		contactDO.setwCMembersId(memberId);
		contactDO.setCreateAuthor(memberMobile);
		contactDO.setwCDefault(1);
		ResultDO result = contactService.create(contactDO);
		if(result.isSuccess()) {
			return new ModelAndView("redirect:/goods/buyJob.html");
		} else {
			mav.setViewName("error");
		}
		
		return mav;
	}
	
	@RequestMapping(value = "/removeContact/{id}.json", method = RequestMethod.GET)
	public ModelAndView remove(ModelAndView mav, 
			@PathVariable(value="id") Integer id,
			HttpServletRequest request) {
		
		
		ResultDO result = contactService.remove(id);
		
		if(result.isSuccess()) {
			
			mav.addObject("JSON_DATA", 1);
		} else {
			
			mav.addObject("JSON_DATA", 0);
		}
		return mav;
	}
	
	@RequestMapping(value = "/default/{id}.json", method = RequestMethod.GET)
	public ModelAndView ajaxContactDefault(ModelAndView mav, 
			@PathVariable(value="id") Integer id,
			HttpServletRequest request) {
		Cookie cookie = getCookieByName(request, "MEMBER_ID");
		Integer memberId = Integer.parseInt(cookie.getValue());
		cookie = getCookieByName(request, "MEMBER_MOBILE");
		String memberMobile = cookie.getValue();
		ContactDO contactDO = new ContactDO();
		contactDO.setwCMembersId(memberId);
		contactDO.setId(id);
		contactDO.setModifiAuthor(memberMobile);
		ResultDO result = contactService.setDefault(contactDO);
		
		if(result.isSuccess()) {
			mav.addObject("JSON_DATA", 1);
		} else {
			mav.addObject("JSON_DATA", 0);
		}
		return mav;
	}
	
	
	
	@RequestMapping(value = "/restPwd.html", method = RequestMethod.GET)
	public ModelAndView restPwd(ModelAndView mav, HttpServletRequest request) {
		mav.setViewName("members/resetPwd");
		return mav;
	}
	
	@RequestMapping(value = "/restPwd.html", method = RequestMethod.POST)
	public ModelAndView restPwd(ModelAndView mav, MembersDO membersDO, 
			HttpServletRequest request) {
		
		MD5 md5 = new MD5();
		String md5Pwd = md5.getMD5ofStr(membersDO.getwMPassword() 
				+ membersDO.getwMMobile());
		membersDO.setwMPassword(md5Pwd);
		membersDO.setModifiAuthor(membersDO.getwMMobile());
	
		ResultDO resultDO = memberService.modifiPwd(membersDO);
		membersDO.setwMPassword(md5Pwd);
		if(resultDO.isSuccess()) {
			mav.setViewName("members/login");
		} else {
			mav.setViewName("error");
		}
		return mav;
	}
	
	@RequestMapping(value = "/rule.html", method = RequestMethod.GET)
	public ModelAndView rule(ModelAndView mav, HttpServletRequest request) {
		mav.setViewName("members/rule");
		return mav;
	}
	
	@RequestMapping(value = "/couponList.html", method = RequestMethod.GET)
	public ModelAndView couponList(ModelAndView mav, HttpServletRequest request) {
		Cookie cookie = getCookieByName(request, "MEMBER_ID");
		
		if(cookie == null) {
			return new ModelAndView("redirect:/members/login.html");
		} 
		Integer memberId = Integer.parseInt(cookie.getValue());
		ResultDO resultDO = memberService.get(memberId);
		if(resultDO.isSuccess()) {
			MembersDO membersDO = (MembersDO) resultDO.getModel(ResultSupport.FIRST_MODEL_KEY);
			List<MemberCouponDO> memberCouponDOList = membersDO.getMemberCoupons();
			if(memberCouponDOList != null) {
				mav.addObject("MEMBER_COUPON_SIZE", memberCouponDOList.size());
				mav.addObject("MEMBER_COUPON_LIST", memberCouponDOList);
			} else {
				mav.addObject("MEMBER_COUPON_SIZE", 0);
				mav.addObject("MEMBER_COUPON_LIST", new ArrayList<MemberCouponDO>());
			}
			mav.setViewName("members/couponList");
		} else {
			mav.setViewName("error");
		}
		return mav;
	}

}
