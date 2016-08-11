package com.umbrella.worker.web.controller.manager;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.umbrella.worker.result.ResultSupport;
import com.umbrella.worker.dto.AdminDO;
import com.umbrella.worker.query.MenuQuery;
import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.service.IAdminService;
import com.umbrella.worker.service.IMenuService;
import com.umbrella.worker.util.GetHttpMemberInfo;
import com.umbrella.worker.util.MD5;

@Controller
@RequestMapping(value = "/manager")
public class ManagerContrlloer {
	
	@Autowired
	private IMenuService menuService;
	
	@Autowired
	private IAdminService adminService;


	@RequestMapping(value = "/login.html", method = RequestMethod.GET)
	public ModelAndView login(ModelAndView mav, 
			HttpServletRequest request) {
		mav.setViewName("manager/login");
		return mav;
	}
	
	@RequestMapping(value = "/login.html", method = RequestMethod.POST)
	public ModelAndView login(ModelAndView mav, 
			AdminDO adminDO, HttpServletRequest request) {
		
		String verityCode = (String) request.getSession().getAttribute("VERITY_CODE");
		
		if(!adminDO.getVcode().equals(verityCode)) {
			mav.setViewName("manager/login");
		}
		
		String loginIP = GetHttpMemberInfo.getIpAddr(request);
		adminDO.setwALoginIp(loginIP);
		
		MD5 md5 = new MD5();
		String md5Pwd = md5.getMD5ofStr(adminDO.getwAPassword() 
				+ adminDO.getwAUsername());
		
		adminDO.setwAPassword(md5Pwd);
		
		
		ResultDO result = adminService.validate(adminDO);

		if(result.isSuccess()) {
			adminDO = (AdminDO) result.getModel(ResultSupport.FIRST_MODEL_KEY);
			request.getSession().setAttribute("MANAGER_ID", adminDO.getId());
			request.getSession().setAttribute("MANAGER_NAME", adminDO.getwAUsername());
			request.getSession().setAttribute("MANAGER_ROLE_ID", adminDO.getwARoleId());
			request.getSession().setAttribute("MANAGER_SUPPLIER_ID", adminDO.getwASupplierId());
			return new ModelAndView("redirect:/manager/index.html");
		} else {
			mav.setViewName("manager/login");
		}
		return mav;
	}
	
	@RequestMapping(value = "/loginout.html", method = RequestMethod.GET)
	public ModelAndView loginOut(ModelAndView mav, 
			HttpServletRequest request) {
		request.getSession().removeAttribute("MANAGER_ID");
		request.getSession().removeAttribute("MANAGER_NAME");
		request.getSession().removeAttribute("MANAGER_ROLE_ID");
		request.getSession().removeAttribute("MANAGER_SUPPLIER_ID");
		return new ModelAndView("redirect:/manager/login.html");
	}
	
	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView mav, 
			HttpServletRequest request) {
		
		Integer roleId = (Integer) request.getSession().getAttribute("MANAGER_ROLE_ID");
		
		if(roleId == null) {
			mav.setViewName("error");
			return mav;
		}
		
		MenuQuery query = new MenuQuery();
		query.setRoleId(roleId);
		
		
		ResultDO result = menuService.list(query);
		
		if(result.isSuccess()) {
			mav.addObject("MENU_LIST", result.getModel(ResultSupport.FIRST_MODEL_KEY));
			mav.setViewName("manager/index");
		} else {
			mav.setViewName("error");
		}
		mav.setViewName("manager/index");
		return mav;
	}
}
