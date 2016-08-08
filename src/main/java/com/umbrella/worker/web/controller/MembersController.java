package com.umbrella.worker.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.umbrella.worker.dto.MemberDetailDO;
import com.umbrella.worker.dto.MembersDO;
import com.umbrella.worker.dto.SmsCodeDO;
import com.umbrella.worker.query.MembersQuery;
import com.umbrella.worker.query.SmsCodeQuery;
import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.result.ResultSupport;
import com.umbrella.worker.service.IMemberService;
import com.umbrella.worker.service.ISmsService;
import com.umbrella.worker.util.Constant;
import com.umbrella.worker.util.GetHttpMemberInfo;
import com.umbrella.worker.util.MD5;

@Controller
@RequestMapping(value = "/members")
public class MembersController {
	
	@Autowired
	private IMemberService memberService;
	
	@Autowired
	private ISmsService smsService;

	@RequestMapping(value = "/register.html", method = RequestMethod.GET)
	public ModelAndView register(ModelAndView mav, HttpServletRequest request) {
		mav.setViewName("members/register");
		String backPage = request.getHeader("Referer");
		request.getSession().setAttribute("BACK_PAGE", backPage);
		return mav;
	}
	
	@RequestMapping(value = "/register.html", method = RequestMethod.POST)
	public ModelAndView register(ModelAndView mav, 
			MembersDO membersDO, HttpServletRequest request) {
		
		String backPage = (String) request.getSession().getAttribute("BACK_PAGE");
		
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
			request.getSession().setAttribute("MEMBER_ID", resultDO.getModel(ResultSupport.FIRST_MODEL_KEY));
			mav.setViewName(backPage);
		} else {
			mav.setViewName("errer");
		}
		return mav;
	}
	
	@RequestMapping(value = "/login.html", method = RequestMethod.GET)
	public ModelAndView login(ModelAndView mav, HttpServletRequest request) {
		mav.setViewName("members/login");
		String backPage = request.getHeader("Referer");
		request.getSession().setAttribute("BACK_PAGE", backPage);
		return mav;
	}
	
	@RequestMapping(value = "/login.html", method = RequestMethod.POST)
	public ModelAndView login(ModelAndView mav,  
			MembersDO membersDO, HttpServletRequest request) {
		
		String backPage = (String) request.getSession().getAttribute("BACK_PAGE");
		
		String loginIP = GetHttpMemberInfo.getIpAddr(request);
		
		MD5 md5 = new MD5();
		String md5Pwd = md5.getMD5ofStr(membersDO.getwMPassword() 
				+ membersDO.getwMMobile());
		
		membersDO.setwMPassword(md5Pwd);
		membersDO.setwMLoginIp(loginIP);
		
		ResultDO resultDO = memberService.validate(membersDO);
		
		if(resultDO.isSuccess()) {
			membersDO = (MembersDO) resultDO.getModel(ResultSupport.FIRST_MODEL_KEY);
			request.getSession().setAttribute("MEMBER_ID", membersDO.getId());
			mav.setViewName(backPage);
		} else {
			mav.setViewName("error");
		}
		return mav;
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
		
		if(!membersDO.getRePassword()
				.equals(membersDO.getwMPassword())) {
			mav.setViewName("members/accountPassword");
		}
		
		MD5 md5 = new MD5();
		String md5Pwd = md5.getMD5ofStr(membersDO.getwMPassword() 
				+ membersDO.getwMMobile());
		membersDO.setwMPassword(md5Pwd);
		ResultDO resultDO = memberService.modifiPwd(membersDO);
		
		if(resultDO.isSuccess()) {
			mav.setViewName("members/login");
		} else {
			mav.setViewName("error");
		}
		
		return mav; 
	}
	
	@RequestMapping(value = "/accountInfo.html", method = RequestMethod.GET)
	public ModelAndView accountInfo(ModelAndView mav, 
			HttpServletRequest request) {
		
		Integer id = (Integer) request.getSession().getAttribute("MEMBER_ID");
		ResultDO resultDO = memberService.get(id);
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
	
	@RequestMapping(value = "/getCode/{mobile}/{vcode}.json", method = RequestMethod.GET)
	public ModelAndView ajaxGetCode(ModelAndView mav,
			@PathVariable(value="mobile") String mobile,
			@PathVariable(value="vcode") String vcode,
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
}
