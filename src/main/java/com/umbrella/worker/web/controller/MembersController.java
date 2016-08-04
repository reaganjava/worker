package com.umbrella.worker.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.umbrella.worker.dto.MembersDO;
import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.result.ResultSupport;
import com.umbrella.worker.service.IMemberService;
import com.umbrella.worker.util.GetHttpMemberInfo;
import com.umbrella.worker.util.MD5;

@Controller
@RequestMapping(value = "/members")
public class MembersController {
	
	@Autowired
	private IMemberService memberService;

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
			request.getSession().setAttribute("MEMBER_LOGIN_INFO", resultDO.getModel(ResultSupport.FIRST_MODEL_KEY));
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
			request.getSession().setAttribute("MEMBER_LOGIN_INFO", resultDO.getModel(ResultSupport.FIRST_MODEL_KEY));
			mav.setViewName(backPage);
		} else {
			mav.setViewName("error");
		}
		return mav;
	}
}
