package com.umbrella.worker.service.impl;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umbrella.worker.dao.WSmsCodeMapper;
import com.umbrella.worker.dao.WSmsRecordMapper;

import com.umbrella.worker.dto.SmsCodeDO;
import com.umbrella.worker.dto.SmsRecordDO;

import com.umbrella.worker.entity.WSmsCode;
import com.umbrella.worker.entity.WSmsCodeExample;
import com.umbrella.worker.entity.WSmsRecord;
import com.umbrella.worker.entity.WSmsRecordExample;
import com.umbrella.worker.query.SmsCodeQuery;
import com.umbrella.worker.query.SmsRecordQuery;
import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.result.ResultSupport;
import com.umbrella.worker.service.ISMSGatewayService;
import com.umbrella.worker.service.ISmsService;
import com.umbrella.worker.util.BeanUtilsExtends;
import com.umbrella.worker.util.StringUtil;

@Service("smsService")
public class SmsServiceImpl  extends BaseServiceImpl implements ISmsService {

	private static Logger logger = Logger.getLogger(SmsServiceImpl.class);

	@Autowired
	private WSmsCodeMapper smsCodeMapper;
	
	@Autowired
	private WSmsRecordMapper smsRecordMapper;
	
	@Autowired
	private ISMSGatewayService smsGatewayService;

	public ResultDO create(SmsCodeDO smsCodeDO) {

		WSmsCode smsCode = new WSmsCode();

		ResultSupport result = BeanUtilsExtends.copy(smsCode, smsCodeDO);

		if (!result.isSuccess()) {
			return result;
		}

		int recordNum = -1;
		try {
			smsCode.setwSmCode(randomNumber());
		} catch (Exception e) {
			result.setSuccess(false);
			result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
			logger.error("[obj:transaction][opt:create][msg:" + e.getMessage() + "]");
			return result;
		}
		
		smsCode.setDatalevel(1);
		smsCode.setStatus(1);
		smsCode.setCreateTime(Calendar.getInstance().getTime());
		smsCode.setModifiTime(Calendar.getInstance().getTime());
		smsCode.setModifiAuthor(smsCode.getCreateAuthor());

		try {
			recordNum = smsCodeMapper.insertSelective(smsCode);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
			logger.error("[obj:transaction][opt:create][msg:" + e.getMessage() + "]");
			return result;
		}
		
		if(recordNum > 0) {
			smsGatewayService.initSMS();
			ResultDO resultDO = smsGatewayService.send(smsCode.getwSmMobile(), smsCodeDO.getwSmTempKey(), smsCode.getwSmCode(), 1);
			if(!resultDO.isSuccess()) {
				result.setSuccess(false);
			}
		} else {
			result.setSuccess(false);
		}
		return result;
	}
	
	public ResultDO recordList(SmsRecordQuery query) {
		ResultSupport result = new ResultSupport();
		
		WSmsRecordExample example = new WSmsRecordExample();
		WSmsRecordExample.Criteria c = example.createCriteria();
		
	
		if(StringUtil.isGreatOne(query.getSupplierId())) {
			c.andSSupplierIdEqualTo(query.getSupplierId());
		}
		
		if(StringUtil.isNotEmpty(query.getOrderByClause())) {	
			example.setOrderByClause(" " + query.getOrderByClause() + " " + query.getSort());
		} else {
			example.setOrderByClause(" CREATE_TIME DESC");
		}
		
		c.andDatalevelEqualTo(1);
		
		if(query.isPage()) {
			long count = 0;
			try {
				count = smsRecordMapper.countByExample(example);
			} catch (Exception e) {
				result.setSuccess(false);
		        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
		        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
		        e.printStackTrace();
		        logger.error("[obj:member][opt:get][msg:"+e.getMessage()+"]");
		        return result;
			}
			result.setModel(ResultSupport.SECOND_MODEL_KEY, count);
			int pageNO = query.getPageNO();
			if(pageNO > 0) {
				pageNO = pageNO -1;
			}
			String pageByClause = " limit " + (pageNO * query.getPageRows())
					+ "," + query.getPageRows();
			System.out.println("count:" + count);
			System.out.println(pageByClause);
			example.setPageByClause(pageByClause);
		}
		
		List<WSmsRecord> list = null;
		
		try {
			list = smsRecordMapper.selectByExample(example);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:order][opt:get][msg:"+e.getMessage()+"]");
	        return result;
		}
		
		List<SmsRecordDO> smsRecordDOList = getSmsRecordDOList(list);
		
		result.setModel(ResultSupport.FIRST_MODEL_KEY, smsRecordDOList);
		
		return result;
	}
	
	public ResultDO validate(SmsCodeQuery smsCodeQuery) {
		
		ResultSupport result = new ResultSupport();
		
		WSmsCodeExample exmaple = new WSmsCodeExample();
		exmaple.createCriteria()
		.andWSmMobileEqualTo(smsCodeQuery.getMobile())
		.andWSmCodeEqualTo(smsCodeQuery.getCode())
		.andStatusEqualTo(1);
		
		List<WSmsCode> list = null;
		try {
			list = smsCodeMapper.selectByExample(exmaple);
		} catch (Exception e) {
            result.setSuccess(false);
            result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
            result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
            logger.error("[obj:member][opt:login][msg:"+e.getMessage()+"]");
            return result;
		}
		
		if(list.size() < 1) {
			result.setSuccess(false);
			return result;
		}
		
		int recordNum = -1;
		
		try {
			WSmsCode smsCode = list.get(0);
			smsCode.setStatus(-1);
			smsCode.setModifiAuthor(smsCodeQuery.getMobile());
			smsCode.setwSmValidTime(Calendar.getInstance().getTime());
			smsCode.setModifiTime(smsCode.getwSmValidTime());
			recordNum = smsCodeMapper.updateByPrimaryKey(smsCode);
		} catch (Exception e) {
            result.setSuccess(false);
            result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
            result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
            logger.error("[obj:member][opt:login][msg:"+e.getMessage()+"]");
            return result;
		}
		
		if(recordNum < 0) {
			result.setSuccess(false);
		}
		return result;
	}

	private String randomNumber() throws Exception {
		List<WSmsCode> list = null;
		String smsCode = "";
		do {
			Random random = new Random();
			
			for (int i = 0; i < 6; i++) {
				smsCode += random.nextInt(10);
			}
			System.out.println(smsCode);
			WSmsCodeExample exmaple = new WSmsCodeExample();
		
			exmaple.createCriteria()
			.andWSmCodeEqualTo(smsCode)
			.andStatusEqualTo(1);
			
			try {
				list = smsCodeMapper.selectByExample(exmaple);
			} catch (Exception e) {
				e.printStackTrace();
	            throw new Exception("random code Exception");
			}
		} while(list.size() > 0);
		return smsCode;
	}
}
