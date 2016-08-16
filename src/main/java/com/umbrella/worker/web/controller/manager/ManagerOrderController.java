package com.umbrella.worker.web.controller.manager;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.umbrella.worker.query.OrderQuery;
import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.result.ResultSupport;
import com.umbrella.worker.service.IOrderService;
import com.umbrella.worker.util.PageBeanUtil;

@Controller
@RequestMapping(value = "/order")
public class ManagerOrderController {

	@Autowired
	private IOrderService orderService;
	
	@RequestMapping(value = "/list/{orderNo}/{pageNo}.html", method = RequestMethod.GET)
	public ModelAndView query(ModelAndView mav,
			@PathVariable(value="orderNo") String orderNo,
			@PathVariable(value="pageNo") Integer pageNo,
			HttpServletRequest request) {
		
		OrderQuery query = new OrderQuery();
		query.setPage(true);
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
