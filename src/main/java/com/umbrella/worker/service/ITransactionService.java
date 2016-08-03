package com.umbrella.worker.service;

import com.umbrella.worker.dto.TransactionDO;
import com.umbrella.worker.query.TransactionQuery;
import com.umbrella.worker.result.ResultDO;

public interface ITransactionService {

	public ResultDO create(TransactionDO transactionDO);
	
	public ResultDO modifi(TransactionDO transactionDO);
	
	public ResultDO remove(int transactionId);
	
	public ResultDO get(int transactionId);
	
	public ResultDO list(TransactionQuery transactionQuery);
}
