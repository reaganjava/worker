package com.umbrella.worker.service;

import com.umbrella.worker.dto.StaffDO;
import com.umbrella.worker.query.StaffQuery;
import com.umbrella.worker.result.ResultDO;

public interface IStaffService {
	
	public ResultDO create(StaffDO staffDO);
	
	public ResultDO modifi(StaffDO staffDO);
	
	public ResultDO remove(int staffId);
	
	public ResultDO get(int staffId);
	
	public ResultDO list(StaffQuery staffQuery);
}
