package com.umbrella.worker.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

import com.umbrella.worker.dao.WContactMapper;
import com.umbrella.worker.dto.ContactDO;
import com.umbrella.worker.entity.WContact;
import com.umbrella.worker.entity.WContactExample;
import com.umbrella.worker.query.ContactQuery;
import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.result.ResultSupport;
import com.umbrella.worker.service.IContactService;
import com.umbrella.worker.util.BeanUtilsExtends;
import com.umbrella.worker.util.StringUtil;

public class ContactServiceImpl implements IContactService {
	
	private static Logger logger = Logger.getLogger(ContactServiceImpl.class);
	
	private WContactMapper contactMapper;

	@Override
	public ResultDO create(ContactDO contactDO) {
		
		WContact contact = new WContact();
		
		ResultSupport result = BeanUtilsExtends.copy(contactDO, contact);
		
		if(!result.isSuccess()) {
			return result;
		}
		
		int recordNum = -1;
		
		contact.setDatalevel(1);
		contact.setStatus(1);
		contact.setCreateTime(Calendar.getInstance().getTime());
		contact.setModifiTime(Calendar.getInstance().getTime());
		
		try {
			recordNum = contactMapper.insertSelective(contact);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
			logger.error("[obj:contact][opt:create][msg:" + e.getMessage()
			+ "]");
			return result;
		}
		
		if(recordNum == 1) {
			result.setModel(ResultDO.FIRST_MODEL_KEY, contact.getId());
		} else {
			result.setSuccess(false);
		}
		return result;
	}

	@Override
	public ResultDO modifi(ContactDO contactDO) {
		
		WContact contact = new WContact();

		ResultSupport result = BeanUtilsExtends.copy(contactDO, contact);
		// 拷贝失败
		if (!result.isSuccess()) {
			return result;
		}
		contact.setModifiTime(Calendar.getInstance().getTime());
		int recordNum = -1;
		try {
			recordNum = contactMapper.updateByPrimaryKey(contact);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
			result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			logger.error("[obj:contact][opt:modifi][msg:" + e.getMessage()
					+ "]");
			return result;
		}
		if (recordNum < 1) {
			result.setSuccess(false);
		}

		return result;
	}

	@Override
	public ResultDO remove(int contactId) {
		
		ResultSupport result = new ResultSupport();
		
		WContact contact = new WContact();
		
		if(StringUtil.isGreatOne(contactId)) {
			contact.setId(contactId);
		} else {
		    result.setSuccess(false);
		    return result;
		}
		contact.setDatalevel(-1);
		int recordNum = -1;
		try {
			recordNum = contactMapper.updateByPrimaryKeySelective(contact);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:contact][opt:remove][msg:"+e.getMessage()+"]");
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
		
		WContact contact = null;
		if(!StringUtil.isGreatOne(contactId)) {
			 result.setSuccess(false);
			 return result;
		} 
		
		try {
			contact = contactMapper.selectByPrimaryKey(contactId);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:supplier][opt:get][msg:"+e.getMessage()+"]");
	        return result;
		}
		
		ContactDO contactDO = getContactDO(contact);
		if(contactDO != null) {
			result.setModel(ResultSupport.FIRST_MODEL_KEY, contactDO);
		} else {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			return result;
		}
		
		return result;
	}

	@Override
	public ResultDO list(ContactQuery contactQuery) {
		
		ResultSupport result = new ResultSupport();
		
		WContactExample example = new WContactExample();
		WContactExample.Criteria c = example.createCriteria();
		
		
		
		if(StringUtil.isNotEmpty(contactQuery.getOrderByClause())) {	
			example.setOrderByClause(" " + contactQuery.getOrderByClause() + " " + contactQuery.getSort());
		} else {
			example.setOrderByClause(" W_M_REGISTER_TIME DESC");
		}
		
		List<WContact> list = null;
		
		try {
			list = contactMapper.selectByExample(example);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:supplier][opt:get][msg:"+e.getMessage()+"]");
	        return result;
		}
		
		List<ContactDO> contactList = getContactDOList(list);
		
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
	
	private ContactDO getContactDO(WContact obj) {
		if(obj == null) return null;
		ContactDO dst = new ContactDO();
		return BeanUtilsExtends.copyProperties(dst, obj) ? dst : null;
	}
	
	private List<ContactDO> getContactDOList(List<WContact> list) {
		List<ContactDO> resultList = new ArrayList<ContactDO>();
		if(list != null && list.isEmpty()) {
			for(WContact contact : list) {
				ContactDO contactDO = this.getContactDO(contact);
				if(contactDO != null) {
					resultList.add(contactDO);
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
