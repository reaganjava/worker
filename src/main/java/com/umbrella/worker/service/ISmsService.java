package com.umbrella.worker.service;

import com.umbrella.worker.dto.SmsCodeDO;
import com.umbrella.worker.query.SmsCodeQuery;
import com.umbrella.worker.result.ResultDO;

public interface ISmsService {
	
	public ResultDO create(SmsCodeDO smsCodeDO);
	
	public ResultDO validate(SmsCodeQuery smsCodeQuery);

}
