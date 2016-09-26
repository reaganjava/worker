package com.umbrella.worker.service;

import com.umbrella.worker.result.ResultDO;

public interface ISMSGatewayService {
	
	public ResultDO send(String mobile, String smsTempKey, String value, int channelType);
}
