package com.umbrella.worker.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

import com.umbrella.worker.dao.WCommentMapper;
import com.umbrella.worker.dao.WOrderDetailMapper;
import com.umbrella.worker.dao.WOrderMapper;
import com.umbrella.worker.dto.OrderDO;
import com.umbrella.worker.dto.OrderDetailDO;
import com.umbrella.worker.entity.WComment;
import com.umbrella.worker.entity.WCommentExample;
import com.umbrella.worker.entity.WOrder;
import com.umbrella.worker.entity.WOrderDetail;
import com.umbrella.worker.entity.WOrderExample;
import com.umbrella.worker.query.CommentQuery;
import com.umbrella.worker.query.OrderQuery;
import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.result.ResultSupport;
import com.umbrella.worker.service.ICommentService;
import com.umbrella.worker.service.IOrderService;
import com.umbrella.worker.util.BeanUtilsExtends;
import com.umbrella.worker.util.StringUtil;

public class OrderServiceImpl implements IOrderService {
	
	private static Logger logger = Logger.getLogger(OrderServiceImpl.class);
	
	private WOrderMapper orderMapper;
	
	private WOrderDetailMapper orderDetailMapper;

	@Override
	public ResultDO create(OrderDO orderDO, OrderDetailDO orderDetailDO) {
		
		WOrder order = new WOrder();
		
		WOrderDetail orderDetail = new WOrderDetail();
		
		ResultSupport result = BeanUtilsExtends.copy(orderDO, order);
		
		if(!result.isSuccess()) {
			return result;
		}
		
		int recordNum = -1;
		
		order.setDatalevel(1);
		order.setStatus(1);
		order.setCreateTime(Calendar.getInstance().getTime());
		order.setModifiTime(Calendar.getInstance().getTime());
		
		try {
			recordNum = orderMapper.insertSelective(order);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
			logger.error("[obj:order][opt:create][msg:" + e.getMessage()
			+ "]");
			return result;
		}
		
		if(recordNum == 1) {
			result.setModel(ResultDO.FIRST_MODEL_KEY, order.getId());
		} else {
			result.setSuccess(false);
		}
		
		result = BeanUtilsExtends.copy(orderDetailDO, orderDetail);
		
		orderDetail.setId(order.getId());
		
		try {
			recordNum = orderDetailMapper.insertSelective(orderDetail);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
			logger.error("[obj:order][opt:create][msg:" + e.getMessage()
			+ "]");
			return result;
		}
		
		return result;
	}

	@Override
	public ResultDO modifi(OrderDO orderDO) {
		
		WOrder order = new WOrder();

		ResultSupport result = BeanUtilsExtends.copy(orderDO, order);
		// 拷贝失败
		if (!result.isSuccess()) {
			return result;
		}
		order.setModifiTime(Calendar.getInstance().getTime());
		
		int recordNum = -1;
		try {
			recordNum = orderMapper.updateByPrimaryKey(order);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
			result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			logger.error("[obj:order][opt:modifi][msg:" + e.getMessage()
					+ "]");
			return result;
		}
		if (recordNum < 1) {
			result.setSuccess(false);
		}

		return result;
	}
	
	@Override
	public ResultDO modifiDetail(OrderDetailDO orderDetailDO) {
		
		WOrderDetail orderDetail = new WOrderDetail();

		ResultSupport result = BeanUtilsExtends.copy(orderDetailDO, orderDetail);
		// 拷贝失败
		if (!result.isSuccess()) {
			return result;
		}
		
		
		int recordNum = -1;
		try {
			recordNum = orderDetailMapper.updateByPrimaryKey(orderDetail);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
			result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			logger.error("[obj:order][opt:modifi][msg:" + e.getMessage()
					+ "]");
			return result;
		}
		if (recordNum < 1) {
			result.setSuccess(false);
		}

		return result;
	}

	@Override
	public ResultDO remove(int orderId) {
		
		ResultSupport result = new ResultSupport();
		
		WOrder order = new WOrder();
		
		if(StringUtil.isGreatOne(orderId)) {
			order.setId(orderId);
		} else {
		    result.setSuccess(false);
		    return result;
		}
		order.setDatalevel(-1);
		int recordNum = -1;
		try {
			recordNum = orderMapper.updateByPrimaryKeySelective(order);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:order][opt:remove][msg:"+e.getMessage()+"]");
	        return result;
		}
		if (recordNum != 1) {
			result.setSuccess(false);
		}
		return result;
	}

	@Override
	public ResultDO get(int orderId) {
		
		ResultSupport result = new ResultSupport();
		
		WOrder order = null;
		if(!StringUtil.isGreatOne(orderId)) {
			 result.setSuccess(false);
			 return result;
		} 
		
		try {
			order = orderMapper.selectByPrimaryKey(orderId);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:supplier][opt:get][msg:"+e.getMessage()+"]");
	        return result;
		}
		
		OrderDO OrderDO = getOrderDO(order);
		if(OrderDO != null) {
			result.setModel(ResultSupport.FIRST_MODEL_KEY, OrderDO);
		} else {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			return result;
		}
		
		return result;
	}

	@Override
	public ResultDO list(OrderQuery orderQuery) {
		
		ResultSupport result = new ResultSupport();
		
		WOrderExample example = new WOrderExample();
		WOrderExample.Criteria c = example.createCriteria();
		
		
		
		if(StringUtil.isNotEmpty(orderQuery.getOrderByClause())) {	
			example.setOrderByClause(" " + orderQuery.getOrderByClause() + " " + orderQuery.getSort());
		} else {
			example.setOrderByClause(" W_M_REGISTER_TIME DESC");
		}
		
		List<WOrder> list = null;
		
		try {
			list = orderMapper.selectByExample(example);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:order][opt:get][msg:"+e.getMessage()+"]");
	        return result;
		}
		
		List<OrderDO> orderList = getOrderDOList(list);
		
		if(orderList.size() > 0) {
			result.setModel(ResultSupport.FIRST_MODEL_KEY, orderList);
		} else {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        return result;
		}
		return result;
	}
	
	private OrderDO getOrderDO(WOrder obj) {
		if(obj == null) return null;
		OrderDO dst = new OrderDO();
		return BeanUtilsExtends.copyProperties(dst, obj) ? dst : null;
	}
	
	private List<OrderDO> getOrderDOList(List<WOrder> list) {
		List<OrderDO> resultList = new ArrayList<OrderDO>();
		if(list != null && list.isEmpty()) {
			for(WOrder order : list) {
				OrderDO OrderDO = this.getOrderDO(order);
				if(OrderDO != null) {
					resultList.add(OrderDO);
				} else {
					return null;
				}
			}
		} else {
			return null;
		}
		return resultList;
	}

}
