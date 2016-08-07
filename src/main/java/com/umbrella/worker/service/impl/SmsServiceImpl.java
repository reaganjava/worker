package com.umbrella.worker.service.impl;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umbrella.worker.dao.WSmsCodeMapper;
import com.umbrella.worker.dao.WSmsTemplateMapper;
import com.umbrella.worker.dto.SmsCodeDO;
import com.umbrella.worker.entity.WSmsCode;
import com.umbrella.worker.entity.WSmsCodeExample;
import com.umbrella.worker.query.SmsCodeQuery;
import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.result.ResultSupport;
import com.umbrella.worker.service.ISmsService;
import com.umbrella.worker.util.BeanUtilsExtends;

@Service("smsService")
public class SmsServiceImpl implements ISmsService {

	private static Logger logger = Logger.getLogger(SmsServiceImpl.class);

	@Autowired
	private WSmsCodeMapper smsCodeMapper;

	@Autowired
	private WSmsTemplateMapper smsTemplateMapper;

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
			System.out.println(smsCode.getwSmMobile());
			recordNum = smsCodeMapper.insertSelective(smsCode);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
			logger.error("[obj:transaction][opt:create][msg:" + e.getMessage() + "]");
			return result;
		}

		if (recordNum == 1) {
			result.setModel(ResultDO.FIRST_MODEL_KEY, smsCode.getwSmCode());
		} else {
			result.setSuccess(false);
		}
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
			WSmsCodeExample exmaple = new WSmsCodeExample();
		
			exmaple.createCriteria()
			.andWSmCodeEqualTo(smsCode)
			.andStatusEqualTo(1);
			
			try {
				list = smsCodeMapper.selectByExample(exmaple);
			} catch (Exception e) {
	            throw new Exception("random code Exception");
			}
		} while(list.size() > 0);
		return smsCode;
	}
}
