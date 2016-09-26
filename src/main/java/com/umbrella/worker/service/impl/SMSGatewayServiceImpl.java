package com.umbrella.worker.service.impl;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umbrella.worker.dao.WSmsTemplateMapper;
import com.umbrella.worker.entity.WSmsTemplate;
import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.result.ResultSupport;
import com.umbrella.worker.service.ISMSGatewayService;
import com.umbrella.worker.util.EMYGateway;
import com.umbrella.worker.util.Gateway;
import com.umbrella.worker.util.StringUtil;

@Service("smsGatewayService")
public class SMSGatewayServiceImpl implements ISMSGatewayService {
	
	private static Logger logger = Logger.getLogger(SMSGatewayServiceImpl.class);
	
	@Autowired
	private WSmsTemplateMapper smsTemplateMapper;
	
	private Gateway gateway;

	@PostConstruct  
    public void initSMS() throws Exception {  
        logger.info("==================initMethod 被执行================");  
        gateway = new EMYGateway();
        gateway.init();
    }  
	
	
	@Override
	public ResultDO send(String mobile, String smsTempKey, String value, int channelType) {
		ResultSupport result = new ResultSupport();
		WSmsTemplate template = null;
		try {
			template = smsTemplateMapper.selectByPrimaryKey(smsTempKey);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
			logger.error("[obj:transaction][opt:create][msg:" + e.getMessage() + "]");
			return result;
		}
		
		String sendContent = null;
		if(StringUtil.isNotEmpty(value)) {
			sendContent = EMYGateway.SMS_PREX + template.getwSmContent().replace("{code}", value);
		}
		
		boolean isSend = false;
		if(template != null) {
			long seq = System.currentTimeMillis() - java.util.UUID.randomUUID().hashCode();
			isSend = gateway.sendDetail(new String[] {mobile}, sendContent, seq);
			System.out.println(isSend);
		}
		
		result.setSuccess(isSend);
		return result;
	}

}
