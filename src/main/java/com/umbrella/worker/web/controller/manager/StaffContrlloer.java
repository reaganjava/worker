package com.umbrella.worker.web.controller.manager;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.umbrella.worker.dto.StaffDO;
import com.umbrella.worker.query.StaffQuery;
import com.umbrella.worker.query.SupplierQuery;
import com.umbrella.worker.result.JsonResultDO;
import com.umbrella.worker.result.JsonResultSupport;
import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.result.ResultSupport;
import com.umbrella.worker.service.IStaffService;
import com.umbrella.worker.service.ISuppliersService;
import com.umbrella.worker.util.PageBeanUtil;

@Controller
@RequestMapping(value = "/staff")
public class StaffContrlloer {

	@Autowired
	public IStaffService staffService;
	
	@Autowired
	private ISuppliersService suppliersService;
	
	@RequestMapping(value = "/add.html", method = RequestMethod.GET)
	public ModelAndView add(ModelAndView mav, 
			HttpServletRequest request) {
		SupplierQuery query = new SupplierQuery();
		ResultDO result = suppliersService.list(query);
		if(result.isSuccess()) {
			mav.addObject("SUPPLIER_LIST", result.getModel(ResultSupport.FIRST_MODEL_KEY));
			mav.setViewName("manager/staff/add");
		} else {
			mav.setViewName("error");
		}
		return mav; 
	}
	
	@RequestMapping(value = "/add.json", method = RequestMethod.POST)
	public ModelAndView add(ModelAndView mav,
			StaffDO staffDO,
			HttpServletRequest request) {
		
		JsonResultDO jsonResultDO = new JsonResultSupport();
		
		staffDO.setCreateAuthor((String) request.getSession().getAttribute("MANAGER_NAME"));
		
		ResultDO result = staffService.create(staffDO);
		
		if(result.isSuccess()) {
			jsonResultDO.setInfo("提交成功");
			jsonResultDO.setStatus(JsonResultDO.JSON_SUCCESS);
			mav.addObject("JSON_DATA", jsonResultDO);
		} else {
			jsonResultDO.setInfo("提交失败");
			jsonResultDO.setStatus(JsonResultDO.JSON_FAILED);
			mav.addObject("JSON_DATA", "error");
		}
		return mav;
	}
	
	@RequestMapping(value = "/remove/{id}.json", method = RequestMethod.GET)
	public ModelAndView remove(ModelAndView mav, 
			@PathVariable(value="id") Integer id,
			HttpServletRequest request) {
		JsonResultDO jsonResultDO = new JsonResultSupport();
		
		ResultDO result = staffService.remove(id);
		
		if(result.isSuccess()) {
			jsonResultDO.setInfo("提交成功");
			jsonResultDO.setStatus(JsonResultDO.JSON_SUCCESS);
			mav.addObject("JSON_DATA", jsonResultDO);
		} else {
			jsonResultDO.setInfo("提交失败");
			jsonResultDO.setStatus(JsonResultDO.JSON_FAILED);
			mav.addObject("JSON_DATA", "error");
		}
		return mav;
	}
	
	@RequestMapping(value = "/stop/{id}.json", method = RequestMethod.GET)
	public ModelAndView stop(ModelAndView mav, 
			@PathVariable(value="id") Integer id,
			HttpServletRequest request) {
		JsonResultDO jsonResultDO = new JsonResultSupport();
		StaffDO staffDO = new StaffDO();
		
		staffDO.setId(id);
		staffDO.setStatus(0);
		ResultDO result = staffService.modifi(staffDO);
		
		if(result.isSuccess()) {
			jsonResultDO.setInfo("提交成功");
			jsonResultDO.setStatus(JsonResultDO.JSON_SUCCESS);
			mav.addObject("JSON_DATA", jsonResultDO);
		} else {
			jsonResultDO.setInfo("提交失败");
			jsonResultDO.setStatus(JsonResultDO.JSON_FAILED);
			mav.addObject("JSON_DATA", "error");
		}
		return mav;
	}
	
	@RequestMapping(value = "/start/{id}.json", method = RequestMethod.GET)
	public ModelAndView start(ModelAndView mav, 
			@PathVariable(value="id") Integer id,
			HttpServletRequest request) {
		
		JsonResultDO jsonResultDO = new JsonResultSupport();
		StaffDO staffDO = new StaffDO();
		
		staffDO.setId(id);
		staffDO.setStatus(0);
		ResultDO result = staffService.modifi(staffDO);
		
		if(result.isSuccess()) {
			jsonResultDO.setInfo("提交成功");
			jsonResultDO.setStatus(JsonResultDO.JSON_SUCCESS);
			mav.addObject("JSON_DATA", jsonResultDO);
		} else {
			jsonResultDO.setInfo("提交失败");
			jsonResultDO.setStatus(JsonResultDO.JSON_FAILED);
			mav.addObject("JSON_DATA", "error");
		}
		return mav;
	}
	
	
	
	@RequestMapping(value = "/detail/{id}.html", method = RequestMethod.GET)
	public ModelAndView detail(ModelAndView mav, 
			@PathVariable(value="id") Integer id,
			HttpServletRequest request) {
		
		ResultDO result = staffService.get(id);
		if(result.isSuccess()) {
			mav.addObject("STAFF_INFO",  result.getModel(ResultSupport.FIRST_MODEL_KEY));
			mav.setViewName("manager/staff/detail");
		} else {
			mav.setViewName("error");
		}
		return mav;
	}
	
	@RequestMapping(value = "/edit.json", method = RequestMethod.POST)
	public ModelAndView edit(ModelAndView mav,
			StaffDO staffDO,
			HttpServletRequest request) {
		
		JsonResultDO jsonResultDO = new JsonResultSupport();
		
		staffDO.setModifiAuthor((String) request.getSession().getAttribute("MANAGER_NAME"));
		
		
		ResultDO result = staffService.modifi(staffDO);
		
		if(result.isSuccess()) {
			jsonResultDO.setInfo("提交成功");
			jsonResultDO.setStatus(JsonResultDO.JSON_SUCCESS);
			mav.addObject("JSON_DATA", jsonResultDO);
		} else {
			jsonResultDO.setInfo("提交失败");
			jsonResultDO.setStatus(JsonResultDO.JSON_FAILED);
			mav.addObject("JSON_DATA", "error");
		}
		return mav;
	}
	
	
	
	@RequestMapping(value = "/check/{id}.json", method = RequestMethod.GET)
	public ModelAndView check(ModelAndView mav, 
			@PathVariable(value="id") Integer id,
			HttpServletRequest request) {
		JsonResultDO jsonResultDO = new JsonResultSupport();
		StaffDO staffDO = new StaffDO();
		staffDO.setId(id);
		//状态码 0：停用 1：启用  2:待审核（如果是管理员添加不用审核）
		staffDO.setStatus(1);
		staffDO.setModifiAuthor((String) request.getSession().getAttribute("MANAGER_NAME"));
		
		ResultDO result = staffService.modifi(staffDO);
		
		if(result.isSuccess()) {
			jsonResultDO.setInfo("提交成功");
			jsonResultDO.setStatus(JsonResultDO.JSON_SUCCESS);
			mav.addObject("JSON_DATA", jsonResultDO);
		} else {
			jsonResultDO.setInfo("提交成功");
			jsonResultDO.setStatus(JsonResultDO.JSON_SUCCESS);
			mav.addObject("JSON_DATA", jsonResultDO);
		}
		return mav;
	} 
	
	@RequestMapping(value = "/list/{name}/{pageNo}.html", method = RequestMethod.GET)
	public ModelAndView query(ModelAndView mav,
			@PathVariable(value="name") String name,
			@PathVariable(value="pageNo") Integer pageNo,
			HttpServletRequest request) {
		
		StaffQuery query = new StaffQuery();
		query.setPage(true);
		query.setPageNO(pageNo);
		query.setPageRows(10);
		if(!name.equals("all")) {
			query.setStaffName(name);
		}
		
		ResultDO result = staffService.list(query);
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
			mav.setViewName("manager/task/list");
		} else {
			mav.setViewName("error");
		}
		return mav;
		
	}
	
	
}
