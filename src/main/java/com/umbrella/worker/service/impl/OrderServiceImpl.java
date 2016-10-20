package com.umbrella.worker.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umbrella.worker.dao.WOrderDetailMapper;
import com.umbrella.worker.dao.WOrderMapper;
import com.umbrella.worker.dao.WSmsRecordMapper;
import com.umbrella.worker.dao.WSupplierAccountMapper;
import com.umbrella.worker.dao.WSupplierMapper;
import com.umbrella.worker.dto.OrderDO;
import com.umbrella.worker.dto.OrderDetailDO;
import com.umbrella.worker.dto.PayrecordDO;
import com.umbrella.worker.entity.WOrder;
import com.umbrella.worker.entity.WOrderDetail;
import com.umbrella.worker.entity.WOrderExample;
import com.umbrella.worker.entity.WSmsRecord;
import com.umbrella.worker.entity.WSmsRecordExample;
import com.umbrella.worker.entity.WSupplier;
import com.umbrella.worker.entity.WSupplierAccount;
import com.umbrella.worker.entity.WSupplierExample;
import com.umbrella.worker.query.OrderQuery;
import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.result.ResultSupport;
import com.umbrella.worker.service.IOrderService;
import com.umbrella.worker.service.IPayService;
import com.umbrella.worker.service.ISMSGatewayService;
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
	@Autowired
	private IPayService payService;
	@Autowired
	private ISMSGatewayService smsGatewayService;
	@Autowired
	private WSupplierMapper supplierMapper;
	@Autowired
	private WSupplierAccountMapper supplierAccountMapper;
	@Autowired
	private WSmsRecordMapper smsRecordMapper;
	
	@PostConstruct  
	public void orderInit() {
		new Thread(new Settle()).start();
	}

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
		BigDecimal priceCount = null;
		if(orderDO.getwOServiceType() == 0) {
			int staffCount = orderDO.getOrderDetailDO().getwOStaffCount();
			int hours = orderDO.getOrderDetailDO().getwOServerTime();
			int countHours = staffCount * hours;
			priceCount = price.multiply(new BigDecimal(countHours));
		} else {
			priceCount = price;
		}
		
		
		MakeOrderNum makeOrder = new MakeOrderNum();  
        String orderNO = makeOrder.makeOrderNum();
        if(StringUtil.isEmpty(orderNO)) {
        	result.setSuccess(false);
			return result;
        }
        
        order.setwOOrderNo(orderNO);
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
			e.printStackTrace();
			return result;
		}
		
		if(recordNum < 1) {
			result.setSuccess(false);
			return result;
		}
		
		result = BeanUtilsExtends.copy(orderDetail, orderDO.getOrderDetailDO());
		
		if(!result.isSuccess()) {
			return result;
		}
		
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
			e.printStackTrace();
			return result;
		}
	
		
		result.setModel(ResultDO.FIRST_MODEL_KEY, order.getId());
		
		return result;
	}

	@Override
	public ResultDO modifi(OrderDO orderDO) {
		
		WOrder order = new WOrder();

		ResultSupport result = BeanUtilsExtends.copy(order, orderDO);
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
			e.printStackTrace();
			return result;
		}
		if (recordNum < 1) {
			result.setSuccess(false);
		}
		
		if(!StringUtil.isGreatOne(orderDO.getOrderDetailDO().getId())) {
			return result;
		}
		WOrderDetail orderDetail = new WOrderDetail();

		result = BeanUtilsExtends.copy(orderDetail, orderDO.getOrderDetailDO());
		// 拷贝失败
		if (!result.isSuccess()) {
			return result;
		}
		
		recordNum = -1;
		try {
			recordNum = orderDetailMapper.updateByPrimaryKeySelective(orderDetail);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
			result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			logger.error("[obj:order][opt:modifi][msg:" + e.getMessage()
					+ "]");
			e.printStackTrace();
			return result;
		}
		if (recordNum < 1) {
			result.setSuccess(false);
		}

		return result;
	}
	
	public ResultDO assigned(OrderDO orderDO) {
		WOrder order = new WOrder();

		ResultSupport result = BeanUtilsExtends.copy(order, orderDO);
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
			e.printStackTrace();
			return result;
		}
		if (recordNum < 1) {
			result.setSuccess(false);
		}
		
		if(!StringUtil.isGreatOne(orderDO.getOrderDetailDO().getId())) {
			return result;
		}
		WOrderDetail orderDetail = new WOrderDetail();

		result = BeanUtilsExtends.copy(orderDetail, orderDO.getOrderDetailDO());
		// 拷贝失败
		if (!result.isSuccess()) {
			return result;
		}
		
		recordNum = -1;
		try {
			recordNum = orderDetailMapper.updateByPrimaryKeySelective(orderDetail);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
			result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			logger.error("[obj:order][opt:modifi][msg:" + e.getMessage()
					+ "]");
			e.printStackTrace();
			return result;
		}
		
		try {
			orderDetail = orderDetailMapper.selectByPrimaryKey(order.getId());
		} catch (Exception e) {
			result.setSuccess(false);
			result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
			result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			logger.error("[obj:order][opt:modifi][msg:" + e.getMessage()
					+ "]");
			e.printStackTrace();
			return result;
		}
		
		String arg = orderDetail.getwOStaffContact() + "联系电话" + orderDetail.getwOStaffTelephone() + "本次服务由" + orderDetail.getwOSupplierName() + "为您提供！";
		WSmsRecord smsRecord = new WSmsRecord();
		smsRecord.setsSupplierId(orderDO.getwOSupplierId());
		smsRecord.setsMobile(orderDetail.getwOTelephone());
		smsRecord.setsFee(new BigDecimal(0.08));
		smsRecord.setCreateAuthor("system");
		smsRecord.setModifiAuthor(smsRecord.getCreateAuthor());
		smsRecord.setCreateTime(Calendar.getInstance().getTime());
		smsRecord.setModifiTime(smsRecord.getCreateTime());
		smsRecord.setStatus(1);
		smsRecord.setDatalevel(1);
		try {
			smsRecordMapper.insertSelective(smsRecord);
		} catch (Exception e) {
			
			logger.error("[obj:order][opt:modifi][msg:" + e.getMessage()
					+ "]");
			e.printStackTrace();
		}
		if(recordNum > 0) {
			smsGatewayService.initSMS();
			ResultDO resultDO = smsGatewayService.send(orderDetail.getwOTelephone(), Constant.SMS_ORDER_ASSIGNED_KEY, arg, 1);
			if(!resultDO.isSuccess()) {
				result.setSuccess(false);
			}
		} else {
			result.setSuccess(false);
		}
		
		return result;
	}
	
	@Override
	public ResultDO updateStatus(OrderDO orderDO) {
		
		WOrderExample example = new WOrderExample();
		ResultSupport result = new ResultSupport();
		example.createCriteria().andWOOrderNoEqualTo(orderDO.getwOOrderNo());
		WOrder order = new WOrder();
		order.setwOIsPay(1);
		order.setStatus(2);
		order.setModifiAuthor("system");
		order.setModifiTime(Calendar.getInstance().getTime());
		
		int recordNum = -1;
		try {
			recordNum = orderMapper.updateByExampleSelective(order, example);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
			result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			logger.error("[obj:order][opt:modifi][msg:" + e.getMessage()
					+ "]");
			e.printStackTrace();
			return result;
		}
		if (recordNum < 1) {
			result.setSuccess(false);
		}
		
		PayrecordDO payrecordDO = new PayrecordDO();
		payrecordDO.setwPrOrderNo(orderDO.getwOOrderNo());
		ResultDO resultDO = null;
		resultDO = payService.updateStatus(payrecordDO);
		
		if(!resultDO.isSuccess()) {
			result.setSuccess(false);
		}
		
		example.createCriteria().andWOOrderNoEqualTo(orderDO.getwOOrderNo());
		List<WOrder> list = null;
		try {
			list = orderMapper.selectByExample(example);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
			result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			logger.error("[obj:order][opt:modifi][msg:" + e.getMessage()
					+ "]");
			e.printStackTrace();
			return result;
		}
		if(list.size() == 0) {
			result.setSuccess(false);
		} else {
			result.setModel(ResultSupport.FIRST_MODEL_KEY, list.get(0).getId());
		}
		return result;
	}
	
	@Override
	public ResultDO modifiDetail(OrderDetailDO orderDetailDO) {
		
		WOrderDetail orderDetail = new WOrderDetail();

		ResultSupport result = BeanUtilsExtends.copy(orderDetail, orderDetailDO);
		// 拷贝失败
		if (!result.isSuccess()) {
			return result;
		}
		
		int recordNum = -1;
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

		ResultSupport result = BeanUtilsExtends.copy(order, orderDO);
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
			e.printStackTrace();
			return result;
		}
		
		System.out.println(recordNum);
		if (recordNum < 1) {
			result.setSuccess(false);
		}
		
		recordNum = -1;
		WOrderDetail orderDetail = new WOrderDetail();
		result = BeanUtilsExtends.copy(orderDetail, orderDO.getOrderDetailDO());
		// 拷贝失败
		if (!result.isSuccess()) {
			return result;
		}
		
		orderDetail.setModifiTime(order.getModifiTime());
		
		try {
			recordNum = orderDetailMapper.updateByPrimaryKeySelective(orderDetail);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
			result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			logger.error("[obj:order][opt:modifi][msg:" + e.getMessage()
					+ "]");
			e.printStackTrace();
			return result;
		}
		System.out.println(recordNum);
		if (recordNum < 1) {
			result.setSuccess(false);
		}
		
		return result;
		
	}
	
	@Override
	public ResultDO confirm(int orderId) {
		
		ResultSupport result = new ResultSupport();
		
		WOrder order = new WOrder();
		if(!StringUtil.isGreatOne(orderId)) {
			 result.setSuccess(false);
			 return result;
		} 
		
		int recordNum = -1;
		
		order.setId(orderId);
		order.setwOIsConfim(1);
		order.setStatus(6);
		try {
			recordNum = orderMapper.updateByPrimaryKeySelective(order);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:supplier][opt:get][msg:"+e.getMessage()+"]");
	        e.printStackTrace();
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
	        e.printStackTrace();
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
	public ResultDO cleanAssignedList(OrderQuery orderQuery) {
		
		ResultSupport result = new ResultSupport();
		
		WOrderExample example = new WOrderExample();
		WOrderExample.Criteria c = example.createCriteria();
		
		
		if(StringUtil.isGreatOne(orderQuery.getSupplierId())) {
			c.andWOSupplierIdEqualTo(orderQuery.getSupplierId());
		}
        c.andWOServiceTypeEqualTo(0);
		c.andStatusEqualTo(3);
	

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
		
		result.setModel(ResultSupport.FIRST_MODEL_KEY, orderList);
		
		return result;
	}
	
	@Override
	public ResultDO adminAssignedList(OrderQuery orderQuery) {
		
		ResultSupport result = new ResultSupport();
		
		WOrderExample example = new WOrderExample();
		WOrderExample.Criteria c = example.createCriteria();
		List<Integer> slist = new ArrayList<Integer>();
		slist.add(1);
		slist.add(2);
		slist.add(3);
		c.andWOServiceTypeIn(slist);
		c.andStatusEqualTo(2);
	

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
		
		result.setModel(ResultSupport.FIRST_MODEL_KEY, orderList);
		
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
		if(orderQuery.getSupplierId() != null) {
			if(orderQuery.getSupplierId() != 1) {
				if(StringUtil.isGreatOne(orderQuery.getSupplierId())) {
					c.andWOSupplierIdEqualTo(orderQuery.getSupplierId());
				}
			}
		}
		System.out.println(orderQuery.getStatus());
		if(StringUtil.isGreatOne(orderQuery.getStatus())) {
			c.andStatusEqualTo(orderQuery.getStatus());
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
		if(orderQuery.getSupplierId() != null) {
			if(orderQuery.getSupplierId() != 1) {
				if(orderList != null) {
					BigDecimal income = new BigDecimal(0.00);
					for(OrderDO orderDO : orderList) {
						if(orderDO.getStatus() == 6) {
							income = income.add(orderDO.getwOFee());
						}
					}
					result.setModel(ResultSupport.THIRD_MODEL_KEY, income);
				}
			}
		}
		result.setModel(ResultSupport.FIRST_MODEL_KEY, orderList);
		
		return result;
	}
	
	
	@Override
	public ResultDO watiList() {
		
		ResultSupport result = new ResultSupport();
		
		WOrderExample example = new WOrderExample();
		WOrderExample.Criteria c = example.createCriteria();
		
	
		c.andWOServiceTypeEqualTo(0).andStatusEqualTo(2);
	
		example.setOrderByClause(" CREATE_TIME DESC");
		
		c.andDatalevelEqualTo(1);
		
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
		
		for(int i = 0; i < orderList.size(); i++) {
			OrderDO orderDO = orderList.get(i);
			WOrderDetail orderDetail = null;
			try {
				orderDetail = orderDetailMapper.selectByPrimaryKey(orderDO.getId());
			} catch (Exception e) {
				result.setSuccess(false);
		        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
		        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
		        logger.error("[obj:order][opt:get][msg:"+e.getMessage()+"]");
		        return result;
			}
			orderDO.setOrderDetailDO(getOrderDetailDO(orderDetail));
		}
		result.setModel(ResultSupport.FIRST_MODEL_KEY, orderList);
		
		return result;
	}
	
	class Settle implements Runnable {

		@Override
		public void run() {
			while(true) {
				WSupplierExample example = new WSupplierExample();
				example.createCriteria().andDatalevelEqualTo(1);
				List<WSupplier> list = null;
				try {
					list = supplierMapper.selectByExample(example);
				} catch (Exception e) {
			        logger.error("[obj:order][opt:get][msg:"+e.getMessage()+"]");
			        e.printStackTrace();
				}
				
				if(list != null) {
					for(WSupplier supplier : list) {
						WOrderExample woex = new WOrderExample();
						Integer id = supplier.getId();
						logger.info("结算渠道商：" + supplier.getwSName());
						woex.createCriteria()
						.andWOSupplierIdEqualTo(id)
						.andWOIsPayEqualTo(1)
						.andStatusEqualTo(6);
						List<WOrder> ls = null;
						try {
							ls = orderMapper.selectByExample(woex);
						} catch (Exception e) {
					        logger.error("[obj:order][opt:get][msg:"+e.getMessage()+"]");
					        e.printStackTrace();
						}
						List<WSmsRecord> recordList = null;
						WSmsRecordExample srex = new WSmsRecordExample();
						srex.createCriteria().andSSupplierIdEqualTo(id).andStatusEqualTo(1);
						BigDecimal smsFee = new BigDecimal(0.00);
						try {
							recordList = smsRecordMapper.selectByExample(srex);
							
							for(WSmsRecord record : recordList) {
								smsFee = smsFee.add(record.getsFee());
								record.setStatus(2);
								smsRecordMapper.updateByPrimaryKey(record);
							}
						} catch (Exception e) {
					        logger.error("[obj:order][opt:get][msg:"+e.getMessage()+"]");
					        e.printStackTrace();
						}
						if(ls != null) {
							for(WOrder order : ls) {
								int recordNum = -1;
								logger.info("结算账单号：" + order.getwOOrderNo());
								try {
									WSupplierAccount supplierAccount = supplierAccountMapper.selectByPrimaryKey(id);
									if(supplierAccount != null) {
										BigDecimal balance = supplierAccount.getwABalance();
										balance = balance.add(order.getwOFee());
										supplierAccount.setwABalance(balance);
										recordNum = supplierAccountMapper.updateByPrimaryKey(supplierAccount);
										if(recordNum > 0) {
											order.setStatus(7);
											orderMapper.updateByPrimaryKey(order);
										}
									}
								} catch (Exception e) {
							        logger.error("[obj:order][opt:get][msg:"+e.getMessage()+"]");
							        e.printStackTrace();
								}
								logger.info("结算账单号完成");
							}
						}
						try {
							WSupplierAccount supplierAccount = supplierAccountMapper.selectByPrimaryKey(id);
							if(supplierAccount != null) {
								BigDecimal balance = supplierAccount.getwABalance();
								logger.info("结算短信费用" + smsFee);
									if(smsFee.compareTo(BigDecimal.ZERO) != 0) { 
										balance = balance.divide(smsFee);
										supplierAccount.setwABalance(balance);
										supplierAccountMapper.updateByPrimaryKey(supplierAccount);
								}
								
							}
						} catch (Exception e) {
					        logger.error("[obj:order][opt:get][msg:"+e.getMessage()+"]");
					        e.printStackTrace();
						}
					}
				}
				
				try {
					Thread.sleep(1 * 60 * 60 * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
}
