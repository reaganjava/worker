package com.umbrella.worker.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

import com.umbrella.worker.dao.WCommentMapper;
import com.umbrella.worker.dao.WContactMapper;
import com.umbrella.worker.dto.CommentDO;
import com.umbrella.worker.dto.ContactDO;
import com.umbrella.worker.entity.WComment;
import com.umbrella.worker.entity.WCommentExample;
import com.umbrella.worker.entity.WContact;
import com.umbrella.worker.entity.WContactExample;
import com.umbrella.worker.query.CommentQuery;
import com.umbrella.worker.query.ContactQuery;
import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.result.ResultSupport;
import com.umbrella.worker.service.ICommentService;
import com.umbrella.worker.service.IContactService;
import com.umbrella.worker.util.BeanUtilsExtends;
import com.umbrella.worker.util.StringUtil;

public class CommentServiceImpl implements ICommentService {
	
	private static Logger logger = Logger.getLogger(CommentServiceImpl.class);
	
	private WCommentMapper commentMapper;

	@Override
	public ResultDO create(CommentDO commentDO) {
		
		WComment comment = new WComment();
		
		ResultSupport result = BeanUtilsExtends.copy(commentDO, comment);
		
		if(!result.isSuccess()) {
			return result;
		}
		
		int recordNum = -1;
		
		comment.setDatalevel(1);
		comment.setStatus(1);
		comment.setCreateTime(Calendar.getInstance().getTime());
		comment.setModifiTime(Calendar.getInstance().getTime());
		
		try {
			recordNum = commentMapper.insertSelective(comment);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
			logger.error("[obj:contact][opt:create][msg:" + e.getMessage()
			+ "]");
			return result;
		}
		
		if(recordNum == 1) {
			result.setModel(ResultDO.FIRST_MODEL_KEY, comment.getId());
		} else {
			result.setSuccess(false);
		}
		return result;
	}

	@Override
	public ResultDO modifi(CommentDO commentDO) {
		
		WComment comment = new WComment();

		ResultSupport result = BeanUtilsExtends.copy(commentDO, comment);
		// 拷贝失败
		if (!result.isSuccess()) {
			return result;
		}
		comment.setModifiTime(Calendar.getInstance().getTime());
		int recordNum = -1;
		try {
			recordNum = commentMapper.updateByPrimaryKey(comment);
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
	public ResultDO remove(int commentId) {
		
		ResultSupport result = new ResultSupport();
		
		WComment comment = new WComment();
		
		if(StringUtil.isGreatOne(commentId)) {
			comment.setId(commentId);
		} else {
		    result.setSuccess(false);
		    return result;
		}
		comment.setDatalevel(-1);
		int recordNum = -1;
		try {
			recordNum = commentMapper.updateByPrimaryKeySelective(comment);
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
	public ResultDO get(int commentId) {
		
		ResultSupport result = new ResultSupport();
		
		WComment comment = null;
		if(!StringUtil.isGreatOne(commentId)) {
			 result.setSuccess(false);
			 return result;
		} 
		
		try {
			comment = commentMapper.selectByPrimaryKey(commentId);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:supplier][opt:get][msg:"+e.getMessage()+"]");
	        return result;
		}
		
		CommentDO commentDO = getCommentDO(comment);
		if(commentDO != null) {
			result.setModel(ResultSupport.FIRST_MODEL_KEY, commentDO);
		} else {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			return result;
		}
		
		return result;
	}

	@Override
	public ResultDO list(CommentQuery commentQuery) {
		
		ResultSupport result = new ResultSupport();
		
		WCommentExample example = new WCommentExample();
		WCommentExample.Criteria c = example.createCriteria();
		
		
		
		if(StringUtil.isNotEmpty(commentQuery.getOrderByClause())) {	
			example.setOrderByClause(" " + commentQuery.getOrderByClause() + " " + commentQuery.getSort());
		} else {
			example.setOrderByClause(" W_M_REGISTER_TIME DESC");
		}
		
		List<WComment> list = null;
		
		try {
			list = commentMapper.selectByExample(example);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:supplier][opt:get][msg:"+e.getMessage()+"]");
	        return result;
		}
		
		List<CommentDO> commentList = getCommentDOList(list);
		
		if(commentList.size() > 0) {
			result.setModel(ResultSupport.FIRST_MODEL_KEY, commentList);
		} else {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        return result;
		}
		return result;
	}
	
	private CommentDO getCommentDO(WComment obj) {
		if(obj == null) return null;
		CommentDO dst = new CommentDO();
		return BeanUtilsExtends.copyProperties(dst, obj) ? dst : null;
	}
	
	private List<CommentDO> getCommentDOList(List<WComment> list) {
		List<CommentDO> resultList = new ArrayList<CommentDO>();
		if(list != null && list.isEmpty()) {
			for(WComment comment : list) {
				CommentDO commentDO = this.getCommentDO(comment);
				if(commentDO != null) {
					resultList.add(commentDO);
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
