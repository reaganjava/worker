package com.umbrella.worker.service.impl;

import java.util.Calendar;
import java.util.List;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.umbrella.worker.dao.WPayrecordMapper;
import com.umbrella.worker.dto.PayrecordDO;
import com.umbrella.worker.entity.WOrder;
import com.umbrella.worker.entity.WOrderExample;
import com.umbrella.worker.entity.WPayrecord;
import com.umbrella.worker.entity.WPayrecordExample;
import com.umbrella.worker.query.PayrecordQuery;
import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.result.ResultSupport;
import com.umbrella.worker.service.IPayService;
import com.umbrella.worker.util.BeanUtilsExtends;
import com.umbrella.worker.util.StringUtil;


@Service("payService")
public class PayServiceImpl  extends BaseServiceImpl implements IPayService {
	
	private static Logger logger = Logger.getLogger(PayServiceImpl.class);

	@Autowired
	private WPayrecordMapper payrecordMapper;

	@Override
	public ResultDO create(PayrecordDO payrecordDO) {
		
		WPayrecord payrecord = new WPayrecord();
		
		ResultSupport result = BeanUtilsExtends.copy(payrecord, payrecordDO);
		
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

		ResultSupport result = BeanUtilsExtends.copy(payrecord, payrecordDO);
		// 拷贝失败
		if (!result.isSuccess()) {
			return result;
		}
		payrecord.setModifiTime(Calendar.getInstance().getTime());
		int recordNum = -1;
		try {
			recordNum = payrecordMapper.updateByPrimaryKeySelective(payrecord);
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
	
	
	public ResultDO updateStatus(PayrecordDO payrecordDO) {
		WPayrecordExample example = new WPayrecordExample();
		ResultSupport result = new ResultSupport();
		example.createCriteria().andWPrOrderNoEqualTo(payrecordDO.getwPrOrderNo());
		WPayrecord payrecord = new WPayrecord();
		payrecord.setwPrStatus(1);
		payrecord.setModifiAuthor("system");
		payrecord.setModifiTime(Calendar.getInstance().getTime());
		
		int recordNum = -1;
		try {
			recordNum = payrecordMapper.updateByExampleSelective(payrecord, example);
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
	
		if(StringUtil.isEmpty(payrecordQuery.getOrderNo())) {
			c.andWPrOrderNoEqualTo(payrecordQuery.getOrderNo());
		}
		
		if(StringUtil.isNotEmpty(payrecordQuery.getOrderByClause())) {	
			example.setOrderByClause(" " + payrecordQuery.getOrderByClause() + " " + payrecordQuery.getSort());
		} else {
			example.setOrderByClause(" CREATE_TIME DESC");
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
	
	
}
