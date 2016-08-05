package com.umbrella.worker.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

import com.umbrella.worker.dao.WTransactionMapper;
import com.umbrella.worker.dto.TransactionDO;
import com.umbrella.worker.entity.WTransaction;
import com.umbrella.worker.entity.WTransactionExample;
import com.umbrella.worker.query.TransactionQuery;
import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.result.ResultSupport;
import com.umbrella.worker.service.ITransactionService;
import com.umbrella.worker.util.BeanUtilsExtends;
import com.umbrella.worker.util.StringUtil;

public class TransactionServiceImpl implements ITransactionService {
	
	private static Logger logger = Logger.getLogger(TransactionServiceImpl.class);
	
	private WTransactionMapper transactionMapper;

	@Override
	public ResultDO create(TransactionDO transactionDO) {
		
		WTransaction transaction = new WTransaction();
		
		ResultSupport result = BeanUtilsExtends.copy(transaction, transactionDO);
		
		if(!result.isSuccess()) {
			return result;
		}
		
		int recordNum = -1;
		
		transaction.setDatalevel(1);
		transaction.setStatus(1);
		transaction.setCreateTime(Calendar.getInstance().getTime());
		transaction.setModifiTime(Calendar.getInstance().getTime());
		
		try {
			recordNum = transactionMapper.insertSelective(transaction);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
			logger.error("[obj:transaction][opt:create][msg:" + e.getMessage()
			+ "]");
			return result;
		}
		
		if(recordNum == 1) {
			result.setModel(ResultDO.FIRST_MODEL_KEY, transaction.getId());
		} else {
			result.setSuccess(false);
		}
		return result;
	}

	@Override
	public ResultDO modifi(TransactionDO transactionDO) {
		
		WTransaction transaction = new WTransaction();

		ResultSupport result = BeanUtilsExtends.copy(transaction, transactionDO);
		// 拷贝失败
		if (!result.isSuccess()) {
			return result;
		}
		transaction.setModifiTime(Calendar.getInstance().getTime());
		int recordNum = -1;
		try {
			recordNum = transactionMapper.updateByPrimaryKey(transaction);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
			result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			logger.error("[obj:contact][opt:modifi][msg:" + e.getMessage()
					+ "]");
			return result;
		}
		if (recordNum < 1) {
			result.setSuccess(false);
		}

		return result;
	}

	@Override
	public ResultDO remove(int transactionId) {
		
		ResultSupport result = new ResultSupport();
		
		WTransaction transaction = new WTransaction();
		
		if(StringUtil.isGreatOne(transactionId)) {
			transaction.setId(transactionId);
		} else {
		    result.setSuccess(false);
		    return result;
		}
		transaction.setDatalevel(-1);
		int recordNum = -1;
		try {
			recordNum = transactionMapper.updateByPrimaryKeySelective(transaction);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:transaction][opt:remove][msg:"+e.getMessage()+"]");
	        return result;
		}
		if (recordNum != 1) {
			result.setSuccess(false);
		}
		return result;
	}

	@Override
	public ResultDO get(int transactionId) {
		
		ResultSupport result = new ResultSupport();
		
		WTransaction transaction = null;
		if(!StringUtil.isGreatOne(transactionId)) {
			 result.setSuccess(false);
			 return result;
		} 
		
		try {
			transaction = transactionMapper.selectByPrimaryKey(transactionId);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:supplier][opt:get][msg:"+e.getMessage()+"]");
	        return result;
		}
		
		TransactionDO transactionDO = getTransactionDO(transaction);
		if(transactionDO != null) {
			result.setModel(ResultSupport.FIRST_MODEL_KEY, transactionDO);
		} else {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			return result;
		}
		
		return result;
	}

	@Override
	public ResultDO list(TransactionQuery transactionQuery) {
		
		ResultSupport result = new ResultSupport();
		
		WTransactionExample example = new WTransactionExample();
		WTransactionExample.Criteria c = example.createCriteria();
		
		if(StringUtil.isNotEmpty(transactionQuery.getOrderByClause())) {	
			example.setOrderByClause(" " + transactionQuery.getOrderByClause() + " " + transactionQuery.getSort());
		} else {
			example.setOrderByClause(" W_M_REGISTER_TIME DESC");
		}
		
		List<WTransaction> list = null;
		
		try {
			list = transactionMapper.selectByExample(example);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:supplier][opt:get][msg:"+e.getMessage()+"]");
	        return result;
		}
		
		List<TransactionDO> commentList = getTransactionDOList(list);
		
		if(commentList.size() > 0) {
			result.setModel(ResultSupport.FIRST_MODEL_KEY, commentList);
		} else {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        return result;
		}
		return result;
	}
	
	private TransactionDO getTransactionDO(WTransaction obj) {
		if(obj == null) return null;
		TransactionDO dst = new TransactionDO();
		return BeanUtilsExtends.copyProperties(dst, obj) ? dst : null;
	}
	
	private List<TransactionDO> getTransactionDOList(List<WTransaction> list) {
		List<TransactionDO> resultList = new ArrayList<TransactionDO>();
		if(list != null && list.isEmpty()) {
			for(WTransaction transaction : list) {
				TransactionDO transactionDO = this.getTransactionDO(transaction);
				if(transactionDO != null) {
					resultList.add(transactionDO);
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
