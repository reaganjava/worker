package com.umbrella.worker.web.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.umbrella.worker.dto.ContactDO;
import com.umbrella.worker.dto.MembersDO;
import com.umbrella.worker.dto.OrderDO;
import com.umbrella.worker.dto.OrderDetailDO;
import com.umbrella.worker.dto.OrderTaskDO;
import com.umbrella.worker.dto.WorkerItemDO;
import com.umbrella.worker.dto.WorkerStaffDO;
import com.umbrella.worker.dto.WorkerTaskDO;
import com.umbrella.worker.query.ContactQuery;
import com.umbrella.worker.result.DateValueDO;
import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.result.ResultSupport;
import com.umbrella.worker.service.IContactService;
import com.umbrella.worker.service.IMemberService;
import com.umbrella.worker.service.IOrderService;
import com.umbrella.worker.service.IWorkerService;
import com.umbrella.worker.util.StringUtil;

@Controller
@RequestMapping(value = "/goods")
public class GoodsController {

	
	@Autowired
	IWorkerService workerService;
	
	@Autowired
	private IContactService contactService;
	
	
	@RequestMapping(value = "/job/{id}.html", method = RequestMethod.GET)
	public ModelAndView job(ModelAndView mav, 
			@PathVariable(value="id") Integer id,
			HttpServletRequest request) {
		
		ResultDO result = null;
		
		if(!StringUtil.isGreatOne(id)) {
			mav.setViewName("error");
		}
		
		result = workerService.get(id);
		
		if(result.isSuccess()) {
			WorkerTaskDO workerTaskDO = (WorkerTaskDO) result.getModel(ResultSupport.FIRST_MODEL_KEY);
			mav.addObject("TASK_GOODS", workerTaskDO);
			WorkerItemDO workerItemDO = workerTaskDO.getWorkerItems().get(0);
			mav.addObject("WORKER_ITEM_ID", workerItemDO.getId());
			mav.addObject("WORKER_STAFF_ID", workerItemDO.getWorkerStaffs().get(0).getId());
			mav.setViewName("goods/job");
		} else {
			mav.setViewName("error");
		}
		return mav;
	}
	
	@RequestMapping(value = "/getStaff/{id}.json", method = RequestMethod.GET)
	public ModelAndView ajaxStaff(ModelAndView mav, 
			@PathVariable(value="id") Integer id,
			HttpServletRequest request) {
		ResultDO result = workerService.getStaff(id);
		System.out.println(result);
		if(!result.isSuccess()) {
			mav.addObject("JSON_DATA", 0);
		}
		List<WorkerStaffDO> workerStaffs = (List<WorkerStaffDO>) result.getModel(ResultSupport.FIRST_MODEL_KEY);
		String line = "";
		int index = 0;
		for(WorkerStaffDO workerStaff : workerStaffs) {
			System.out.println(line);
			line += "<li id=\"staff" + index +"\"><a href=\"javascript:void(0)\" onClick=\"setStaff(" + index + ", " + workerStaffs.size() + "," + workerStaff.getId() + ")\"><span id=\"staffFont" + index + "\">"+workerStaff.getwWsStaffCount()+"人"+workerStaff.getwWsHours()+"小时</span></a></li>";
			index++;
		}
		mav.addObject("JSON_DATA", line);
		return mav;
	}
	
	@RequestMapping(value = "/buyJob/{taskId}/{itemId}/{staffId}.html", method = RequestMethod.GET)
	public ModelAndView buyJob(ModelAndView mav,
			@PathVariable(value="taskId") Integer taskId,
			@PathVariable(value="itemId") Integer itemId,
			@PathVariable(value="staffId") Integer staffId,
			HttpServletRequest request) {
		WorkerTaskDO workerTaskDO = new WorkerTaskDO();
		workerTaskDO.setId(taskId);
		workerTaskDO.setItemId(itemId);
		workerTaskDO.setStaffId(staffId);
		request.getSession().setAttribute("TASK_INFO", workerTaskDO);
		Integer memberId = (Integer) request.getSession().getAttribute("MEMBER_ID");
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
			System.out.println(list.get(0).getwCAddress());
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
