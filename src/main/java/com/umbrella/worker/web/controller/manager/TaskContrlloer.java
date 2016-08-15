package com.umbrella.worker.web.controller.manager;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.umbrella.worker.dto.SupplierDO;
import com.umbrella.worker.dto.WorkerTaskDO;
import com.umbrella.worker.query.SupplierQuery;
import com.umbrella.worker.query.WorkerTaskQuery;
import com.umbrella.worker.result.JsonResultDO;
import com.umbrella.worker.result.JsonResultSupport;
import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.result.ResultSupport;
import com.umbrella.worker.service.ISuppliersService;
import com.umbrella.worker.service.IWorkerService;
import com.umbrella.worker.util.PageBeanUtil;

@Controller
@RequestMapping(value = "/task")
public class TaskContrlloer {

	@Autowired
	public IWorkerService workerService;
	
	@Autowired
	private ISuppliersService suppliersService;
	
	@RequestMapping(value = "/add.html", method = RequestMethod.GET)
	public ModelAndView add(ModelAndView mav, 
			HttpServletRequest request) {
		
		SupplierQuery query = new SupplierQuery();
		ResultDO result = suppliersService.list(query);
		if(result.isSuccess()) {
			mav.addObject("SUPPLIER_LIST", result.getModel(ResultSupport.FIRST_MODEL_KEY));
			mav.setViewName("manager/task/add");
		} else {
			mav.setViewName("error");
		}
		
		return mav; 
	}
	
	@RequestMapping(value = "/add.json", method = RequestMethod.POST)
	public ModelAndView add(ModelAndView mav,
			WorkerTaskDO workerTaskDO,
			HttpServletRequest request) {
		
		JsonResultDO jsonResultDO = new JsonResultSupport();
		
		workerTaskDO.setCreateAuthor((String) request.getSession().getAttribute("MANAGER_NAME"));
		
		for(SupplierDO supplier : workerTaskDO.getSuppliers()) {
			System.out.println(supplier.getId());
		}
		ResultDO result = workerService.create(workerTaskDO);
		
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
		
		ResultDO result = workerService.remove(id);
		
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
		WorkerTaskDO workerTaskDO = new WorkerTaskDO();
		
		workerTaskDO.setId(id);
		workerTaskDO.setStatus(0);
		workerTaskDO.setModifiAuthor((String) request.getSession().getAttribute("MANAGER_NAME"));
		ResultDO result = workerService.modifi(workerTaskDO);
		
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
		WorkerTaskDO workerTaskDO = new WorkerTaskDO();
		
		workerTaskDO.setId(id);
		workerTaskDO.setStatus(1);
		workerTaskDO.setModifiAuthor((String) request.getSession().getAttribute("MANAGER_NAME"));
		ResultDO result = workerService.modifi(workerTaskDO);
		
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
		
		SupplierQuery query = new SupplierQuery();
		ResultDO result = suppliersService.list(query);
		if(result.isSuccess()) {
			mav.addObject("SUPPLIER_LIST", result.getModel(ResultSupport.FIRST_MODEL_KEY));
		} else {
			mav.setViewName("error");
		}
		
		result = workerService.get(id);
		if(result.isSuccess()) {
			mav.addObject("TASK_INFO",  result.getModel(ResultSupport.FIRST_MODEL_KEY));
			mav.setViewName("manager/task/detail");
		} else {
			mav.setViewName("error");
		}
		return mav;
	}
	
	@RequestMapping(value = "/edit.json", method = RequestMethod.POST)
	public ModelAndView edit(ModelAndView mav,
			WorkerTaskDO workerTaskDO,
			HttpServletRequest request) {
		
		JsonResultDO jsonResultDO = new JsonResultSupport();
		
		workerTaskDO.setModifiAuthor((String) request.getSession().getAttribute("MANAGER_NAME"));
		
		List<Integer> itemRemoveList =  (List<Integer>) request.getSession().getAttribute("ITEM_REMOVE_LIST");
		
		workerTaskDO.setRemoveItems(itemRemoveList);
		ResultDO result = workerService.modifi(workerTaskDO);
		
	
		
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
		WorkerTaskDO workerTaskDO = new WorkerTaskDO();
		workerTaskDO.setId(id);
		//状态码 0：停用 1：启用  2:待审核（如果是管理员添加不用审核）
		workerTaskDO.setStatus(1);
		workerTaskDO.setModifiAuthor((String) request.getSession().getAttribute("MANAGER_NAME"));
		
		ResultDO result = workerService.modifi(workerTaskDO);
		
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
		
		WorkerTaskQuery query = new WorkerTaskQuery();
		query.setPage(true);
		query.setPageNO(pageNo);
		query.setPageRows(10);
		if(!name.equals("all")) {
			query.setType(Integer.parseInt(name));
		}
		
		ResultDO result = workerService.list(query);
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
	
	@RequestMapping(value = "/removeItem/{itemId}.html", method = RequestMethod.GET)
	public ModelAndView ajaxRemoveItem(ModelAndView mav, 
			@PathVariable(value="itemId") Integer itemId, 
			HttpServletRequest request) {
		List<Integer> itemRemoveList =  (List<Integer>) request.getSession().getAttribute("ITEM_REMOVE_LIST");
		if(itemRemoveList == null) {
			itemRemoveList = new ArrayList<Integer>();
		}
		itemRemoveList.add(itemId);
		request.getSession().setAttribute("ITEM_REMOVE_LIST", itemRemoveList);
		return mav;
	}
	
	@RequestMapping(value = "/removeStaff/{staffId}.html", method = RequestMethod.GET)
	public ModelAndView ajaxRemoveStaff(ModelAndView mav, 
			@PathVariable(value="staffId") Integer staffId, 
			HttpServletRequest request) {
		List<Integer> staffRemoveList =  (List<Integer>) request.getSession().getAttribute("STAFF_REMOVE_LIST");
		if(staffRemoveList == null) {
			staffRemoveList = new ArrayList<Integer>();
		}
		staffRemoveList.add(staffId);
		request.getSession().setAttribute("STAFF_REMOVE_LIST", staffRemoveList);
		return mav;
	}
	
	
}
