package com.umbrella.worker.service.impl;

import java.util.Calendar;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umbrella.worker.dao.WAttachmentMapper;
import com.umbrella.worker.dto.AttachmentDO;
import com.umbrella.worker.entity.WAttachment;
import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.result.ResultSupport;
import com.umbrella.worker.service.IAttachmentService;
import com.umbrella.worker.util.BeanUtilsExtends;
import com.umbrella.worker.util.StringUtil;
@Service("attachmentService")
public class AttachmentServiceImpl extends BaseServiceImpl implements IAttachmentService {
	
	private static Logger logger = Logger.getLogger(AttachmentServiceImpl.class);
	
	@Autowired
	private WAttachmentMapper attachmentMapper;

	@Override
	public ResultDO create(AttachmentDO attachmentDO) {
		
		WAttachment attachment = new WAttachment();
		
		ResultSupport result = BeanUtilsExtends.copy(attachment, attachmentDO);
		
		if(!result.isSuccess()) {
			return result;
		}
		
		int recordNum = -1;
		
		attachment.setDatalevel(1);
		attachment.setStatus(1);
		attachment.setCreateTime(Calendar.getInstance().getTime());
		attachment.setModifiTime(attachment.getCreateTime());
		
		try {
			recordNum = attachmentMapper.insertSelective(attachment);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
			logger.error("[obj:contact][opt:create][msg:" + e.getMessage()
			+ "]");
			return result;
		}
		
		if(recordNum == 1) {
			result.setModel(ResultDO.FIRST_MODEL_KEY, attachment.getId());
		} else {
			result.setSuccess(false);
		}
		return result;
	
	}

	@Override
	public ResultDO get(Integer id) {
		ResultSupport result = new ResultSupport();
		
		WAttachment attachment = null;
		if(!StringUtil.isGreatOne(id)) {
			 result.setSuccess(false);
			 return result;
		} 
		
		try {
			attachment = attachmentMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:supplier][opt:get][msg:"+e.getMessage()+"]");
	        return result;
		}
		
		AttachmentDO attachmentDO = getAttachmentDO(attachment);
		if(attachmentDO != null) {
			result.setModel(ResultSupport.FIRST_MODEL_KEY, attachmentDO);
		} else {
			result.setSuccess(false);
		}
		return result;
	}

	@Override
	public ResultDO remove(Integer id) {
		ResultSupport result = new ResultSupport();
		
		WAttachment attachment = new WAttachment();
		
		if(StringUtil.isGreatOne(id)) {
			attachment.setId(id);
		} else {
		    result.setSuccess(false);
		    return result;
		}
		attachment.setDatalevel(-1);
		int recordNum = -1;
		try {
			recordNum = attachmentMapper.updateByPrimaryKeySelective(attachment);
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

}
