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
	
	@RequestMapping(value = "/join.html", method = RequestMethod.POST)
	public ModelAndView join(ModelAndView mav, 
			SupplierDO supplierDO,
			HttpServletRequest request) {
		
		supplierDO.setCreateAuthor((String) request.getSession().getAttribute("ADMIN_NAME"));
		
		ResultDO result = suppliersService.create(supplierDO);
		
		if(result.isSuccess()) {
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
		mav.setViewName("manager/supplier/join");
		
		ResultDO result = suppliersService.get(id);
		
		if(result.isSuccess()) {
			mav.addObject("SUPPLIER_INFO", result.getModel(ResultSupport.SECOND_MODEL_KEY));
			mav.setViewName("manager/supplier/detail");
		} else {
			mav.setViewName("error");
		}
		return mav;
	}
	
	@RequestMapping(value = "/edit.html", method = RequestMethod.POST)
	public ModelAndView edit(ModelAndView mav, 
			SupplierDO supplierDO,
			HttpServletRequest request) {
		
		supplierDO.setModifiAuthor((String) request.getSession().getAttribute("ADMIN_NAME"));
		
		ResultDO result = suppliersService.modifi(supplierDO);
		
		if(result.isSuccess()) {
			return new ModelAndView("redirect:/manager/supplier/detail /+ " + supplierDO.getId() + ".html");
		} else {
			mav.setViewName("error");
		}
		return mav;
	} 
	
	
	@RequestMapping(value = "/list/{name}/{pageNo}.html", method = RequestMethod.POST)
	public ModelAndView query(ModelAndView mav,
			@PathVariable(value="name") String name,
			@PathVariable(value="pageNo") Integer pageNo,
			HttpServletRequest request) {
		
		SupplierQuery query = new SupplierQuery();
		query.setPage(true);
		query.setPageNO(pageNo);
		ResultDO result = suppliersService.list(query);
		
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
