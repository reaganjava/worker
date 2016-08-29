package com.umbrella.worker.web.controller.manager;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.umbrella.worker.dto.OrderDO;
import com.umbrella.worker.query.OrderQuery;
import com.umbrella.worker.result.JsonResultDO;
import com.umbrella.worker.result.JsonResultSupport;
import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.result.ResultSupport;
import com.umbrella.worker.service.IOrderService;
import com.umbrella.worker.util.PageBeanUtil;

@Controller
@RequestMapping(value = "/order")
public class ManagerOrderController {

	@Autowired
	private IOrderService orderService;
	
	@RequestMapping(value = "/waitOrderList.html", method = RequestMethod.GET)
	public ModelAndView waitOrderList(ModelAndView mav,
			HttpServletRequest request) {
		OrderQuery query = new OrderQuery();
		//0.无效 1.待商家确认 2.已发货
		query.setStatus(1);
		ResultDO resultDO = orderService.list(query);
		if(resultDO.isSuccess()) {
			mav.addObject("WAIT_ORDER_LIST", resultDO.getModel(ResultSupport.FIRST_MODEL_KEY));
			mav.setViewName("order/waitOrderList");
		} else {
			mav.setViewName("error");
		}
		return mav;
	}
	
	@RequestMapping(value = "/rushOrder.json", method = RequestMethod.POST)
	public ModelAndView rushOrder(ModelAndView mav,
			OrderDO orderDO,
			HttpServletRequest request) {
		JsonResultDO jsonResultDO = new JsonResultSupport();
		String adminName = (String) request.getSession().getAttribute("MANAGER_NAME");
		int supplierId = (int)  request.getSession().getAttribute("MANAGER_SUPPLIER_ID");
		String supplierName = (String) request.getSession().getAttribute("MANAGER_SUPPLIER_NAME");
	
		orderDO.setwOSupplierId(supplierId);
		orderDO.setModifiAuthor(adminName);
		orderDO.getOrderDetailDO().setwOSupplierName(supplierName);
		
		ResultDO result = orderService.rush(orderDO);
		if(result.isSuccess()) {
			jsonResultDO.setInfo("抢单成功");
			jsonResultDO.setStatus(JsonResultDO.JSON_SUCCESS);
			mav.addObject("JSON_DATA", jsonResultDO);
		} else {
			jsonResultDO.setInfo("抢单失败");
			jsonResultDO.setStatus(JsonResultDO.JSON_FAILED);
			mav.addObject("JSON_DATA", "error");
		}
		return mav;
	}
	
	@RequestMapping(value = "/list/{orderNo}/{pageNo}.html", method = RequestMethod.GET)
	public ModelAndView query(ModelAndView mav,
			@PathVariable(value="orderNo") String orderNo,
			@PathVariable(value="pageNo") Integer pageNo,
			HttpServletRequest request) {
		
		int supplierId = (int) request.getSession().getAttribute("MANAGER_SUPPLIER_ID");
		OrderQuery query = new OrderQuery();
		query.setPage(true);
		query.setSupplierId(supplierId);
		query.setPageNO(pageNo);
		query.setPageRows(10);
		if(!orderNo.equals("all")) {
			query.setOrderNo(orderNo);
		}
		
		ResultDO result = orderService.list(query);
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
