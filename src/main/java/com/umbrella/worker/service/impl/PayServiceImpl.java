package com.umbrella.worker.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

import com.umbrella.worker.dao.WCouponMapper;
import com.umbrella.worker.dao.WPayrecordMapper;
import com.umbrella.worker.dto.CouponDO;
import com.umbrella.worker.dto.PayrecordDO;
import com.umbrella.worker.entity.WCoupon;
import com.umbrella.worker.entity.WCouponExample;
import com.umbrella.worker.entity.WPayrecord;
import com.umbrella.worker.entity.WPayrecordExample;
import com.umbrella.worker.query.CouponQuery;
import com.umbrella.worker.query.PayrecordQuery;
import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.result.ResultSupport;
import com.umbrella.worker.service.ICouponService;
import com.umbrella.worker.service.IPayService;
import com.umbrella.worker.util.BeanUtilsExtends;
import com.umbrella.worker.util.StringUtil;

public class PayServiceImpl implements IPayService {
	
	private static Logger logger = Logger.getLogger(PayServiceImpl.class);
	
	private WPayrecordMapper payrecordMapper;

	@Override
	public ResultDO create(PayrecordDO payrecordDO) {
		
		WPayrecord payrecord = new WPayrecord();
		
		ResultSupport result = BeanUtilsExtends.copy(payrecordDO, payrecord);
		
		if(!result.isSuccess()) {
			return result;
		}
		
		int recordNum = -1;
		
		payrecord.setDatalevel(1);
		payrecord.setStatus(1);
		payrecord.setCreateTime(Calendar.getInstance().getTime());
		payrecord.setModifiTime(Calendar.getInstance().getTime());
		
		try {
			recordNum = payrecordMapper.insertSelective(payrecord);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
			logger.error("[obj:coupon][opt:create][msg:" + e.getMessage()
			+ "]");
			return result;
		}
		
		if(recordNum == 1) {
			result.setModel(ResultDO.FIRST_MODEL_KEY, payrecord.getId());
		} else {
			result.setSuccess(false);
		}
		return result;
	}

	@Override
	public ResultDO modifi(PayrecordDO payrecordDO) {
		
		WPayrecord payrecord = new WPayrecord();

		ResultSupport result = BeanUtilsExtends.copy(payrecordDO, payrecord);
		// 拷贝失败
		if (!result.isSuccess()) {
			return result;
		}
		payrecord.setModifiTime(Calendar.getInstance().getTime());
		int recordNum = -1;
		try {
			recordNum = payrecordMapper.updateByPrimaryKey(payrecord);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
			result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			logger.error("[obj:coupon][opt:modifi][msg:" + e.getMessage()
					+ "]");
			return result;
		}
		if (recordNum < 1) {
			result.setSuccess(false);
		}

		return result;
	}

	@Override
	public ResultDO remove(int payrecordId) {
		
		ResultSupport result = new ResultSupport();
		
		WPayrecord payrecord = new WPayrecord();
		
		if(StringUtil.isGreatOne(payrecordId)) {
			payrecord.setId(payrecordId);
		} else {
		    result.setSuccess(false);
		    return result;
		}
		payrecord.setDatalevel(-1);
		int recordNum = -1;
		try {
			recordNum = payrecordMapper.updateByPrimaryKeySelective(payrecord);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:coupon][opt:remove][msg:"+e.getMessage()+"]");
	        return result;
		}
		if (recordNum != 1) {
			result.setSuccess(false);
		}
		return result;
	}

	@Override
	public ResultDO get(int payrecordId) {
		
		ResultSupport result = new ResultSupport();
		
		WPayrecord payrecord = null;
		if(!StringUtil.isGreatOne(payrecordId)) {
			 result.setSuccess(false);
			 return result;
		} 
		
		try {
			payrecord = payrecordMapper.selectByPrimaryKey(payrecordId);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:coupon][opt:get][msg:"+e.getMessage()+"]");
	        return result;
		}
		
		PayrecordDO payrecordDO = getPayrecordDO(payrecord);
		if(payrecordDO != null) {
			result.setModel(ResultSupport.FIRST_MODEL_KEY, payrecordDO);
		} else {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			return result;
		}
		
		return result;
	}

	@Override
	public ResultDO list(PayrecordQuery payrecordQuery) {
		
		ResultSupport result = new ResultSupport();
		
		WPayrecordExample example = new WPayrecordExample();
		WPayrecordExample.Criteria c = example.createCriteria();
	
		
		if(StringUtil.isNotEmpty(payrecordQuery.getOrderByClause())) {	
			example.setOrderByClause(" " + payrecordQuery.getOrderByClause() + " " + payrecordQuery.getSort());
		} else {
			example.setOrderByClause(" W_M_REGISTER_TIME DESC");
		}
		
		if(payrecordQuery.isPage()) {
			long count = 0;
			try {
				count = payrecordMapper.countByExample(example);
			} catch (Exception e) {
				result.setSuccess(false);
		        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
		        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
		        e.printStackTrace();
		        logger.error("[obj:member][opt:get][msg:"+e.getMessage()+"]");
		        return result;
			}
			result.setModel(ResultSupport.SECOND_MODEL_KEY, count);
			int pageNO = payrecordQuery.getPageNO();
			if(pageNO > 0) {
				pageNO = pageNO -1;
			}
			String pageByClause = " limit " + (pageNO * payrecordQuery.getPageRows())
					+ "," + payrecordQuery.getPageRows();
			
			example.setPageByClause(pageByClause);
		}
		
		List<WPayrecord> list = null;
		
		try {
			list = payrecordMapper.selectByExample(example);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:coupon][opt:get][msg:"+e.getMessage()+"]");
	        return result;
		}
		
		List<PayrecordDO> payrecordList = getPayrecordDOList(list);
		
		if(payrecordList.size() > 0) {
			result.setModel(ResultSupport.FIRST_MODEL_KEY, payrecordList);
		} else {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        return result;
		}
		return result;
	}
	
	private PayrecordDO getPayrecordDO(WPayrecord obj) {
		if(obj == null) return null;
		PayrecordDO dst = new PayrecordDO();
		return BeanUtilsExtends.copyProperties(dst, obj) ? dst : null;
	}
	
	private List<PayrecordDO> getPayrecordDOList(List<WPayrecord> list) {
		List<PayrecordDO> resultList = new ArrayList<PayrecordDO>();
		if(list != null && list.isEmpty()) {
			for(WPayrecord payrecord : list) {
				PayrecordDO payrecordDO = this.getPayrecordDO(payrecord);
				if(payrecordDO != null) {
					resultList.add(payrecordDO);
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