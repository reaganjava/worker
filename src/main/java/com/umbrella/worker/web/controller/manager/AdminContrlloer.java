package com.umbrella.worker.web.controller.manager;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.umbrella.worker.dto.AdminDO;
import com.umbrella.worker.query.AdminQuery;
import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.result.ResultSupport;
import com.umbrella.worker.service.IAdminService;
import com.umbrella.worker.util.MD5;
import com.umbrella.worker.util.PageBeanUtil;
import com.umbrella.worker.util.StringUtil;

@Controller
@RequestMapping(value = "/admin")
public class AdminContrlloer {

	@Autowired
	public IAdminService adminService;
	
	@RequestMapping(value = "/add.html", method = RequestMethod.GET)
	public ModelAndView add(ModelAndView mav, 
			HttpServletRequest request) {
		mav.setViewName("manager/admin/add");
		return mav;
	}
	
	@RequestMapping(value = "/add.html", method = RequestMethod.POST)
	public ModelAndView add(ModelAndView mav,
			AdminDO adminDO,
			HttpServletRequest request) {
		
		
		adminDO.setCreateAuthor((String) request.getSession().getAttribute("ADMIN_NAME"));
		
		MD5 md5 = new MD5();
		String md5Pwd = md5.getMD5ofStr(adminDO.getwAPassword() 
				+ adminDO.getwAUsername());
		
		adminDO.setwAPassword(md5Pwd);
		
		ResultDO resultDO = adminService.create(adminDO);
		
		if(resultDO.isSuccess()) {
			mav.setViewName("success");
		} else {
			mav.setViewName("error");
		}
		return mav;
	}
	
	@RequestMapping(value = "/detail/{id}.html", method = RequestMethod.GET)
	public ModelAndView detail(ModelAndView mav, 
			@PathVariable(value="id") Integer id,
			HttpServletRequest request) {
		
		ResultDO result = adminService.get(id);
		
		if(result.isSuccess()) {
			mav.addObject("ADMIN_INFO", (AdminDO) result.getModel(ResultSupport.FIRST_MODEL_KEY));
			mav.setViewName("manager/admin/detail");
		} else {
			mav.setViewName("error");
		}
		return mav;
	}
	
	@RequestMapping(value = "/edit.html", method = RequestMethod.POST)
	public ModelAndView edit(ModelAndView mav,
			AdminDO adminDO,
			HttpServletRequest request) {
		
		adminDO.setModifiAuthor((String) request.getSession().getAttribute("ADMIN_NAME"));
		
		
		if(StringUtil.isEmpty(adminDO.getwAPassword())) {
			MD5 md5 = new MD5();
			String md5Pwd = md5.getMD5ofStr(adminDO.getwAPassword() 
					+ adminDO.getwAUsername());
			
			adminDO.setwAPassword(md5Pwd);
		}
		
		ResultDO result = adminService.modifi(adminDO);
		
		if(result.isSuccess()) {
			return new ModelAndView("redirect:/manager/admin/detail/+ " + adminDO.getId() + ".html");
		} else {
			mav.setViewName("error");
		}
		return mav;
		
	}
	
	@RequestMapping(value = "/list/{username}/{pageNo}.html", method = RequestMethod.POST)
	public ModelAndView query(ModelAndView mav,
			@PathVariable(value="username") String username,
			@PathVariable(value="pageNo") Integer pageNo,
			HttpServletRequest request) {
		
		AdminQuery query = new AdminQuery();
		query.setPage(true);
		query.setPageNO(pageNo);
		ResultDO result = adminService.list(query);
		
		if(result.isSuccess()) {
			PageBeanUtil pageBean = new PageBeanUtil();
			long count = (Long) result.getModel(ResultSupport.SECOND_MODEL_KEY);
			pageBean.setCurrentPage(pageNo);
			pageBean.setPageSize(18);
			pageBean.setRecordCount(count);
			pageBean.setPageCount(count);
			pageBean.setPages(pageNo);
			pageBean.setDataList((List<Object>) result.getModel(ResultSupport.FIRST_MODEL_KEY));
			mav.addObject("PAGE_BEAN", pageBean);
			mav.setViewName("manager/admin/list");
		} else {
			mav.setViewName("error");
		}
		return mav;
		
	}
	
	
}
