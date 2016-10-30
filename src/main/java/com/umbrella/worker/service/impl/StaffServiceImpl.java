package com.umbrella.worker.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umbrella.worker.dao.WCertificoreMapper;
import com.umbrella.worker.dao.WStaffMapper;
import com.umbrella.worker.dao.WStaffTimeMapper;
import com.umbrella.worker.dao.WSupplierMapper;
import com.umbrella.worker.dto.StaffDO;
import com.umbrella.worker.dto.StaffTimeDO;
import com.umbrella.worker.entity.WStaff;
import com.umbrella.worker.entity.WStaffExample;
import com.umbrella.worker.entity.WStaffTime;
import com.umbrella.worker.entity.WStaffTimeExample;
import com.umbrella.worker.entity.WSupplier;
import com.umbrella.worker.query.StaffQuery;
import com.umbrella.worker.query.StaffTimeQuery;
import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.result.ResultSupport;
import com.umbrella.worker.service.IStaffService;
import com.umbrella.worker.util.BeanUtilsExtends;
import com.umbrella.worker.util.StringUtil;
@Service("staffService")
public class StaffServiceImpl  extends BaseServiceImpl implements IStaffService {
	
	private static Logger logger = Logger.getLogger(StaffServiceImpl.class);
	@Autowired
	private WStaffMapper staffMapper;
	@Autowired
	private WCertificoreMapper certificoreMapper;
	@Autowired
	private WSupplierMapper supplierMapper;
	@Autowired
	private WStaffTimeMapper staffTimeMapper;

	@Override
	public ResultDO create(StaffDO staffDO) {
		
		WStaff staff = new WStaff();
		
		ResultSupport result = BeanUtilsExtends.copy(staff, staffDO);
		
		if(!result.isSuccess()) {
			return result;
		}
		
		int recordNum = -1;
		
		staff.setDatalevel(1);
		staff.setStatus(2);
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
		
		if(recordNum < 1) {
			result.setSuccess(false);
			return result;
		}
	
		result.setModel(ResultDO.FIRST_MODEL_KEY, staff.getId());
		
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
			recordNum = staffMapper.updateByPrimaryKeySelective(staff);
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
			return result;
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
			return result;
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
		
		if(StringUtil.isNotEmpty(staffQuery.getStaffName())) {
			c.andWStaffNameLike("%" + staffQuery.getStaffName() + "%");
		}
		
		if(StringUtil.isNotEmpty(staffQuery.getIdcard())) {
			c.andWSIdcardEqualTo(staffQuery.getIdcard());
		}
		
		if(StringUtil.isGreatOne(staffQuery.getSupplierId())) {
			c.andWSSupplierIdEqualTo(staffQuery.getSupplierId());
		}
		
		if(StringUtil.isGreatOne(staffQuery.getServiceType())) {
			c.andWSTypeEqualTo(staffQuery.getServiceType());
		}
		//1.未工作 2.工作中 3.休息
		if(StringUtil.isGreatOne(staffQuery.getStatus())) {
			c.andStatusEqualTo(staffQuery.getStatus());
		}
		
		
		if(StringUtil.isNotEmpty(staffQuery.getOrderByClause())) {	
			example.setOrderByClause(" " + staffQuery.getOrderByClause() + " " + staffQuery.getSort());
		} else {
			example.setOrderByClause(" CREATE_TIME DESC");
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
		
		List<StaffDO> staffList2 = new ArrayList<StaffDO>();
		
		if(staffList != null) {
			for(int i = 0; i < staffList.size(); i++) {
				StaffDO staffDO = staffList.get(i);
				WSupplier supplier = supplierMapper.selectByPrimaryKey(staffDO.getwSSupplierId());
				staffDO.setSupplierName(supplier.getwSName());
				staffList2.add(staffDO);
			}
		}
		
		result.setModel(ResultSupport.FIRST_MODEL_KEY, staffList2);
		
		return result;
	}
	
	@Override
	public ResultDO listStaffTime(StaffTimeQuery query) {
		
		ResultSupport result = new ResultSupport();
		
		WStaffTimeExample example = new WStaffTimeExample();
		WStaffTimeExample.Criteria c = example.createCriteria();
		
		c.andStatusEqualTo(query.getStatus());
		if(query.isPage()) {
			long count = 0;
			try {
				count = staffTimeMapper.countByExample(example);
			} catch (Exception e) {
				result.setSuccess(false);
		        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
		        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
		        e.printStackTrace();
		        logger.error("[obj:member][opt:get][msg:"+e.getMessage()+"]");
		        return result;
			}
			result.setModel(ResultSupport.SECOND_MODEL_KEY, count);
			int pageNO = query.getPageNO();
			if(pageNO > 0) {
				pageNO = pageNO -1;
			}
			String pageByClause = " limit " + (pageNO * query.getPageRows())
					+ "," + query.getPageRows();
			
			example.setPageByClause(pageByClause);
		}
		
		List<WStaffTime> list = null;
		
		try {
			list = staffTimeMapper.selectByExample(example);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:staff][opt:get][msg:"+e.getMessage()+"]");
	        return result;
		}
		
		List<StaffTimeDO> staffTimeList = getStaffTimeDOList(list);
		
		result.setModel(ResultSupport.FIRST_MODEL_KEY, staffTimeList);
		
		return result;
	}
	
}
