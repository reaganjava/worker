package com.umbrella.worker.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umbrella.worker.dao.WOrderTaskMapper;
import com.umbrella.worker.dao.WSupplierMapper;
import com.umbrella.worker.dao.WSupplierWorkerMapper;
import com.umbrella.worker.dao.WWorkerItemMapper;
import com.umbrella.worker.dao.WWorkerStaffMapper;
import com.umbrella.worker.dao.WWorkerTaskMapper;
import com.umbrella.worker.dto.SupplierDO;
import com.umbrella.worker.dto.WorkerItemDO;
import com.umbrella.worker.dto.WorkerStaffDO;
import com.umbrella.worker.dto.WorkerTaskDO;
import com.umbrella.worker.entity.WSupplier;
import com.umbrella.worker.entity.WSupplierWorker;
import com.umbrella.worker.entity.WSupplierWorkerExample;
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
	@Autowired
	private WSupplierWorkerMapper supplierWorkerMapper;
	@Autowired
	private WSupplierMapper supplierMapper;


	@Override
	public ResultDO create(WorkerTaskDO workerTaskDO) {
		
		WWorkerTask workerTask = new WWorkerTask();
		
		ResultSupport result = BeanUtilsExtends.copy(workerTask, workerTaskDO);
		
		if(!result.isSuccess()) {
			return result;
		}
		
		int recordNum = -1;
		
		workerTask.setDatalevel(1);
		workerTask.setStatus(2);
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
		
		if(workerTask.getId() == null) {
			result.setSuccess(false);
			try {
				throw new Exception("task id is null");
			} catch (Exception e) {
				result.setSuccess(false);
				result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
				result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
				logger.error("[obj:service][opt:create][msg:" + e.getMessage()
				+ "]");
				return result;
			}
		}
		
		for(WorkerItemDO workerItemDO : workerTaskDO.getWorkerItems()) {
			recordNum = -1;
			WWorkerItem workerItem = new WWorkerItem();
			result = BeanUtilsExtends.copy(workerItem, workerItemDO);
			workerItem.setDatalevel(1);
			workerItem.setStatus(1);
			workerItem.setCreateTime(Calendar.getInstance().getTime());
			workerItem.setModifiTime(Calendar.getInstance().getTime());
			workerItem.setCreateAuthor(workerTask.getCreateAuthor());
			workerItem.setModifiAuthor(workerTask.getCreateAuthor());
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
			workerStaff.setCreateAuthor(workerTask.getCreateAuthor());
			workerStaff.setModifiAuthor(workerTask.getCreateAuthor());
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
		
		
		for(SupplierDO supplier : workerTaskDO.getSuppliers()) {
			recordNum = -1;
			WSupplierWorker supplierWorker = new WSupplierWorker();
			supplierWorker.setwSupplierId(supplier.getId());
			supplierWorker.setwWorkerId(workerTask.getId());
			try {
				recordNum = supplierWorkerMapper.insert(supplierWorker);
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
			recordNum = workerTaskMapper.updateByPrimaryKeySelective(workerTask);
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
				if(StringUtil.isGreatOne(workerItem.getId())) {
					workerItem.setwWiTaskId(workerTask.getId());
					recordNum = workerItemMapper.insertSelective(workerItem);
				} else {
					recordNum = workerItemMapper.updateByPrimaryKeySelective(workerItem);
				}
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
				if(StringUtil.isGreatOne(workerStaff.getId())) {
					workerStaff.setwWsTaskId(workerTask.getId());
					recordNum = workerStaffMapper.insertSelective(workerStaff);
				} else {
					recordNum = workerStaffMapper.updateByPrimaryKeySelective(workerStaff);
				}
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
		
		if(workerTaskDO.getSuppliers().size() > 0) {
			WSupplierWorkerExample wswex = new WSupplierWorkerExample();
			wswex.createCriteria().andWWorkerIdEqualTo(workerTaskDO.getId());
			recordNum = -1;
			try {
				recordNum = supplierWorkerMapper.deleteByExample(wswex);
			} catch (Exception e) {
				result.setSuccess(false);
		        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
		        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
		        logger.error("[obj:schedule][opt:remove][msg:"+e.getMessage()+"]");
			}
			
			if(recordNum < 0) {
				result.setSuccess(false);
				return result;
			}
		}
		
		for(SupplierDO supplier : workerTaskDO.getSuppliers()) {
			System.out.println(supplier.getId());
			recordNum = -1;
			WSupplierWorker supplierWorker = new WSupplierWorker();
			supplierWorker.setwSupplierId(supplier.getId());
			supplierWorker.setwWorkerId(workerTask.getId());
			try {
				recordNum = supplierWorkerMapper.insert(supplierWorker);
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
		
		WSupplierWorkerExample wswex = new WSupplierWorkerExample();
		wswex.createCriteria().andWWorkerIdEqualTo(workerTaskId);
		recordNum = -1;
		try {
			recordNum = supplierWorkerMapper.deleteByExample(wswex);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:schedule][opt:remove][msg:"+e.getMessage()+"]");
		}
		
		if(recordNum < 0) {
			result.setSuccess(false);
			return result;
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
		
		List<WSupplier> supplierList = new ArrayList<WSupplier>();
		try {
			supplierList = supplierMapper.selectSupplierByWorkerId(workerTaskId);		
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:schedule][opt:remove][msg:"+e.getMessage()+"]");
		}
		
		if(supplierList.size() > 0) {
			workerTaskDO.setSuppliers(workerTaskDO.getSuppliers());
		} else {
			result.setSuccess(false);
			return result;
		}
		result.setModel(ResultSupport.FIRST_MODEL_KEY, workerTaskDO);
		
		return result;
	}
	
	
	


	@Override
	public ResultDO list(WorkerTaskQuery workerTaskQuery) {
		
		ResultSupport result = new ResultSupport();
		
		WWorkerTaskExample example = new WWorkerTaskExample();
		WWorkerTaskExample.Criteria c = example.createCriteria();
		
		if(StringUtil.isNotEmpty(workerTaskQuery.getName())) {
			c.andWWNameLike("%" + workerTaskQuery.getName() + "%");
		}
		
		if(StringUtil.isNotEmpty(workerTaskQuery.getOrderByClause())) {	
			example.setOrderByClause(" " + workerTaskQuery.getOrderByClause() + " " + workerTaskQuery.getSort());
		} else {
			example.setOrderByClause(" CREATE_TIME DESC");
		}
		
		c.andDatalevelEqualTo(1);
		
		if(workerTaskQuery.isPage()) {
			long count = 0;
			try {
				count = workerTaskMapper.countByExample(example);
			} catch (Exception e) {
				result.setSuccess(false);
		        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
		        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
		        e.printStackTrace();
		        logger.error("[obj:member][opt:get][msg:"+e.getMessage()+"]");
		        return result;
			}
			result.setModel(ResultSupport.SECOND_MODEL_KEY, count);
			int pageNO = workerTaskQuery.getPageNO();
			if(pageNO > 0) {
				pageNO = pageNO -1;
			}
			String pageByClause = " limit " + (pageNO * workerTaskQuery.getPageRows())
					+ "," + workerTaskQuery.getPageRows();
			example.setPageByClause(pageByClause);
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
		
		
		result.setModel(ResultSupport.FIRST_MODEL_KEY, workerTaskList);
		
		return result;
	}
	
	

}
