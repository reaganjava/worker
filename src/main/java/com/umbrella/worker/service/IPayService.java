package com.umbrella.worker.service;

import com.umbrella.worker.dto.PayrecordDO;
import com.umbrella.worker.query.PayrecordQuery;
import com.umbrella.worker.result.ResultDO;

public interface IPayService {

	public ResultDO create(PayrecordDO payrecordDO);
	
	public ResultDO modifi(PayrecordDO payrecordDO);
	
	public ResultDO updateStatus(PayrecordDO payrecordDO);
	
	public ResultDO remove(int payrecordId);
	
	public ResultDO get(int payrecordId);
	
	public ResultDO list(PayrecordQuery payrecordQuery);
	
}
