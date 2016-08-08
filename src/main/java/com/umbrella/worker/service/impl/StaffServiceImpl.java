package com.umbrella.worker.service.impl;

import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

import com.umbrella.worker.dao.WCertificoreMapper;
import com.umbrella.worker.dao.WStaffMapper;
import com.umbrella.worker.dto.CertificoreDO;
import com.umbrella.worker.dto.StaffDO;
import com.umbrella.worker.entity.WCertificore;
import com.umbrella.worker.entity.WCertificoreExample;
import com.umbrella.worker.entity.WStaff;
import com.umbrella.worker.entity.WStaffExample;
import com.umbrella.worker.query.StaffQuery;
import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.result.ResultSupport;
import com.umbrella.worker.service.IStaffService;
import com.umbrella.worker.util.BeanUtilsExtends;
import com.umbrella.worker.util.StringUtil;

public class StaffServiceImpl  extends BaseServiceImpl implements IStaffService {
	
	private static Logger logger = Logger.getLogger(StaffServiceImpl.class);
	
	private WStaffMapper staffMapper;
	
	private WCertificoreMapper certificoreMapper;

	@Override
	public ResultDO create(StaffDO staffDO) {
		
		WStaff staff = new WStaff();
		
		ResultSupport result = BeanUtilsExtends.copy(staff, staffDO);
		
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
		
		if(recordNum < 1) {
			result.setSuccess(false);
			return result;
		}
	
		for(CertificoreDO certificoreDO : staffDO.getCertificores()) {
			recordNum = -1;
			
			WCertificore certificore = new WCertificore();
			result = BeanUtilsExtends.copy(certificore, certificoreDO);
			
			if(!result.isSuccess()) {
				return result;
			}
			
			try {
				recordNum = certificoreMapper.insertSelective(certificore);
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
			return result;
		}
		
		for(CertificoreDO certificoreDO : staffDO.getCertificores()) {
			recordNum = -1;
			
			WCertificore certificore = new WCertificore();
			result = BeanUtilsExtends.copy(certificore, certificoreDO);
			
			if(!result.isSuccess()) {
				return result;
			}
			
			WCertificoreExample example = new WCertificoreExample();
			example.createCriteria().andWCeStaffIdEqualTo(staffDO.getId());
			try {
				recordNum = certificoreMapper.updateByExample(certificore, example);
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
		
		
		recordNum = -1;
		
		WCertificore certificore = new WCertificore();
		
		WCertificoreExample example = new WCertificoreExample();
		certificore.setDatalevel(-1);
		example.createCriteria().andWCeStaffIdEqualTo(staffId);
		try {
			recordNum = certificoreMapper.updateByExample(certificore, example);
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
		
		List<WCertificore> certificoreList = null; 
		
		WCertificoreExample cfex = new WCertificoreExample();
		cfex.createCriteria().andWCeStaffIdEqualTo(staffId);
		try {
			certificoreList = certificoreMapper.selectByExample(cfex);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:supplier][opt:get][msg:"+e.getMessage()+"]");
	        return result;
		}
		
		if(certificoreList.size() > 0) {
			staffDO.setCertificores(getCertificoreDOList(certificoreList));
		} else {
			result.setSuccess(false);
			 return result;
		}
		
		return result;
	}

	@Override
	public ResultDO list(StaffQuery staffQuery) {
		
		ResultSupport result = new ResultSupport();
		
		WStaffExample example = new WStaffExample();
		WStaffExample.Criteria c = example.createCriteria();
		
		if(StringUtil.isEmpty(staffQuery.getStaffName())) {
			c.andWStaffNameLike("%" + staffQuery.getStaffName() + "%");
		}
		
		if(StringUtil.isEmpty(staffQuery.getIdcard())) {
			c.andWSIdcardEqualTo(staffQuery.getIdcard());
		}
		
		if(StringUtil.isGreatOne(staffQuery.getSupplierId())) {
			c.andWSSupplierIdEqualTo(staffQuery.getSupplierId());
		}
		
		if(StringUtil.isGreatOne(staffQuery.getServiceType())) {
			c.andWSTypeEqualTo(staffQuery.getServiceType());
		}
		
		if(StringUtil.isGreatOne(staffQuery.getStatus())) {
			c.andStatusEqualTo(staffQuery.getStatus());
		}
		
		
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
	
	
}
