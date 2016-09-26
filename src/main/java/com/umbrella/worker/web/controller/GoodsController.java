package com.umbrella.worker.web.controller;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.umbrella.worker.dto.TaskDO;
import com.umbrella.worker.dto.ContactDO;

import com.umbrella.worker.query.ContactQuery;
import com.umbrella.worker.result.DateValueDO;
import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.result.ResultSupport;
import com.umbrella.worker.service.IContactService;


@Controller
@RequestMapping(value = "/goods")
public class GoodsController {
	
	@Autowired
	private IContactService contactService;
	
	
	@RequestMapping(value = "/clean.html", method = RequestMethod.GET)
	public ModelAndView clean(ModelAndView mav, 
			HttpServletRequest request) {
		mav.setViewName("goods/clean");
		return mav;
	}
	
	@RequestMapping(value = "/pip.html", method = RequestMethod.GET)
	public ModelAndView lock(ModelAndView mav, 
			HttpServletRequest request) {
		mav.setViewName("goods/pip");
		return mav;
	}
	
	@RequestMapping(value = "/toilet.html", method = RequestMethod.GET)
	public ModelAndView toilet(ModelAndView mav, 
			HttpServletRequest request) {
		mav.setViewName("goods/toilet");
		return mav;
	}
	
	
	
	@RequestMapping(value = "/buyJob.html", method = RequestMethod.POST)
	public ModelAndView buyJob(ModelAndView mav,
			TaskDO taskDO,
			HttpServletRequest request) {
		
		switch(taskDO.getServiceType()) {
		case 0: {
			taskDO.setServiceName("保洁服务");
			taskDO.setPrice(new BigDecimal(34.00));
			break;
		}
		case 1: {
			taskDO.setServiceName("开锁服务");
			taskDO.setPrice(new BigDecimal(100.00));
			break;
		}
		case 2:{
			taskDO.setServiceName("管道疏通");
			taskDO.setPrice(new BigDecimal(100.00));
			break;
		}
		};
		
		Integer memberId = (Integer) request.getSession().getAttribute("MEMBER_ID");
		
		if(memberId == null) {
			return new ModelAndView("redirect:/members/login.html");
		}
		request.getSession().setAttribute("TASK_INFO", taskDO);
		ContactQuery query = new ContactQuery();
		query.setMemberId(memberId);
		query.setIsDefault(1);
		ResultDO result = contactService.list(query);
		
		long timestamp = Calendar.getInstance().getTimeInMillis();
		List<DateValueDO> dateValueDOList = new ArrayList<DateValueDO>();
		
		Date date = new Date(timestamp);
		DateFormat dateFormat = new SimpleDateFormat("MM月dd日"); 
		DateFormat dateValueFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		DateValueDO dateValueDO = new DateValueDO();
		dateValueDO.setWeekDate(dateFormat.format(date) + "(今天)");
		dateValueDO.setDateValue(dateValueFormat.format(date));
		
		for(int day = 1; day < 6; day++) {
			date = new Date(timestamp);
			dateValueDO = new DateValueDO();
			dateValueDO.setWeekDate(dateFormat.format(date));
			dateValueDO.setDateValue(dateValueFormat.format(date));
			dateValueDOList.add(dateValueDO);
			timestamp = timestamp + 86400000;
		}
		
		if(result.isSuccess()) {
			List<ContactDO> list = (List<ContactDO>) result.getModel(ResultSupport.FIRST_MODEL_KEY);
			if(list != null) {
				mav.addObject("CONTACT_DEFAULT", list.get(0));
				request.getSession().setAttribute("CONTACT_DEFAULT", list.get(0));
			}
			mav.addObject("WEEK_DATE_LIST", dateValueDOList);
			mav.setViewName("goods/reserver");
		} else {
			mav.setViewName("error");
		}
		return mav;
	}

	
	

}
