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
import com.umbrella.worker.dto.CouponDO;

import com.umbrella.worker.query.CouponQuery;

import com.umbrella.worker.result.JsonResultDO;
import com.umbrella.worker.result.JsonResultSupport;
import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.result.ResultSupport;

import com.umbrella.worker.service.ICouponService;

import com.umbrella.worker.util.PageBeanUtil;


@Controller
@RequestMapping(value = "/coupon")
public class CouponContrlloer {

	@Autowired
	private ICouponService couponService;

	
	@RequestMapping(value = "/add.html", method = RequestMethod.GET)
	public ModelAndView add(ModelAndView mav, 
			HttpServletRequest request) {
		mav.setViewName("manager/coupon/add");
		return mav; 
	}
	
	@RequestMapping(value = "/add.json", method = RequestMethod.POST)
	public ModelAndView add(ModelAndView mav,
			CouponDO couponDO,
			HttpServletRequest request) {
		
		JsonResultDO jsonResultDO = new JsonResultSupport();
		
		couponDO.setCreateAuthor((String) request.getSession().getAttribute("MANAGER_NAME"));
		couponDO.setModifiAuthor(couponDO.getCreateAuthor());
		
		ResultDO result = couponService.create(couponDO);
		
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
		
		ResultDO result = couponService.remove(id);
		
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
		CouponDO couponDO = new CouponDO();
		
		couponDO.setId(id);
		couponDO.setStatus(0);
		ResultDO result = couponService.modifi(couponDO);
		
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
		
		CouponDO couponDO = new CouponDO();
		
		couponDO.setId(id);
		couponDO.setStatus(1);
		ResultDO result = couponService.modifi(couponDO);
		
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
	
		ResultDO result = couponService.get(id);
		if(result.isSuccess()) {
			mav.addObject("MANAGER_INFO", (AdminDO) result.getModel(ResultSupport.FIRST_MODEL_KEY));
			mav.setViewName("manager/coupon/detail");
		} else {
			mav.setViewName("error");
		}
		return mav;
	}
	
	@RequestMapping(value = "/edit.json", method = RequestMethod.POST)
	public ModelAndView edit(ModelAndView mav,
			CouponDO couponDO,
			HttpServletRequest request) {
		
		JsonResultDO jsonResultDO = new JsonResultSupport();
		
		couponDO.setModifiAuthor((String) request.getSession().getAttribute("MANAGER_NAME"));
	
		ResultDO result = couponService.modifi(couponDO);
		
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
	
	@RequestMapping(value = "/list/{pageNo}.html", method = RequestMethod.GET)
	public ModelAndView query(ModelAndView mav,
			@PathVariable(value="pageNo") Integer pageNo,
			HttpServletRequest request) {
		
		CouponQuery query = new CouponQuery();
		query.setPage(true);
		query.setPageNO(pageNo);
		query.setPageRows(10);
	
		
		ResultDO result = couponService.list(query);
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
			mav.setViewName("manager/coupon/list");
		} else {
			mav.setViewName("error");
		}
		return mav;
		
	}
	
	
}
