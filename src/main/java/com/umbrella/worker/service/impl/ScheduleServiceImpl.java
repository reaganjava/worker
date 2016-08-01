package com.umbrella.worker.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

import com.umbrella.worker.dao.WScheduleMapper;
import com.umbrella.worker.dto.ScheduleDO;
import com.umbrella.worker.entity.WSchedule;
import com.umbrella.worker.entity.WScheduleExample;
import com.umbrella.worker.query.ScheduleQuery;
import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.result.ResultSupport;
import com.umbrella.worker.service.IScheduleService;
import com.umbrella.worker.util.BeanUtilsExtends;
import com.umbrella.worker.util.StringUtil;

public class ScheduleServiceImpl implements IScheduleService {
	
	private static Logger logger = Logger.getLogger(ScheduleServiceImpl.class);
	
	private WScheduleMapper scheduleMapper;

	@Override
	public ResultDO create(ScheduleDO scheduleDO) {
		
		WSchedule schedule = new WSchedule();
		
		ResultSupport result = BeanUtilsExtends.copy(scheduleDO, schedule);
		
		if(!result.isSuccess()) {
			return result;
		}
		
		int recordNum = -1;
		
		schedule.setDatalevel(1);
		schedule.setStatus(1);
		schedule.setModifiTime(Calendar.getInstance().getTime());
		
		try {
			recordNum = scheduleMapper.insertSelective(schedule);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
			logger.error("[obj:schedule][opt:create][msg:" + e.getMessage()
			+ "]");
			return result;
		}
		
		if(recordNum == 1) {
			result.setModel(ResultDO.FIRST_MODEL_KEY, schedule.getId());
		} else {
			result.setSuccess(false);
		}
		return result;
	}

	@Override
	public ResultDO modifi(ScheduleDO scheduleDO) {
		
		WSchedule schedule = new WSchedule();

		ResultSupport result = BeanUtilsExtends.copy(scheduleDO, schedule);
		// 拷贝失败
		if (!result.isSuccess()) {
			return result;
		}
		schedule.setModifiTime(Calendar.getInstance().getTime());
		int recordNum = -1;
		try {
			recordNum = scheduleMapper.updateByPrimaryKey(schedule);
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
	public ResultDO remove(int scheduleId) {
		
		ResultSupport result = new ResultSupport();
		
		WSchedule schedule = new WSchedule();
		
		if(StringUtil.isGreatOne(scheduleId)) {
			schedule.setId(scheduleId);
		} else {
		    result.setSuccess(false);
		    return result;
		}
		schedule.setDatalevel(-1);
		int recordNum = -1;
		try {
			recordNum = scheduleMapper.updateByPrimaryKeySelective(schedule);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:schedule][opt:remove][msg:"+e.getMessage()+"]");
	        return result;
		}
		if (recordNum != 1) {
			result.setSuccess(false);
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
