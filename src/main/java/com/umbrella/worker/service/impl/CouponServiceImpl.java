package com.umbrella.worker.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

import com.umbrella.worker.dao.WCouponMapper;
import com.umbrella.worker.dto.CouponDO;
import com.umbrella.worker.entity.WCoupon;
import com.umbrella.worker.entity.WCouponExample;
import com.umbrella.worker.query.CouponQuery;
import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.result.ResultSupport;
import com.umbrella.worker.service.ICouponService;
import com.umbrella.worker.util.BeanUtilsExtends;
import com.umbrella.worker.util.StringUtil;

public class CouponServiceImpl implements ICouponService {
	
	private static Logger logger = Logger.getLogger(CouponServiceImpl.class);
	
	private WCouponMapper couponMapper;

	@Override
	public ResultDO create(CouponDO couponDO) {
		
		WCoupon coupon = new WCoupon();
		
		ResultSupport result = BeanUtilsExtends.copy(couponDO, coupon);
		
		if(!result.isSuccess()) {
			return result;
		}
		
		int recordNum = -1;
		
		coupon.setDatalevel(1);
		coupon.setStatus(1);
		coupon.setCreateTime(Calendar.getInstance().getTime());
		coupon.setModifiTime(Calendar.getInstance().getTime());
		
		try {
			recordNum = couponMapper.insertSelective(coupon);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
			logger.error("[obj:coupon][opt:create][msg:" + e.getMessage()
			+ "]");
			return result;
		}
		
		if(recordNum == 1) {
			result.setModel(ResultDO.FIRST_MODEL_KEY, coupon.getId());
		} else {
			result.setSuccess(false);
		}
		return result;
	}

	@Override
	public ResultDO modifi(CouponDO couponDO) {
		
		WCoupon coupon = new WCoupon();

		ResultSupport result = BeanUtilsExtends.copy(couponDO, coupon);
		// 拷贝失败
		if (!result.isSuccess()) {
			return result;
		}
		coupon.setModifiTime(Calendar.getInstance().getTime());
		int recordNum = -1;
		try {
			recordNum = couponMapper.updateByPrimaryKey(coupon);
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
	public ResultDO remove(int couponId) {
		
		ResultSupport result = new ResultSupport();
		
		WCoupon coupon = new WCoupon();
		
		if(StringUtil.isGreatOne(couponId)) {
			coupon.setId(couponId);
		} else {
		    result.setSuccess(false);
		    return result;
		}
		coupon.setDatalevel(-1);
		int recordNum = -1;
		try {
			recordNum = couponMapper.updateByPrimaryKeySelective(coupon);
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
	public ResultDO get(int couponId) {
		
		ResultSupport result = new ResultSupport();
		
		WCoupon coupon = null;
		if(!StringUtil.isGreatOne(couponId)) {
			 result.setSuccess(false);
			 return result;
		} 
		
		try {
			coupon = couponMapper.selectByPrimaryKey(couponId);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:coupon][opt:get][msg:"+e.getMessage()+"]");
	        return result;
		}
		
		CouponDO couponDO = getCouponDO(coupon);
		if(couponDO!= null) {
			result.setModel(ResultSupport.FIRST_MODEL_KEY, couponDO);
		} else {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			return result;
		}
		
		return result;
	}

	@Override
	public ResultDO list(CouponQuery couponQuery) {
		
		ResultSupport result = new ResultSupport();
		
		WCouponExample example = new WCouponExample();
		WCouponExample.Criteria c = example.createCriteria();
		
		if(StringUtil.isEmpty(couponQuery.getTitle())) {
			c.andWCTitleEqualTo("%" + couponQuery.getTitle() + "%");
		}
		
		if(StringUtil.isNotEmpty(couponQuery.getOrderByClause())) {	
			example.setOrderByClause(" " + couponQuery.getOrderByClause() + " " + couponQuery.getSort());
		} else {
			example.setOrderByClause(" W_M_REGISTER_TIME DESC");
		}
		
		if(couponQuery.isPage()) {
			long count = 0;
			try {
				count = couponMapper.countByExample(example);
			} catch (Exception e) {
				result.setSuccess(false);
		        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
		        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
		        e.printStackTrace();
		        logger.error("[obj:member][opt:get][msg:"+e.getMessage()+"]");
		        return result;
			}
			result.setModel(ResultSupport.SECOND_MODEL_KEY, count);
			int pageNO = couponQuery.getPageNO();
			if(pageNO > 0) {
				pageNO = pageNO -1;
			}
			String pageByClause = " limit " + (pageNO * couponQuery.getPageRows())
					+ "," + couponQuery.getPageRows();
			
			example.setPageByClause(pageByClause);
		}
		
		List<WCoupon> list = null;
		
		try {
			list = couponMapper.selectByExample(example);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:coupon][opt:get][msg:"+e.getMessage()+"]");
	        return result;
		}
		
		List<CouponDO> couponList = getCouponDOList(list);
		
		if(couponList.size() > 0) {
			result.setModel(ResultSupport.FIRST_MODEL_KEY, couponList);
		} else {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        return result;
		}
		return result;
	}
	
	private CouponDO getCouponDO(WCoupon obj) {
		if(obj == null) return null;
		CouponDO dst = new CouponDO();
		return BeanUtilsExtends.copyProperties(dst, obj) ? dst : null;
	}
	
	private List<CouponDO> getCouponDOList(List<WCoupon> list) {
		List<CouponDO> resultList = new ArrayList<CouponDO>();
		if(list != null && list.isEmpty()) {
			for(WCoupon coupon : list) {
				CouponDO couponDO = this.getCouponDO(coupon);
				if(couponDO != null) {
					resultList.add(couponDO);
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
