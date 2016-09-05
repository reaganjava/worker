package com.umbrella.worker.service.impl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umbrella.worker.dao.WOrderDetailMapper;
import com.umbrella.worker.dao.WOrderMapper;
import com.umbrella.worker.dto.OrderDO;
import com.umbrella.worker.dto.OrderDetailDO;
import com.umbrella.worker.dto.PayrecordDO;
import com.umbrella.worker.entity.WOrder;
import com.umbrella.worker.entity.WOrderDetail;
import com.umbrella.worker.entity.WOrderExample;
import com.umbrella.worker.query.OrderQuery;
import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.result.ResultSupport;
import com.umbrella.worker.service.IOrderService;
import com.umbrella.worker.service.IPayService;
import com.umbrella.worker.util.BeanUtilsExtends;
import com.umbrella.worker.util.Constant;
import com.umbrella.worker.util.MakeOrderNum;
import com.umbrella.worker.util.StringUtil;
@Service("orderService")
public class OrderServiceImpl  extends BaseServiceImpl implements IOrderService {
	
	private static Logger logger = Logger.getLogger(OrderServiceImpl.class);
	@Autowired
	private WOrderMapper orderMapper;
	@Autowired
	private WOrderDetailMapper orderDetailMapper;
	
	private IPayService payService;


	@Override
	public ResultDO create(OrderDO orderDO) {
		
		WOrder order = new WOrder();
		
		WOrderDetail orderDetail = new WOrderDetail();
		
		ResultSupport result = BeanUtilsExtends.copy(order, orderDO);
		
		if(!result.isSuccess()) {
			return result;
		}
		
		int recordNum = -1;

		BigDecimal price = orderDO.getOrderDetailDO().getwOPrice();
		
		
		
		int staffCount = orderDO.getOrderDetailDO().getwOStaffCount();
		int hours = orderDO.getOrderDetailDO().getwOServerTime();
		int countHours = staffCount * hours;
		BigDecimal priceCount = price.multiply(new BigDecimal(countHours));
		
		
		MakeOrderNum makeOrder = new MakeOrderNum();  
        String orderNO = makeOrder.makeOrderNum();
        if(StringUtil.isEmpty(orderNO)) {
        	result.setSuccess(false);
			return result;
        }
        
        order.setwOOrderNo(orderNO);
		order.setwOServiceName(orderDO.getOrderDetailDO().getwOServerName());
		order.setwOFee(priceCount);
		order.setDatalevel(1);
		order.setStatus(1);
		order.setwOIsEnd(0);
		order.setwOIsPay(0);
		order.setwOIsConfim(0);
		order.setCreateTime(Calendar.getInstance().getTime());
		order.setModifiTime(Calendar.getInstance().getTime());
		order.setModifiAuthor(order.getCreateAuthor());
		
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
		
		if(recordNum < 1) {
			result.setSuccess(false);
			return result;
		}
		
		result = BeanUtilsExtends.copy(orderDetail, orderDO.getOrderDetailDO());
		
		orderDetail.setId(order.getId());
		orderDetail.setCreateTime(order.getCreateTime());
		orderDetail.setCreateAuthor(order.getCreateAuthor());
		orderDetail.setModifiTime(order.getCreateTime());
		orderDetail.setModifiAuthor(order.getCreateAuthor());
		orderDetail.setStatus(1);
		orderDetail.setDatalevel(1);
		recordNum = -1;
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
		
		PayrecordDO payrecordDO = new PayrecordDO();
		
		payrecordDO.setwPrTradeNo(orderNO);
		payrecordDO.setwPrFee(priceCount);
		payrecordDO.setwPrIsCoupon(0);
		payrecordDO.setwPrPayChannel(Constant.PAY_CHANNELS[0]);
		payrecordDO.setStatus(1);
		payrecordDO.setCreateAuthor(orderDetail.getCreateAuthor());
		payrecordDO.setCreateTime(orderDetail.getCreateTime());
		payrecordDO.setModifiAuthor(orderDetail.getCreateAuthor());
		payrecordDO.setModifiTime(orderDetail.getModifiTime());
		payrecordDO.setDatalevel(1);
		ResultDO resultDO = payService.create(payrecordDO);
		if(resultDO.isSuccess()) {
			result.setModel(ResultDO.FIRST_MODEL_KEY, order.getId());
		} else {
			result.setSuccess(false);
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
	public ResultDO rush(OrderDO orderDO) {
	
		WOrder order = new WOrder();

		ResultSupport result = BeanUtilsExtends.copy(orderDO, order);
		// 拷贝失败
		if (!result.isSuccess()) {
			return result;
		}
		
		order.setModifiTime(Calendar.getInstance().getTime());
		
		int recordNum = -1;
	
		try {
			recordNum = orderMapper.updateByPrimaryKeySelective(order);
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
		
		recordNum = -1;
		WOrderDetail orderDetail = new WOrderDetail();
		result = BeanUtilsExtends.copy(orderDO.getOrderDetailDO(), orderDetail);
		// 拷贝失败
		if (!result.isSuccess()) {
			return result;
		}
		
		try {
			recordNum = orderDetailMapper.updateByPrimaryKeySelective(orderDetail);
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
	public ResultDO confirm(int orderId) {
		
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
		
		int recordNum = -1;
		
		order.setwOIsConfim(1);
		try {
			recordNum = orderMapper.updateByPrimaryKey(order);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:supplier][opt:get][msg:"+e.getMessage()+"]");
	        return result;
		}
		
		if(recordNum < 1) {
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
		
		WOrderDetail orderDetail = null;
		
		try {
			orderDetail = orderDetailMapper.selectByPrimaryKey(orderId);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:supplier][opt:get][msg:"+e.getMessage()+"]");
	        return result;
		}
		
		OrderDetailDO orderDetailDO = getOrderDetailDO(orderDetail);
		
		OrderDO orderDO = getOrderDO(order);
		if(orderDO != null) {
			orderDO.setOrderDetailDO(orderDetailDO);
		} else {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			return result;
		}

		result.setModel(ResultSupport.FIRST_MODEL_KEY, orderDO);
		return result;
	}

	@Override
	public ResultDO list(OrderQuery orderQuery) {
		
		ResultSupport result = new ResultSupport();
		
		WOrderExample example = new WOrderExample();
		WOrderExample.Criteria c = example.createCriteria();
		
		if(StringUtil.isGreatOne(orderQuery.getMemberId())) {
			c.andWOMembersIdEqualTo(orderQuery.getMemberId());
		}
		
		if(StringUtil.isNotEmpty(orderQuery.getOrderNo())) {
			c.andWOOrderNoEqualTo(orderQuery.getOrderNo());
		}
	
		if(StringUtil.isGreatOne(orderQuery.getSupplierId())) {
			c.andWOSupplierIdEqualTo(orderQuery.getSupplierId());
		}
		
		if(StringUtil.isNotEmpty(orderQuery.getOrderByClause())) {	
			example.setOrderByClause(" " + orderQuery.getOrderByClause() + " " + orderQuery.getSort());
		} else {
			example.setOrderByClause(" CREATE_TIME DESC");
		}
		
		c.andDatalevelEqualTo(1);
		
		if(orderQuery.isPage()) {
			long count = 0;
			try {
				count = orderMapper.countByExample(example);
			} catch (Exception e) {
				result.setSuccess(false);
		        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
		        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
		        e.printStackTrace();
		        logger.error("[obj:member][opt:get][msg:"+e.getMessage()+"]");
		        return result;
			}
			result.setModel(ResultSupport.SECOND_MODEL_KEY, count);
			int pageNO = orderQuery.getPageNO();
			if(pageNO > 0) {
				pageNO = pageNO -1;
			}
			String pageByClause = " limit " + (pageNO * orderQuery.getPageRows())
					+ "," + orderQuery.getPageRows();
			System.out.println("count:" + count);
			System.out.println(pageByClause);
			example.setPageByClause(pageByClause);
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
	
	

}
