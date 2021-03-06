package com.umbrella.worker.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umbrella.worker.dao.WSupplierAccountMapper;
import com.umbrella.worker.dao.WSupplierMapper;
import com.umbrella.worker.dao.WSupplierPayrecordMapper;
import com.umbrella.worker.dto.SupplierAccountDO;
import com.umbrella.worker.dto.SupplierDO;
import com.umbrella.worker.dto.SupplierPayrecordDO;
import com.umbrella.worker.entity.WSupplier;
import com.umbrella.worker.entity.WSupplierAccount;
import com.umbrella.worker.entity.WSupplierAccountExample;
import com.umbrella.worker.entity.WSupplierExample;
import com.umbrella.worker.entity.WSupplierPayrecord;
import com.umbrella.worker.entity.WSupplierPayrecordExample;
import com.umbrella.worker.query.SupplierAccountQuery;
import com.umbrella.worker.query.SupplierPayrecordQuery;
import com.umbrella.worker.query.SupplierQuery;
import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.result.ResultSupport;
import com.umbrella.worker.service.ISuppliersService;
import com.umbrella.worker.util.BeanUtilsExtends;
import com.umbrella.worker.util.StringUtil;
@Service("suppliersService")
public class SuppliersServiceImpl  extends BaseServiceImpl implements ISuppliersService {
	
	private static Logger logger = Logger.getLogger(SuppliersServiceImpl.class);
	@Autowired
	private WSupplierMapper supplierMapper;
	@Autowired
	private WSupplierAccountMapper supplierAccountMapper;
	@Autowired
	private WSupplierPayrecordMapper supplierPayrecordMapper;
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
		supplier.setwSSector(0);
		supplier.setwSGrade(1);
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
		
		WSupplierAccount supplierAccount = new WSupplierAccount();
		supplierAccount.setId(supplier.getId());
		supplierAccount.setCreateAuthor(supplierDO.getCreateAuthor());
		supplierAccount.setCreateTime(Calendar.getInstance().getTime());
		supplierAccount.setModifiAuthor(supplierAccount.getCreateAuthor());
		supplierAccount.setModifiTime(supplierAccount.getCreateTime());
		supplierAccount.setStatus(1);
		supplierAccount.setDatalevel(1);
		
		try {
			recordNum = supplierAccountMapper.insertSelective(supplierAccount);
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
			recordNum = supplierMapper.updateByPrimaryKeySelective(supplier);
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
	
	public ResultDO getAccount(Integer id) {
		
		ResultSupport result = new ResultSupport();
		
		WSupplierAccount supplierAccount = null;
		if(!StringUtil.isGreatOne(id)) {
			 result.setSuccess(false);
			 return result;
		} 
		
		try {
			supplierAccount = supplierAccountMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:supplier][opt:get][msg:"+e.getMessage()+"]");
	        return result;
		}
		
		
		SupplierAccountDO supplierAccountDO = getSupplierAccountDO(supplierAccount);
		if(supplierAccountDO != null) {
			result.setModel(ResultSupport.FIRST_MODEL_KEY, supplierAccountDO);
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
		
		if(StringUtil.isNotEmpty(supplierQuery.getName())) {
			c.andWSNameEqualTo("%" + supplierQuery.getName() + "%");
		}
		
		if(StringUtil.isGreatOne(supplierQuery.getStatus())) {
			c.andStatusEqualTo(supplierQuery.getStatus());
		}
		
		c.andDatalevelEqualTo(1);
		
		if(StringUtil.isNotEmpty(supplierQuery.getOrderByClause())) {	
			example.setOrderByClause(" " + supplierQuery.getOrderByClause() + " " + supplierQuery.getSort());
		} else {
			example.setOrderByClause(" CREATE_TIME ASC");
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
			System.out.println(pageNO);
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

		result.setModel(ResultSupport.FIRST_MODEL_KEY, supplierList);
		
		return result;
	}
	
	@Override
	public ResultDO listPayrecord(SupplierPayrecordQuery query) {
		ResultSupport result = new ResultSupport();
	
		
		WSupplierPayrecordExample example = new WSupplierPayrecordExample();
		WSupplierPayrecordExample.Criteria c = example.createCriteria();
		if(StringUtil.isGreatOne(query.getSupplierId())) {
			c.andWPSupperIdEqualTo(query.getSupplierId());
		}
		c.andDatalevelEqualTo(1);
		
		if(StringUtil.isNotEmpty(query.getOrderByClause())) {	
			example.setOrderByClause(" " + query.getOrderByClause() + " " + query.getSort());
		} else {
			example.setOrderByClause(" CREATE_TIME ASC");
		}
		
		if(query.isPage()) {
			long count = 0;
			try {
				count = supplierPayrecordMapper.countByExample(example);
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
			System.out.println(pageNO);
			String pageByClause = " limit " + (pageNO * query.getPageRows())
					+ "," + query.getPageRows();
			
			example.setPageByClause(pageByClause);
		}
		
		List<WSupplierPayrecord> list = null;
		
		try {
			list = supplierPayrecordMapper.selectByExample(example);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:supplier][opt:get][msg:"+e.getMessage()+"]");
	        return result;
		}
		
		List<SupplierPayrecordDO> supplierList = getSupplierPayrecordDOList(list);

		List<SupplierPayrecordDO> list2 = new ArrayList<SupplierPayrecordDO>();
		if(supplierList != null) {
			for(SupplierPayrecordDO supplierPayrecordDO : supplierList) {
				try {
					WSupplier supplier = supplierMapper.selectByPrimaryKey(supplierPayrecordDO.getwPSupperId());
					supplierPayrecordDO.setSupplierName(supplier.getwSName());
					list2.add(supplierPayrecordDO);
				} catch (Exception e) {
					result.setSuccess(false);
			        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
			        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			        logger.error("[obj:supplier][opt:get][msg:"+e.getMessage()+"]");
			        return result;
				}
			}
		}
		result.setModel(ResultSupport.FIRST_MODEL_KEY, list2);
		
		return result;
	}
	
	@Override
	public ResultDO listAccount(SupplierAccountQuery query) {
		ResultSupport result = new ResultSupport();
	
		
		WSupplierAccountExample example = new WSupplierAccountExample();
		WSupplierAccountExample.Criteria c = example.createCriteria();
		
		c.andDatalevelEqualTo(1);
		
		if(StringUtil.isNotEmpty(query.getOrderByClause())) {	
			example.setOrderByClause(" " + query.getOrderByClause() + " " + query.getSort());
		} else {
			example.setOrderByClause(" CREATE_TIME ASC");
		}
		
		if(query.isPage()) {
			long count = 0;
			try {
				count = supplierAccountMapper.countByExample(example);
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
			System.out.println(pageNO);
			String pageByClause = " limit " + (pageNO * query.getPageRows())
					+ "," + query.getPageRows();
			
			example.setPageByClause(pageByClause);
		}
		
		List<WSupplierAccount> list = null;
		
		try {
			list = supplierAccountMapper.selectByExample(example);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:supplier][opt:get][msg:"+e.getMessage()+"]");
	        return result;
		}
		
		List<SupplierAccountDO> supplierList = getSupplierAccountDOList(list);

		List<SupplierAccountDO> list2 = new ArrayList<SupplierAccountDO>();
		if(supplierList != null) {
			for(SupplierAccountDO supplierAccountDO : supplierList) {
				try {
					WSupplier supplier = supplierMapper.selectByPrimaryKey(supplierAccountDO.getId());
					supplierAccountDO.setSupplierName(supplier.getwSName());
					list2.add(supplierAccountDO);
				} catch (Exception e) {
					result.setSuccess(false);
			        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
			        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			        logger.error("[obj:supplier][opt:get][msg:"+e.getMessage()+"]");
			        return result;
				}
			}
		}
		result.setModel(ResultSupport.FIRST_MODEL_KEY, list2);
		
		return result;
	}
	
	
}
