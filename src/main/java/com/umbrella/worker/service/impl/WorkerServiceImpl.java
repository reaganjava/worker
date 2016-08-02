package com.umbrella.worker.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

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
import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.result.ResultSupport;
import com.umbrella.worker.service.IWorkerService;
import com.umbrella.worker.util.BeanUtilsExtends;
import com.umbrella.worker.util.StringUtil;

public class WorkerServiceImpl implements IWorkerService {
	
	private static Logger logger = Logger.getLogger(WorkerServiceImpl.class);
	
	private WWorkerTaskMapper workerTaskMapper;
	
	private WWorkerItemMapper workerItemMapper;
	
	private WWorkerStaffMapper workerStaffMapper;

	@Override
	public ResultDO create(WorkerTaskDO workerTaskDO) {
		
		WWorkerTask workerTask = new WWorkerTask();
		
		ResultSupport result = BeanUtilsExtends.copy(workerTaskDO, workerTask);
		
		if(!result.isSuccess()) {
			return result;
		}
		
		int recordNum = -1;
		
		workerTask.setDatalevel(1);
		workerTask.setStatus(1);
		workerTask.setCreateTime(Calendar.getInstance().getTime());
		workerTask.setModifiTime(Calendar.getInstance().getTime());
		
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
		
		if(recordNum == 1) {
			result.setModel(ResultDO.FIRST_MODEL_KEY, workerTask.getId());
		} else {
			result.setSuccess(false);
			return result;
		}
		
		for(WorkerItemDO workerItemDO : workerTaskDO.getWorkerItems()) {
			WWorkerItem workerItem = new WWorkerItem();
			result = BeanUtilsExtends.copy(workerItemDO, workerItem);
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
			
			if(recordNum != 1) {
				result.setSuccess(false);
				return result;
			}
		}
		
		for(WorkerStaffDO workerStaffDO : workerTaskDO.getWorkerStaffs()) {
			WWorkerStaff workerStaff = new WWorkerStaff();
			result = BeanUtilsExtends.copy(workerStaffDO, workerStaff);
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
			
			if(recordNum != 1) {
				result.setSuccess(false);
				return result;
			}
		}
		
		return result;
	}
	
	
	

	@Override
	public ResultDO modifi(WorkerTaskDO workerTaskDO) {
		
		WWorkerTask workerTask = new WWorkerTask();

		ResultSupport result = BeanUtilsExtends.copy(workerTaskDO, workerTask);
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
		if (recordNum != 1) {
			result.setSuccess(false);
			return result;
		}
		
		try {
			WWorkerItemExample wiex = new WWorkerItemExample();
			wiex.createCriteria().andWWiTaskIdEqualTo(workerTaskId);
			WWorkerItem workerItem = new WWorkerItem();
			workerItem.setDatalevel(-1);
			workerItemMapper.updateByExample(workerItem, wiex);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:schedule][opt:remove][msg:"+e.getMessage()+"]");
		}
		
		try {
			WWorkerStaffExample wsex = new WWorkerStaffExample();
			wsex.createCriteria().andWWsTaskIdEqualTo(workerTaskId);
			WWorkerStaff workerStaff = new WWorkerStaff();
			workerStaff.setDatalevel(-1);
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
	public ResultDO get(int contactId) {
		
		ResultSupport result = new ResultSupport();
		
		WSchedule schedule = null;
		if(!StringUtil.isGreatOne(contactId)) {
			 result.setSuccess(false);
			 return result;
		} 
		
		try {
			schedule = scheduleMapper.selectByPrimaryKey(contactId);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:supplier][opt:get][msg:"+e.getMessage()+"]");
	        return result;
		}
		
		ScheduleDO scheduleDO = getScheduleDO(schedule);
		if(scheduleDO != null) {
			result.setModel(ResultSupport.FIRST_MODEL_KEY, scheduleDO);
		} else {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			return result;
		}
		
		return result;
	}

	@Override
	public ResultDO list(ScheduleQuery scheduleQuery) {
		
		ResultSupport result = new ResultSupport();
		
		WScheduleExample example = new WScheduleExample();
		WScheduleExample.Criteria c = example.createCriteria();
		
		
		
		if(StringUtil.isNotEmpty(scheduleQuery.getOrderByClause())) {	
			example.setOrderByClause(" " + scheduleQuery.getOrderByClause() + " " + scheduleQuery.getSort());
		} else {
			example.setOrderByClause(" W_M_REGISTER_TIME DESC");
		}
		
		List<WSchedule> list = null;
		
		try {
			list = scheduleMapper.selectByExample(example);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:supplier][opt:get][msg:"+e.getMessage()+"]");
	        return result;
		}
		
		List<ScheduleDO> contactList = getContactDOList(list);
		
		if(contactList.size() > 0) {
			result.setModel(ResultSupport.FIRST_MODEL_KEY, contactList);
		} else {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        return result;
		}
		return result;
	}
	
	private ScheduleDO getScheduleDO(WSchedule obj) {
		if(obj == null) return null;
		ScheduleDO dst = new ScheduleDO();
		return BeanUtilsExtends.copyProperties(dst, obj) ? dst : null;
	}
	
	private List<ScheduleDO> getContactDOList(List<WSchedule> list) {
		List<ScheduleDO> resultList = new ArrayList<ScheduleDO>();
		if(list != null && list.isEmpty()) {
			for(WSchedule schedule : list) {
				ScheduleDO scheduleDO = this.getScheduleDO(schedule);
				if(scheduleDO != null) {
					resultList.add(scheduleDO);
				} else {
					return null;
				}
			}
		} else {
			return null;
		}
		return resultList;
	}

}
