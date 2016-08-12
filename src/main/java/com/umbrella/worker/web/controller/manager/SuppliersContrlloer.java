package com.umbrella.worker.web.controller.manager;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.umbrella.worker.dto.SupplierDO;
import com.umbrella.worker.query.SupplierQuery;
import com.umbrella.worker.result.JsonResultDO;
import com.umbrella.worker.result.JsonResultSupport;
import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.result.ResultSupport;
import com.umbrella.worker.service.ISuppliersService;
import com.umbrella.worker.util.PageBeanUtil;

@Controller
@RequestMapping(value = "/supplier")
public class SuppliersContrlloer {

	@Autowired
	private ISuppliersService suppliersService;
	
	@RequestMapping(value = "/join.html", method = RequestMethod.GET)
	public ModelAndView join(ModelAndView mav, HttpServletRequest request) {
		mav.setViewName("manager/supplier/join");
		return mav;
	}
	
	@RequestMapping(value = "/join.json", method = RequestMethod.POST)
	public ModelAndView join(ModelAndView mav, 
			SupplierDO supplierDO,
			HttpServletRequest request) {
		
		JsonResultDO jsonResultDO = new JsonResultSupport();
		
		supplierDO.setCreateAuthor((String) request.getSession().getAttribute("MANAGER_NAME"));
		supplierDO.setModifiAuthor(supplierDO.getCreateAuthor());
		
		ResultDO result = suppliersService.create(supplierDO);
		
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
		mav.setViewName("manager/supplier/join");
		
		ResultDO result = suppliersService.get(id);
		
		if(result.isSuccess()) {
			mav.addObject("SUPPLIER_INFO", result.getModel(ResultSupport.FIRST_MODEL_KEY));
			mav.setViewName("manager/supplier/detail");
		} else {
			mav.setViewName("error");
		}
		return mav;
	}
	
	@RequestMapping(value = "/edit.json", method = RequestMethod.POST)
	public ModelAndView edit(ModelAndView mav, 
			SupplierDO supplierDO,
			HttpServletRequest request) {
		JsonResultDO jsonResultDO = new JsonResultSupport();
		supplierDO.setModifiAuthor((String) request.getSession().getAttribute("MANAGER_NAME"));
		
		ResultDO result = suppliersService.modifi(supplierDO);
		
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
	
	@RequestMapping(value = "/remove/{id}.json", method = RequestMethod.GET)
	public ModelAndView remove(ModelAndView mav, 
			@PathVariable(value="id") Integer id,
			HttpServletRequest request) {
		JsonResultDO jsonResultDO = new JsonResultSupport();
		
		ResultDO result = suppliersService.remove(id);
		
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
	
	@RequestMapping(value = "/removeall/{idArray}.json", method = RequestMethod.GET)
	public ModelAndView remove(ModelAndView mav, 
			@PathVariable(value="idArray") String idArray,
			HttpServletRequest request) {
		
		boolean isSuccess = true;
		JsonResultDO jsonResultDO = new JsonResultSupport();
		System.out.println(idArray);
		String[] ids = idArray.split("-");
		System.out.println(ids.length);
		ResultDO result = new ResultSupport();
		for(String id : ids) {
			System.out.println(id);
			result = suppliersService.remove(Integer.parseInt(id));
			if(!result.isSuccess()) {
				isSuccess = false;
				break;
			}
		}
		if(isSuccess) {
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
	
	@RequestMapping(value = "/stop/{id}.json", method = RequestMethod.GET)
	public ModelAndView stop(ModelAndView mav, 
			@PathVariable(value="id") Integer id,
			HttpServletRequest request) {
		JsonResultDO jsonResultDO = new JsonResultSupport();
		SupplierDO supplierDO = new SupplierDO();
		supplierDO.setId(id);
		//状态码 0：停用 1：启用  2:待审核（如果是管理员添加不用审核）
		supplierDO.setStatus(0);
		supplierDO.setModifiAuthor((String) request.getSession().getAttribute("MANAGER_NAME"));
		
		ResultDO result = suppliersService.modifi(supplierDO);
		
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
	
	@RequestMapping(value = "/start/{id}.json", method = RequestMethod.GET)
	public ModelAndView start(ModelAndView mav, 
			@PathVariable(value="id") Integer id,
			HttpServletRequest request) {
		JsonResultDO jsonResultDO = new JsonResultSupport();
		SupplierDO supplierDO = new SupplierDO();
		supplierDO.setId(id);
		//状态码 0：停用 1：启用  2:待审核（如果是管理员添加不用审核）
		supplierDO.setStatus(1);
		supplierDO.setModifiAuthor((String) request.getSession().getAttribute("MANAGER_NAME"));
		
		ResultDO result = suppliersService.modifi(supplierDO);
		
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
	
	@RequestMapping(value = "/check/{id}.json", method = RequestMethod.GET)
	public ModelAndView check(ModelAndView mav, 
			@PathVariable(value="id") Integer id,
			HttpServletRequest request) {
		JsonResultDO jsonResultDO = new JsonResultSupport();
		SupplierDO supplierDO = new SupplierDO();
		supplierDO.setId(id);
		//状态码 0：停用 1：启用  2:待审核（如果是管理员添加不用审核）
		supplierDO.setStatus(1);
		supplierDO.setModifiAuthor((String) request.getSession().getAttribute("MANAGER_NAME"));
		
		ResultDO result = suppliersService.modifi(supplierDO);
		
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
		
		SupplierQuery query = new SupplierQuery();
		query.setPage(true);
		query.setPageNO(pageNo);
		query.setPageRows(10);
		if(!name.equals("all")) {
			query.setName(name);
		}
		System.out.println(query.getName());
		ResultDO result = suppliersService.list(query);
		
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
			mav.setViewName("manager/supplier/list");
		} else {
			mav.setViewName("error");
		}
		return mav;
		
	}
}
