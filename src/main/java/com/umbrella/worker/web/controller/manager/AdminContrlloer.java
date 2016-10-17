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
import com.umbrella.worker.query.SupplierQuery;
import com.umbrella.worker.result.JsonResultDO;
import com.umbrella.worker.result.JsonResultSupport;
import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.result.ResultSupport;
import com.umbrella.worker.service.IAdminService;
import com.umbrella.worker.service.ISuppliersService;
import com.umbrella.worker.util.MD5;
import com.umbrella.worker.util.PageBeanUtil;
import com.umbrella.worker.util.StringUtil;

@Controller
@RequestMapping(value = "/admin")
public class AdminContrlloer {

	@Autowired
	public IAdminService adminService;
	
	@Autowired
	private ISuppliersService suppliersService;
	
	@RequestMapping(value = "/add.html", method = RequestMethod.GET)
	public ModelAndView add(ModelAndView mav, 
			HttpServletRequest request) {
		
		SupplierQuery query = new SupplierQuery();
		ResultDO result = suppliersService.list(query);
		if(result.isSuccess()) {
			mav.addObject("SUPPLIER_LIST", result.getModel(ResultSupport.FIRST_MODEL_KEY));
			mav.setViewName("manager/admin/add");
		} else {
			mav.setViewName("error");
		}
		return mav; 
	}
	
	@RequestMapping(value = "/add.json", method = RequestMethod.POST)
	public ModelAndView add(ModelAndView mav,
			AdminDO adminDO,
			HttpServletRequest request) {
		
		JsonResultDO jsonResultDO = new JsonResultSupport();
		
		adminDO.setCreateAuthor((String) request.getSession().getAttribute("MANAGER_NAME"));
		adminDO.setModifiAuthor(adminDO.getCreateAuthor());
		MD5 md5 = new MD5();
		String md5Pwd = md5.getMD5ofStr(adminDO.getwAPassword() 
				+ adminDO.getwAUsername());
		
		adminDO.setwAPassword(md5Pwd);
		
		ResultDO result = adminService.create(adminDO);
		
		if(result.isSuccess()) {
			jsonResultDO.setInfo("提交成功");
			jsonResultDO.setStatus(JsonResultDO.JSON_SUCCESS);
			mav.addObject("JSON_DATA", jsonResultDO);
		} else {
			jsonResultDO.setInfo("提交失败");
			jsonResultDO.setStatus(JsonResultDO.JSON_FAILED);
			mav.addObject("JSON_DATA", jsonResultDO);
		}
		return mav;
	}
	
	@RequestMapping(value = "/remove/{id}.json", method = RequestMethod.GET)
	public ModelAndView remove(ModelAndView mav, 
			@PathVariable(value="id") Integer id,
			HttpServletRequest request) {
		JsonResultDO jsonResultDO = new JsonResultSupport();
		
		ResultDO result = adminService.remove(id);
		
		if(result.isSuccess()) {
			jsonResultDO.setInfo("提交成功");
			jsonResultDO.setStatus(JsonResultDO.JSON_SUCCESS);
			mav.addObject("JSON_DATA", jsonResultDO);
		} else {
			jsonResultDO.setInfo("提交失败");
			jsonResultDO.setStatus(JsonResultDO.JSON_FAILED);
			mav.addObject("JSON_DATA", jsonResultDO);
		}
		return mav;
	}
	
	@RequestMapping(value = "/stop/{id}.json", method = RequestMethod.GET)
	public ModelAndView stop(ModelAndView mav, 
			@PathVariable(value="id") Integer id,
			HttpServletRequest request) {
		JsonResultDO jsonResultDO = new JsonResultSupport();
		AdminDO adminDO = new AdminDO();
		
		adminDO.setId(id);
		adminDO.setStatus(0);
		ResultDO result = adminService.modifi(adminDO);
		
		if(result.isSuccess()) {
			jsonResultDO.setInfo("提交成功");
			jsonResultDO.setStatus(JsonResultDO.JSON_SUCCESS);
			mav.addObject("JSON_DATA", jsonResultDO);
		} else {
			jsonResultDO.setInfo("提交失败");
			jsonResultDO.setStatus(JsonResultDO.JSON_FAILED);
			mav.addObject("JSON_DATA", jsonResultDO);
		}
		return mav;
	}
	
	@RequestMapping(value = "/start/{id}.json", method = RequestMethod.GET)
	public ModelAndView start(ModelAndView mav, 
			@PathVariable(value="id") Integer id,
			HttpServletRequest request) {
		JsonResultDO jsonResultDO = new JsonResultSupport();
		AdminDO adminDO = new AdminDO();
		
		adminDO.setId(id);
		adminDO.setStatus(1);
		ResultDO result = adminService.modifi(adminDO);
		
		if(result.isSuccess()) {
			jsonResultDO.setInfo("提交成功");
			jsonResultDO.setStatus(JsonResultDO.JSON_SUCCESS);
			mav.addObject("JSON_DATA", jsonResultDO);
		} else {
			jsonResultDO.setInfo("提交失败");
			jsonResultDO.setStatus(JsonResultDO.JSON_FAILED);
			mav.addObject("JSON_DATA", jsonResultDO);
		}
		return mav;
	}
	
	@RequestMapping(value = "/detail/{id}.html", method = RequestMethod.GET)
	public ModelAndView detail(ModelAndView mav, 
			@PathVariable(value="id") Integer id,
			HttpServletRequest request) {
		
		
		
		SupplierQuery query = new SupplierQuery();
		ResultDO  result = suppliersService.list(query);
		if(result.isSuccess()) {
			mav.addObject("SUPPLIER_LIST", result.getModel(ResultSupport.FIRST_MODEL_KEY));
			mav.setViewName("manager/admin/add");
		} else {
			mav.setViewName("error");
		}
		
		result = adminService.get(id);
		if(result.isSuccess()) {
			mav.addObject("MANAGER_INFO", (AdminDO) result.getModel(ResultSupport.FIRST_MODEL_KEY));
			mav.setViewName("manager/admin/detail");
		} else {
			mav.setViewName("error");
		}
		return mav;
	}
	
	@RequestMapping(value = "/edit.json", method = RequestMethod.POST)
	public ModelAndView edit(ModelAndView mav,
			AdminDO adminDO,
			HttpServletRequest request) {
		
		JsonResultDO jsonResultDO = new JsonResultSupport();
		
		adminDO.setModifiAuthor((String) request.getSession().getAttribute("MANAGER_NAME"));
		
		
		if(StringUtil.isEmpty(adminDO.getwAPassword())) {
			MD5 md5 = new MD5();
			String md5Pwd = md5.getMD5ofStr(adminDO.getwAPassword() 
					+ adminDO.getwAUsername());
			
			adminDO.setwAPassword(md5Pwd);
		}
		
		ResultDO result = adminService.modifi(adminDO);
		
		if(result.isSuccess()) {
			jsonResultDO.setInfo("提交成功");
			jsonResultDO.setStatus(JsonResultDO.JSON_SUCCESS);
			mav.addObject("JSON_DATA", jsonResultDO);
		} else {
			jsonResultDO.setInfo("提交失败");
			jsonResultDO.setStatus(JsonResultDO.JSON_FAILED);
			mav.addObject("JSON_DATA", jsonResultDO);
		}
		return mav;
	}
	
	@RequestMapping(value = "/list/{username}/{pageNo}.html", method = RequestMethod.GET)
	public ModelAndView query(ModelAndView mav,
			@PathVariable(value="username") String username,
			@PathVariable(value="pageNo") Integer pageNo,
			HttpServletRequest request) {
		
		AdminQuery query = new AdminQuery();
		query.setPage(true);
		query.setPageNO(pageNo);
		query.setPageRows(10);
		if(!username.equals("all")) {
			query.setUsername(username);
		}
		
		ResultDO result = adminService.list(query);
		System.out.println(result);
		if(result.isSuccess()) {
			PageBeanUtil pageBean = new PageBeanUtil();
			long count = (Long) result.getModel(ResultSupport.SECOND_MODEL_KEY);
			pageBean.setCurrentPage(pageNo);
			pageBean.setPageSize(query.getPageRows());
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
