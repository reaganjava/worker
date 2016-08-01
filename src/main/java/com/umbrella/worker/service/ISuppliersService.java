package com.umbrella.worker.service;

import com.umbrella.worker.dto.SupplierDO;
import com.umbrella.worker.query.SupplierQuery;
import com.umbrella.worker.result.ResultDO;

public interface ISuppliersService {

	public ResultDO create(SupplierDO supplierDO);
	
	public ResultDO modifi(SupplierDO supplierDO);
	
	public ResultDO remove(int supplierId);
	
	public ResultDO get(int supplierId);
	
	public ResultDO list(SupplierQuery supplierQuery);
}