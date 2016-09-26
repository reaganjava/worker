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
import com.umbrella.worker.dto.OrderDetailDO;
import com.umbrella.worker.query.OrderQuery;
import com.umbrella.worker.result.JsonResultDO;
import com.umbrella.worker.result.JsonResultSupport;
import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.result.ResultSupport;
import com.umbrella.worker.service.IOrderService;
import com.umbrella.worker.util.PageBeanUtil;

@Controller
@RequestMapping(value = "/morder")
public class ManagerOrderController {

	@Autowired
	private IOrderService orderService;
	
	@RequestMapping(value = "/waitOrderList.html", method = RequestMethod.GET)
	public ModelAndView waitOrderList(ModelAndView mav,
			HttpServletRequest request) {
		mav.setViewName("manager/order/waitOrderList");
		return mav;
	}
	
	@RequestMapping(value = "/waitOrderList.json", method = RequestMethod.GET)
	public ModelAndView ajaxWaitOrderList(ModelAndView mav,
			HttpServletRequest request) {
		
		ResultDO resultDO = orderService.watiList();
		if(resultDO.isSuccess()) {
			List<OrderDO> list = (List<OrderDO>) resultDO.getModel(ResultSupport.FIRST_MODEL_KEY);
			String waitOrderContent = "";
			for(OrderDO orderDO : list) {
				waitOrderContent += "<tr class=\"text-c\"><td>" + orderDO.getwOOrderNo() + "</td><td>￥" + orderDO.getwOFee() + "元</td><td>" + orderDO.getOrderDetailDO().getwOAddress()+ "</td><td class=\"td-status\"><button onClick=\"rushOrder(" + orderDO.getId() + ")\">快速抢单</button></td></tr>";
			}
			//System.out.println(waitOrderContent);
			mav.addObject("JSON_DATA", waitOrderContent);
		} else {
			mav.addObject("JSON_DATA", 0);
		}
		return mav;
	}
	
	@RequestMapping(value = "/rushOrder/{id}.json", method = RequestMethod.GET)
	public ModelAndView rushOrder(ModelAndView mav,
			@PathVariable(value="id") Integer id,
			HttpServletRequest request) {
		JsonResultDO jsonResultDO = new JsonResultSupport();
		String adminName = (String) request.getSession().getAttribute("MANAGER_NAME");
		Integer supplierId = (Integer)  request.getSession().getAttribute("MANAGER_SUPPLIER_ID");
		String supplierName = (String) request.getSession().getAttribute("MANAGER_SUPPLIER_NAME");
		OrderDO orderDO = new OrderDO();
		orderDO.setId(id);
		System.out.println(supplierId);
		orderDO.setwOSupplierId(supplierId);
		orderDO.setModifiAuthor(adminName);
		OrderDetailDO orderDetailDO = new OrderDetailDO();
		orderDetailDO.setId(id);
		orderDetailDO.setwOSupplierName(supplierName);
		orderDetailDO.setModifiAuthor(adminName);
		orderDO.setOrderDetailDO(orderDetailDO);
		orderDO.setStatus(3);
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
