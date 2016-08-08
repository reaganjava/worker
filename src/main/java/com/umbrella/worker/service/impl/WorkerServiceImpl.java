package com.umbrella.worker.service.impl;

import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umbrella.worker.dao.WWorkerItemMapper;
import com.umbrella.worker.dao.WWorkerStaffMapper;
import com.umbrella.worker.dao.WWorkerTaskMapper;
import com.umbrella.worker.dto.WorkerItemDO;
import com.umbrella.worker.dto.WorkerStaffDO;
import com.umbrella.worker.dto.WorkerTaskDO;
import com.umbrella.worker.entity.WWorkerItem;
import com.umbrella.worker.entity.WWorkerItemExample;
import com.umbrella.worker.entity.WWorkerStaff;
import com.umbrella.worker.entity.WWorkerStaffExample;
import com.umbrella.worker.entity.WWorkerTask;
import com.umbrella.worker.entity.WWorkerTaskExample;
import com.umbrella.worker.query.WorkerTaskQuery;
import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.result.ResultSupport;
import com.umbrella.worker.service.IWorkerService;
import com.umbrella.worker.util.BeanUtilsExtends;
import com.umbrella.worker.util.StringUtil;

@Service("workerService")
public class WorkerServiceImpl  extends BaseServiceImpl implements IWorkerService {
	
	private static Logger logger = Logger.getLogger(WorkerServiceImpl.class);
	
	@Autowired
	private WWorkerTaskMapper workerTaskMapper;
	@Autowired
	private WWorkerItemMapper workerItemMapper;
	@Autowired
	private WWorkerStaffMapper workerStaffMapper;

	@Override
	public ResultDO create(WorkerTaskDO workerTaskDO) {
		
		WWorkerTask workerTask = new WWorkerTask();
		
		ResultSupport result = BeanUtilsExtends.copy(workerTask, workerTaskDO);
		
		if(!result.isSuccess()) {
			return result;
		}
		
		int recordNum = -1;
		
		workerTask.setDatalevel(1);
		workerTask.setStatus(1);
		workerTask.setCreateTime(Calendar.getInstance().getTime());
		workerTask.setModifiTime(Calendar.getInstance().getTime());
		workerTask.setModifiAuthor(workerTask.getCreateAuthor());
		try {
			recordNum = workerTaskMapper.insertSelective(workerTask);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
			logger.error("[obj:service][opt:create][msg:" + e.getMessage()
			+ "]");
			return result;
		}
		
		if(recordNum < 1) {
			result.setSuccess(false);
			return result;
		}
		
		for(WorkerItemDO workerItemDO : workerTaskDO.getWorkerItems()) {
			recordNum = -1;
			WWorkerItem workerItem = new WWorkerItem();
			result = BeanUtilsExtends.copy(workerItem, workerItemDO);
			workerItem.setDatalevel(1);
			workerItem.setStatus(1);
			workerItem.setCreateTime(Calendar.getInstance().getTime());
			workerItem.setModifiTime(Calendar.getInstance().getTime());
			workerItem.setwWiTaskId(workerTask.getId());
			try {
				recordNum = workerItemMapper.insertSelective(workerItem);
			} catch (Exception e) {
				result.setSuccess(false);
				result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
				result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
				logger.error("[obj:service][opt:create][msg:" + e.getMessage()
				+ "]");
				return result;
			}
			
			if(recordNum < 1) {
				result.setSuccess(false);
				return result;
			}
		}
		
		for(WorkerStaffDO workerStaffDO : workerTaskDO.getWorkerStaffs()) {
			recordNum = -1;
			WWorkerStaff workerStaff = new WWorkerStaff();
			result = BeanUtilsExtends.copy(workerStaff, workerStaffDO);
			workerStaff.setDatalevel(1);
			workerStaff.setStatus(1);
			workerStaff.setCreateTime(Calendar.getInstance().getTime());
			workerStaff.setModifiTime(Calendar.getInstance().getTime());
			workerStaff.setwWsTaskId(workerTask.getId());
			try {
				recordNum = workerStaffMapper.insertSelective(workerStaff);
			} catch (Exception e) {
				result.setSuccess(false);
				result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
				result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
				logger.error("[obj:service][opt:create][msg:" + e.getMessage()
				+ "]");
				return result;
			}
			
			if(recordNum < 1) {
				result.setSuccess(false);
				return result;
			}
		}
		
		result.setModel(ResultDO.FIRST_MODEL_KEY, workerTask.getId());
		
		return result;
	}
	
	
	

	@Override
	public ResultDO modifi(WorkerTaskDO workerTaskDO) {
		
		WWorkerTask workerTask = new WWorkerTask();

		ResultSupport result = BeanUtilsExtends.copy(workerTask, workerTaskDO);
		// 拷贝失败
		if (!result.isSuccess()) {
			return result;
		}
		workerTask.setModifiTime(Calendar.getInstance().getTime());
		int recordNum = -1;
		try {
			recordNum = workerTaskMapper.updateByPrimaryKey(workerTask);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
			result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			logger.error("[obj:schedule][opt:modifi][msg:" + e.getMessage()
					+ "]");
			return result;
		}
		
		if (recordNum < 1) {
			result.setSuccess(false);
			return result;
		}
		
		for(WorkerItemDO workerItemDO : workerTaskDO.getWorkerItems()) {
			WWorkerItem workerItem = new WWorkerItem();
			recordNum = -1;
			result = BeanUtilsExtends.copy(workerItem, workerItemDO);
			// 拷贝失败
			if (!result.isSuccess()) {
				return result;
			}
			
			try {
				recordNum = workerItemMapper.updateByPrimaryKey(workerItem);
			} catch (Exception e) {
				result.setSuccess(false);
				result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
				result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
				logger.error("[obj:schedule][opt:modifi][msg:" + e.getMessage()
						+ "]");
				return result;
			}
			
			if(recordNum < 1) {
				result.setSuccess(false);
				return result;
			}
		}
		
		for(WorkerStaffDO workerStaffDO : workerTaskDO.getWorkerStaffs()) {
			WWorkerStaff workerStaff = new WWorkerStaff();
			recordNum = -1;
			result = BeanUtilsExtends.copy(workerStaff, workerStaffDO);
			// 拷贝失败
			if (!result.isSuccess()) {
				return result;
			}
			
			try {
				recordNum = workerStaffMapper.updateByPrimaryKey(workerStaff);
			} catch (Exception e) {
				result.setSuccess(false);
				result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
				result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
				logger.error("[obj:schedule][opt:modifi][msg:" + e.getMessage()
						+ "]");
				return result;
			}
			
			if(recordNum < 1) {
				result.setSuccess(false);
				return result;
			}
		}
		

		return result;
	}

	@Override
	public ResultDO remove(int workerTaskId) {
		
		ResultSupport result = new ResultSupport();
		
		WWorkerTask workerTask = new WWorkerTask();
		
		if(StringUtil.isGreatOne(workerTaskId)) {
			workerTask.setId(workerTaskId);
		} else {
		    result.setSuccess(false);
		    return result;
		}
		workerTask.setDatalevel(-1);
		int recordNum = -1;
		try {
			recordNum = workerTaskMapper.updateByPrimaryKeySelective(workerTask);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:schedule][opt:remove][msg:"+e.getMessage()+"]");
	        return result;
		}
		if (recordNum < 1) {
			result.setSuccess(false);
			return result;
		}
		
		WWorkerItemExample wiex = new WWorkerItemExample();
		wiex.createCriteria().andWWiTaskIdEqualTo(workerTaskId);
		WWorkerItem workerItem = new WWorkerItem();
		workerItem.setDatalevel(-1);
		
		try {
			workerItemMapper.updateByExample(workerItem, wiex);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:schedule][opt:remove][msg:"+e.getMessage()+"]");
		}
		
		WWorkerStaffExample wsex = new WWorkerStaffExample();
		wsex.createCriteria().andWWsTaskIdEqualTo(workerTaskId);
		WWorkerStaff workerStaff = new WWorkerStaff();
		workerStaff.setDatalevel(-1);
		
		try {
			workerStaffMapper.updateByExample(workerStaff, wsex);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:schedule][opt:remove][msg:"+e.getMessage()+"]");
		}
		
		return result;
	}

	@Override
	public ResultDO get(int	workerTaskId) {
		
		ResultSupport result = new ResultSupport();
		
		WWorkerTask workerTask = null;
		if(!StringUtil.isGreatOne(workerTaskId)) {
			 result.setSuccess(false);
			 return result;
		} 
		
		try {
			workerTask = workerTaskMapper.selectByPrimaryKey(workerTaskId);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:supplier][opt:get][msg:"+e.getMessage()+"]");
	        return result;
		}
		
		WorkerTaskDO workerTaskDO = getWorkerTaskDO(workerTask);
		if(workerTaskDO == null) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			return result;
		}
	
		List<WWorkerItem> workerItemList = null; 
		
		WWorkerItemExample wiex = new WWorkerItemExample();
		wiex.createCriteria().andWWiTaskIdEqualTo(workerTaskId);
		try {
			workerItemList = workerItemMapper.selectByExample(wiex);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:supplier][opt:get][msg:"+e.getMessage()+"]");
	        return result;
		}
		
		if(workerItemList.size() > 0) {
			workerTaskDO.setWorkerItems(getWorkerItemDOList(workerItemList));
		} else {
			result.setSuccess(false);
			 return result;
		}
		
		List<WWorkerStaff> workerStaffList = null; 
		
		WWorkerStaffExample wsex = new WWorkerStaffExample();
		wsex.createCriteria().andWWsTaskIdEqualTo(workerTaskId);
		try {
			workerStaffList = workerStaffMapper.selectByExample(wsex);
			
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:supplier][opt:get][msg:"+e.getMessage()+"]");
	        return result;
		}
		
		if(workerStaffList.size() > 0) {
			workerTaskDO.setWorkerStaffs(getWorkerStaffDOList(workerStaffList));
		} else {
			result.setSuccess(false);
			return result;
		}
		
		result.setModel(ResultSupport.FIRST_MODEL_KEY, workerTaskDO);
		
		return result;
	}
	
	@Override
	public ResultDO get(int	taskId, int itemId, int staffId) {
		
		ResultSupport result = new ResultSupport();
		
		WWorkerTask workerTask = null;
		if(!StringUtil.isGreatOne(taskId)) {
			 result.setSuccess(false);
			 return result;
		} 
		
		if(!StringUtil.isGreatOne(itemId)) {
			 result.setSuccess(false);
			 return result;
		} 
		
		if(!StringUtil.isGreatOne(staffId)) {
			 result.setSuccess(false);
			 return result;
		} 
		
		try {
			workerTask = workerTaskMapper.selectByPrimaryKey(taskId);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:supplier][opt:get][msg:"+e.getMessage()+"]");
	        return result;
		}
		
		WorkerTaskDO workerTaskDO = getWorkerTaskDO(workerTask);
		if(workerTaskDO == null) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			return result;
		}
	
		WWorkerItem workerItem = null;
		
		try {
			workerItem = workerItemMapper.selectByPrimaryKey(itemId);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:supplier][opt:get][msg:"+e.getMessage()+"]");
	        return result;
		}
		
		WorkerItemDO workerItemDO = getWorkerItemDO(workerItem);
		
		WWorkerStaff workerStaff = null;
		try {
			workerStaff = workerStaffMapper.selectByPrimaryKey(taskId);
			
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:supplier][opt:get][msg:"+e.getMessage()+"]");
	        return result;
		}
		
		WorkerStaffDO workerStaffDO = getWorkerStaffDO(workerStaff);
		workerTaskDO.getWorkerItems().add(workerItemDO);
		workerTaskDO.getWorkerStaffs().add(workerStaffDO);
		
		result.setModel(ResultSupport.FIRST_MODEL_KEY, workerTaskDO);
		
		return result;
	}

	@Override
	public ResultDO list(WorkerTaskQuery workerTaskQuery) {
		
		ResultSupport result = new ResultSupport();
		
		WWorkerTaskExample example = new WWorkerTaskExample();
		WWorkerTaskExample.Criteria c = example.createCriteria();
		
		
		
		if(StringUtil.isNotEmpty(workerTaskQuery.getOrderByClause())) {	
			example.setOrderByClause(" " + workerTaskQuery.getOrderByClause() + " " + workerTaskQuery.getSort());
		} else {
			example.setOrderByClause(" W_M_REGISTER_TIME DESC");
		}
		
		List<WWorkerTask> list = null;
		
		try {
			list = workerTaskMapper.selectByExample(example);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:supplier][opt:get][msg:"+e.getMessage()+"]");
	        return result;
		}
		
		List<WorkerTaskDO> workerTaskList = getWorkerTaskDOList(list);
		
		if(workerTaskList.size() > 0) {
			result.setModel(ResultSupport.FIRST_MODEL_KEY, workerTaskList);
		} else {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        return result;
		}
		return result;
	}
	
	

}
