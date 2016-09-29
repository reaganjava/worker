package com.umbrella.worker.web.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.umbrella.worker.dto.ContactDO;
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
import com.umbrella.worker.service.IMemberService;
import com.umbrella.worker.service.ISmsService;
import com.umbrella.worker.util.Constant;
import com.umbrella.worker.util.GetHttpMemberInfo;
import com.umbrella.worker.util.MD5;
import com.umbrella.worker.util.StringUtil;

@Controller
@RequestMapping(value = "/members")
public class MembersController {
	
	@Autowired
	private IMemberService memberService;
	
	@Autowired
	private ISmsService smsService;
	
	@Autowired
	private IContactService contactService;

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
			return new ModelAndView("redirect:/members/login.html");
		} else {
			mav.setViewName("errer");
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
			MembersDO membersDO, HttpServletRequest request) {
		
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
			request.getSession().setAttribute("MEMBER_ID", membersDO.getId());
			request.getSession().setAttribute("MEMBER_MOBILE", membersDO.getwMMobile());
			if(backPage == null) {
				return new ModelAndView("redirect:/");
			}
			if(backPage.indexOf("register") != -1) {
				return new ModelAndView("redirect:/");
			} else {
				return new ModelAndView("redirect:/" + backPage + ".html");
			}
		} else {
			mav.setViewName("error");
		}
		return mav;
	}
	
	@RequestMapping(value = "/loginout.html", method = RequestMethod.GET)
	public ModelAndView loginOut(ModelAndView mav, 
			HttpServletRequest request) {
		request.getSession().removeAttribute("MEMBER_ID");
		request.getSession().removeAttribute("MEMBER_MOBILE");
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
		
		Integer memberId = (Integer) request.getSession().getAttribute("MEMBER_ID");
		String memberMobile = (String) request.getSession().getAttribute("MEMBER_MOBILE");
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
			mav.setViewName("error");
		}
		
		return mav; 
	
	}
	
	@RequestMapping(value = "/accountInfo.html", method = RequestMethod.GET)
	public ModelAndView accountInfo(ModelAndView mav, 
			HttpServletRequest request) {
		
		Integer memberId = (Integer) request.getSession().getAttribute("MEMBER_ID");
		if(memberId == null) {
			return new ModelAndView("redirect:/members/login.html");
		}
		ResultDO resultDO = memberService.get(memberId);
		if(resultDO.isSuccess()) {
			mav.addObject("MEMBER_INFO", resultDO.getModel(ResultSupport.FIRST_MODEL_KEY));
			mav.setViewName("members/accountInfo");
		} else {
			mav.setViewName("error");
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
	
	@RequestMapping(value = "/contacts.html", method = RequestMethod.GET)
	public ModelAndView contacts(ModelAndView mav, HttpServletRequest request) {
		
		Integer memberId = (Integer) request.getSession().getAttribute("MEMBER_ID");
		ContactQuery query = new ContactQuery();
		query.setMemberId(memberId);
		ResultDO resultDO = contactService.list(query);
		System.out.println(resultDO);
		if(resultDO.isSuccess()) {
			mav.addObject("CONTACT_LIST", resultDO.getModel(ResultSupport.FIRST_MODEL_KEY));
			mav.setViewName("members/contacts");
		} else {
			mav.setViewName("error");
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
	public ModelAndView contacts(ModelAndView mav, ContactDO contactDO, HttpServletRequest request) {
		
		Integer memberId = (Integer) request.getSession().getAttribute("MEMBER_ID");
		String memberMobile = (String) request.getSession().getAttribute("MEMBER_MOBILE");
		contactDO.setwCMembersId(memberId);
		contactDO.setCreateAuthor(memberMobile);
		contactDO.setwCDefault(1);
		ResultDO result = contactService.create(contactDO);
		if(result.isSuccess()) {
			request.getSession().setAttribute("CONTACT_DEFAULT", contactDO);
			return new ModelAndView("redirect:/members/contacts.html");
		} else {
			mav.setViewName("error");
		}
		
		return mav;
	}
	
	@RequestMapping(value = "/default/{id}.json", method = RequestMethod.GET)
	public ModelAndView ajaxContactDefault(ModelAndView mav, 
			@PathVariable(value="id") Integer id,
			HttpServletRequest request) {
		
		ResultDO result = contactService.setDefault(id);
		
		if(result.isSuccess()) {
			request.getSession().setAttribute("CONTACT_DEFAULT", result.getModel(ResultSupport.FIRST_MODEL_KEY));
			mav.addObject("JSON_DATA", 1);
		} else {
			mav.addObject("JSON_DATA", 0);
		}
		return mav;
	}
	
	@RequestMapping(value = "/getDefault.json", method = RequestMethod.GET)
	public ModelAndView ajaxDefault(ModelAndView mav, 
			HttpServletRequest request) {
		
		ContactQuery query = new ContactQuery();
		Integer memberId = (Integer) request.getSession().getAttribute("MEMBER_ID");
		
		if(memberId == null) {
			return new ModelAndView("redirect:/members/login.html");
		}
		query.setMemberId(memberId);
		//query.setIsDefault(1);
		ResultDO result = contactService.list(query);
		
		
		if(result.isSuccess()) {
			List<ContactDO> list = (List<ContactDO>) result.getModel(ResultSupport.FIRST_MODEL_KEY);
			for()
			String html = "<p>服务地址：" + list.get(0).getwCAddress() + "</p><p>联系人："+ list.get(0).getwCContact() +"</p><p>联系电话："+ list.get(0).getwCTelephone() + "</p>";
			
			mav.addObject("JSON_DATA", html);
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
	
	
}
