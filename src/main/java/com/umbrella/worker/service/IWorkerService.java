package com.umbrella.worker.service;

import com.umbrella.worker.dto.WorkerTaskDO;
import com.umbrella.worker.query.WorkerTaskQuery;
import com.umbrella.worker.result.ResultDO;

public interface IWorkerService {
	
	public ResultDO create(WorkerTaskDO workerTaskDO);
	
	public ResultDO modifi(WorkerTaskDO workerTaskDO);
	
	public ResultDO remove(int workerTaskId);
	
	public ResultDO get(int workerTaskId);
	
	public ResultDO list(WorkerTaskQuery workerTaskQuery);

}
