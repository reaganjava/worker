package com.umbrella.worker.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

import com.umbrella.worker.dao.WSupplierMapper;
import com.umbrella.worker.dto.SupplierDO;
import com.umbrella.worker.entity.WSupplier;
import com.umbrella.worker.entity.WSupplierExample;
import com.umbrella.worker.query.SupplierQuery;
import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.result.ResultSupport;
import com.umbrella.worker.service.ISuppliersService;
import com.umbrella.worker.util.BeanUtilsExtends;
import com.umbrella.worker.util.StringUtil;

public class SuppliersServiceImpl implements ISuppliersService {
	
	private static Logger logger = Logger.getLogger(SuppliersServiceImpl.class);
	
	private WSupplierMapper supplierMapper;

	@Override
	public ResultDO create(SupplierDO supplierDO) {
		
		WSupplier supplier = new WSupplier();
		
		ResultSupport result = BeanUtilsExtends.copy(supplier, supplierDO);
		
		if(!result.isSuccess()) {
			return result;
		}
		
		int recordNum = -1;
		
		supplier.setDatalevel(1);
		supplier.setStatus(1);
		supplier.setCreateTime(Calendar.getInstance().getTime());
		supplier.setModifiTime(Calendar.getInstance().getTime());
		
		try {
			recordNum = supplierMapper.insertSelective(supplier);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
			logger.error("[obj:supplier][opt:create][msg:" + e.getMessage()
			+ "]");
			return result;
		}
		
		if(recordNum == 1) {
			result.setModel(ResultDO.FIRST_MODEL_KEY, supplier.getId());
		} else {
			result.setSuccess(false);
		}
		return result;
	}

	@Override
	public ResultDO modifi(SupplierDO supplierDO) {
		
		WSupplier supplier = new WSupplier();

		ResultSupport result = BeanUtilsExtends.copy(supplier, supplierDO);
		// 拷贝失败
		if (!result.isSuccess()) {
			return result;
		}
		supplier.setModifiTime(Calendar.getInstance().getTime());
		int recordNum = -1;
		try {
			recordNum = supplierMapper.updateByPrimaryKey(supplier);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
			result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			logger.error("[obj:supplier][opt:modifi][msg:" + e.getMessage()
					+ "]");
			return result;
		}
		if (recordNum < 1) {
			result.setSuccess(false);
		}

		return result;
	}

	@Override
	public ResultDO remove(int supplierId) {
		
		ResultSupport result = new ResultSupport();
		
		WSupplier supplier = new WSupplier();
		
		if(StringUtil.isGreatOne(supplierId)) {
			supplier.setId(supplierId);
		} else {
		    result.setSuccess(false);
		    return result;
		}
		supplier.setDatalevel(-1);
		int recordNum = -1;
		try {
			recordNum = supplierMapper.updateByPrimaryKeySelective(supplier);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:supplier][opt:remove][msg:"+e.getMessage()+"]");
	        return result;
		}
		if (recordNum != 1) {
			result.setSuccess(false);
		}
		return result;
	}

	@Override
	public ResultDO get(int supplierId) {
		
		ResultSupport result = new ResultSupport();
		
		WSupplier supplier = null;
		if(!StringUtil.isGreatOne(supplierId)) {
			 result.setSuccess(false);
			 return result;
		} 
		
		try {
			supplier = supplierMapper.selectByPrimaryKey(supplierId);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:supplier][opt:get][msg:"+e.getMessage()+"]");
	        return result;
		}
		
		SupplierDO supplierDO = getSupplierDO(supplier);
		if(supplierDO != null) {
			result.setModel(ResultSupport.FIRST_MODEL_KEY, supplierDO);
		} else {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			return result;
		}
		
		return result;
	}

	@Override
	public ResultDO list(SupplierQuery supplierQuery) {
		
		ResultSupport result = new ResultSupport();
		
		WSupplierExample example = new WSupplierExample();
		WSupplierExample.Criteria c = example.createCriteria();
		
		if(StringUtil.isEmpty(supplierQuery.getName())) {
			c.andWSNameEqualTo("%" + supplierQuery.getName() + "%");
		}
		
		if(StringUtil.isNotEmpty(supplierQuery.getOrderByClause())) {	
			example.setOrderByClause(" " + supplierQuery.getOrderByClause() + " " + supplierQuery.getSort());
		} else {
			example.setOrderByClause(" W_M_REGISTER_TIME DESC");
		}
		
		if(supplierQuery.isPage()) {
			long count = 0;
			try {
				count = supplierMapper.countByExample(example);
			} catch (Exception e) {
				result.setSuccess(false);
		        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
		        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
		        e.printStackTrace();
		        logger.error("[obj:member][opt:get][msg:"+e.getMessage()+"]");
		        return result;
			}
			result.setModel(ResultSupport.SECOND_MODEL_KEY, count);
			int pageNO = supplierQuery.getPageNO();
			if(pageNO > 0) {
				pageNO = pageNO -1;
			}
			String pageByClause = " limit " + (pageNO * supplierQuery.getPageRows())
					+ "," + supplierQuery.getPageRows();
			
			example.setPageByClause(pageByClause);
		}
		
		List<WSupplier> list = null;
		
		try {
			list = supplierMapper.selectByExample(example);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:supplier][opt:get][msg:"+e.getMessage()+"]");
	        return result;
		}
		
		List<SupplierDO> supplierList = getSupplierDOList(list);
		
		if(supplierList.size() > 0) {
			result.setModel(ResultSupport.FIRST_MODEL_KEY, supplierList);
		} else {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        return result;
		}
		return result;
	}
	
	private SupplierDO getSupplierDO(WSupplier obj) {
		if(obj == null) return null;
		SupplierDO dst = new SupplierDO();
		return BeanUtilsExtends.copyProperties(dst, obj) ? dst : null;
	}
	
	private List<SupplierDO> getSupplierDOList(List<WSupplier> list) {
		List<SupplierDO> resultList = new ArrayList<SupplierDO>();
		if(list != null && list.isEmpty()) {
			for(WSupplier supplier : list) {
				SupplierDO supplierDO = this.getSupplierDO(supplier);
				if(supplierDO != null) {
					resultList.add(supplierDO);
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
