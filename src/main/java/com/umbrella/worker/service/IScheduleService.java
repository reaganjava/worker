package com.umbrella.worker.service;

import com.umbrella.worker.dto.ScheduleDO;
import com.umbrella.worker.query.ScheduleQuery;
import com.umbrella.worker.result.ResultDO;

public interface IScheduleService {
	
	public ResultDO create(ScheduleDO scheduleDO);
	
	public ResultDO modifi(ScheduleDO scheduleDO);
	
	public ResultDO remove(int scheduleId);
	
	public ResultDO get(int contactId);
	
	public ResultDO list(ScheduleQuery scheduleQuery);

}
