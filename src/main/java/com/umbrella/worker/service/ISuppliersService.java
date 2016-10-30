package com.umbrella.worker.service;

import com.umbrella.worker.dto.SupplierDO;
import com.umbrella.worker.query.SupplierAccountQuery;
import com.umbrella.worker.query.SupplierPayrecordQuery;
import com.umbrella.worker.query.SupplierQuery;
import com.umbrella.worker.result.ResultDO;

public interface ISuppliersService {

	public ResultDO create(SupplierDO supplierDO);
	
	public ResultDO modifi(SupplierDO supplierDO);
	
	public ResultDO remove(int supplierId);
	
	public ResultDO get(int supplierId);
	
	public ResultDO list(SupplierQuery supplierQuery);
	
	public ResultDO getAccount(Integer id);
	
	public ResultDO listAccount(SupplierAccountQuery query);
	
	public ResultDO listPayrecord(SupplierPayrecordQuery query);
}
