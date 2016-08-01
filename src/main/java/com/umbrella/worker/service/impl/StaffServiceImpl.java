package com.umbrella.worker.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

import com.umbrella.worker.dao.WStaffMapper;
import com.umbrella.worker.dto.StaffDO;
import com.umbrella.worker.entity.WStaff;
import com.umbrella.worker.entity.WStaffExample;
import com.umbrella.worker.query.StaffQuery;
import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.result.ResultSupport;
import com.umbrella.worker.service.IStaffService;
import com.umbrella.worker.util.BeanUtilsExtends;
import com.umbrella.worker.util.StringUtil;

public class StaffServiceImpl implements IStaffService {
	
	private static Logger logger = Logger.getLogger(StaffServiceImpl.class);
	
	private WStaffMapper staffMapper;

	@Override
	public ResultDO create(StaffDO staffDO) {
		
		WStaff staff = new WStaff();
		
		ResultSupport result = BeanUtilsExtends.copy(staffDO, staff);
		
		if(!result.isSuccess()) {
			return result;
		}
		
		int recordNum = -1;
		
		staff.setDatalevel(1);
		staff.setStatus(1);
		staff.setCreateTime(Calendar.getInstance().getTime());
		staff.setModifiTime(Calendar.getInstance().getTime());
		
		try {
			recordNum = staffMapper.insertSelective(staff);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
			logger.error("[obj:Staff][opt:create][msg:" + e.getMessage()
			+ "]");
			return result;
		}
		
		if(recordNum == 1) {
			result.setModel(ResultDO.FIRST_MODEL_KEY, staff.getId());
		} else {
			result.setSuccess(false);
		}
		return result;
	}

	@Override
	public ResultDO modifi(StaffDO staffDO) {
		
		WStaff staff = new WStaff();

		ResultSupport result = BeanUtilsExtends.copy(staff, staffDO);
		// 拷贝失败
		if (!result.isSuccess()) {
			return result;
		}
		staff.setModifiTime(Calendar.getInstance().getTime());
		int recordNum = -1;
		try {
			recordNum = staffMapper.updateByPrimaryKey(staff);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
			result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			logger.error("[obj:Staff][opt:modifi][msg:" + e.getMessage()
					+ "]");
			return result;
		}
		if (recordNum < 1) {
			result.setSuccess(false);
		}

		return result;
	}

	@Override
	public ResultDO remove(int staffId) {
		
		ResultSupport result = new ResultSupport();
		
		WStaff staff = new WStaff();
		
		if(StringUtil.isGreatOne(staffId)) {
			staff.setId(staffId);
		} else {
		    result.setSuccess(false);
		    return result;
		}
		staff.setDatalevel(-1);
		int recordNum = -1;
		try {
			recordNum = staffMapper.updateByPrimaryKeySelective(staff);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:staff][opt:remove][msg:"+e.getMessage()+"]");
	        return result;
		}
		if (recordNum != 1) {
			result.setSuccess(false);
		}
		return result;
	}

	@Override
	public ResultDO get(int staffId) {
		
		ResultSupport result = new ResultSupport();
		
		WStaff staff = null;
		if(!StringUtil.isGreatOne(staffId)) {
			 result.setSuccess(false);
			 return result;
		} 
		
		try {
			staff = staffMapper.selectByPrimaryKey(staffId);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:staff][opt:get][msg:"+e.getMessage()+"]");
	        return result;
		}
		
		
		
		StaffDO staffDO = getStaffDO(staff);
		if(staffDO != null) {
			result.setModel(ResultSupport.FIRST_MODEL_KEY, staffDO);
		} else {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			return result;
		}
		
		return result;
	}

	@Override
	public ResultDO list(StaffQuery staffQuery) {
		
		ResultSupport result = new ResultSupport();
		
		WStaffExample example = new WStaffExample();
		WStaffExample.Criteria c = example.createCriteria();
		
		
		
		if(StringUtil.isNotEmpty(staffQuery.getOrderByClause())) {	
			example.setOrderByClause(" " + staffQuery.getOrderByClause() + " " + staffQuery.getSort());
		} else {
			example.setOrderByClause(" W_M_REGISTER_TIME DESC");
		}
		
		if(staffQuery.isPage()) {
			long count = 0;
			try {
				count = staffMapper.countByExample(example);
			} catch (Exception e) {
				result.setSuccess(false);
		        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
		        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
		        e.printStackTrace();
		        logger.error("[obj:member][opt:get][msg:"+e.getMessage()+"]");
		        return result;
			}
			result.setModel(ResultSupport.SECOND_MODEL_KEY, count);
			int pageNO = staffQuery.getPageNO();
			if(pageNO > 0) {
				pageNO = pageNO -1;
			}
			String pageByClause = " limit " + (pageNO * staffQuery.getPageRows())
					+ "," + staffQuery.getPageRows();
			
			example.setPageByClause(pageByClause);
		}
		
		List<WStaff> list = null;
		
		try {
			list = staffMapper.selectByExample(example);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:staff][opt:get][msg:"+e.getMessage()+"]");
	        return result;
		}
		
		List<StaffDO> staffList = getStaffDOList(list);
		
		if(staffList.size() > 0) {
			result.setModel(ResultSupport.FIRST_MODEL_KEY, staffList);
		} else {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        return result;
		}
		return result;
	}
	
	private StaffDO getStaffDO(WStaff obj) {
		if(obj == null) return null;
		StaffDO dst = new StaffDO();
		return BeanUtilsExtends.copyProperties(dst, obj) ? dst : null;
	}
	
	private List<StaffDO> getStaffDOList(List<WStaff> list) {
		List<StaffDO> resultList = new ArrayList<StaffDO>();
		if(list != null && list.isEmpty()) {
			for(WStaff staff : list) {
				StaffDO staffDO = this.getStaffDO(staff);
				if(staffDO != null) {
					resultList.add(staffDO);
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
