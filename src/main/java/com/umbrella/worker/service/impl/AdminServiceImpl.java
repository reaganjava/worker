package com.umbrella.worker.service.impl;

import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umbrella.worker.dao.WAdminMapper;
import com.umbrella.worker.dao.WMenuMapper;
import com.umbrella.worker.dto.AdminDO;
import com.umbrella.worker.dto.MenuDO;
import com.umbrella.worker.entity.WAdmin;
import com.umbrella.worker.entity.WAdminExample;
import com.umbrella.worker.entity.WMenu;
import com.umbrella.worker.entity.WMenuExample;
import com.umbrella.worker.query.AdminQuery;
import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.result.ResultSupport;
import com.umbrella.worker.service.IAdminService;
import com.umbrella.worker.util.BeanUtilsExtends;
import com.umbrella.worker.util.StringUtil;
@Service("adminService")
public class AdminServiceImpl extends BaseServiceImpl implements IAdminService {
	
	private static Logger logger = Logger.getLogger(AdminServiceImpl.class);
	@Autowired
	private WAdminMapper adminMapper;
	@Autowired
	private WMenuMapper menuMapper;

	@Override
	public ResultDO create(AdminDO adminDO) {
		
		WAdmin admin = new WAdmin();
		
		ResultSupport result = BeanUtilsExtends.copy(admin, adminDO);
		
		if(!result.isSuccess()) {
			return result;
		}
		
		int recordNum = -1;
		
		admin.setDatalevel(1);
		admin.setStatus(1);
		admin.setCreateTime(Calendar.getInstance().getTime());
		admin.setModifiTime(Calendar.getInstance().getTime());
		
		try {
			recordNum = adminMapper.insertSelective(admin);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
			logger.error("[obj:contact][opt:create][msg:" + e.getMessage()
			+ "]");
			return result;
		}
		
		if(recordNum == 1) {
			result.setModel(ResultDO.FIRST_MODEL_KEY, admin.getId());
		} else {
			result.setSuccess(false);
		}
		return result;
	}
	
	@Override
	public ResultDO validate(AdminDO adminDO) {
		
		ResultSupport result = new ResultSupport();
		
		WAdminExample example = new WAdminExample();
		
		example.createCriteria()
			.andWAUsernameEqualTo(adminDO.getwAUsername())
			.andWAPasswordEqualTo(adminDO.getwAPassword())
			.andDatalevelNotEqualTo(-1);
		List<WAdmin> list = null;
		try {
			list = adminMapper.selectByExample(example);
		} catch (Exception e) {
            result.setSuccess(false);
            result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
            result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
            logger.error("[obj:member][opt:login][msg:"+e.getMessage()+"]");
            return result;
		}
		
		WAdmin admin = null;
		if(list.size() == 1) {
			admin = list.get(0);
		} else {
			result.setSuccess(false);
			result.setErrorCode(ResultDO.MEMBER_LOGIN_FAILED);
            result.setErrorMsg(ResultDO.MEMBER_LOGIN_FAILED_MSG);
			return result;
		}
	
		WMenuExample wmex = new WMenuExample();
		WMenuExample.Criteria c = wmex.createCriteria();
		
		c.andWMRoleIdEqualTo(admin.getwARoleId());
		List<WMenu> menuList = null;
		try {
			menuList = menuMapper.selectByExample(wmex);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:supplier][opt:get][msg:"+e.getMessage()+"]");
	        return result;
		}
		
		List<MenuDO> menuDOList = null;
		
		if(list.size() > 0) {
			menuDOList = getMenuDOList(menuList);
		} else {
			result.setSuccess(false);
			return result;
		}

		adminDO = getAdminDO(admin);
		if(adminDO != null) {
			adminDO.setMenus(menuDOList);
			result.setModel(ResultSupport.FIRST_MODEL_KEY, adminDO);
		} else {
			result.setSuccess(false);
			result.setErrorCode(ResultDO.MEMBER_LOGIN_FAILED);
            result.setErrorMsg(ResultDO.MEMBER_LOGIN_FAILED_MSG);
			return result;
		}
		
		admin.setwALastLogTime(Calendar.getInstance().getTime());
		
		try {
			adminMapper.updateByPrimaryKey(admin);
		} catch (Exception e) {
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:supplier][opt:get][msg:"+e.getMessage()+"]");
		}
		
		return result;
	}

	@Override
	public ResultDO modifi(AdminDO adminDO) {
		
		WAdmin admin = new WAdmin();

		ResultSupport result = BeanUtilsExtends.copy(admin, adminDO);
		// 拷贝失败
		if (!result.isSuccess()) {
			return result;
		}
		admin.setModifiTime(Calendar.getInstance().getTime());
		int recordNum = -1;
		try {
			recordNum = adminMapper.updateByPrimaryKey(admin);
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
	public ResultDO remove(int adminId) {
		
		ResultSupport result = new ResultSupport();
		
		WAdmin admin = new WAdmin();
		
		if(StringUtil.isGreatOne(adminId)) {
			admin.setId(adminId);
		} else {
		    result.setSuccess(false);
		    return result;
		}
		admin.setDatalevel(-1);
		int recordNum = -1;
		try {
			recordNum = adminMapper.updateByPrimaryKeySelective(admin);
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
	public ResultDO get(int adminId) {
		
		ResultSupport result = new ResultSupport();
		
		WAdmin admin = null;
		if(!StringUtil.isGreatOne(adminId)) {
			 result.setSuccess(false);
			 return result;
		} 
		
		try {
			admin = adminMapper.selectByPrimaryKey(adminId);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:supplier][opt:get][msg:"+e.getMessage()+"]");
	        return result;
		}
		
		WMenuExample example = new WMenuExample();
		WMenuExample.Criteria c = example.createCriteria();
		
		c.andWMRoleIdEqualTo(admin.getwARoleId());
		List<WMenu> list = null;
		try {
			list = menuMapper.selectByExample(example);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:supplier][opt:get][msg:"+e.getMessage()+"]");
	        return result;
		}
		
		List<MenuDO> menuDOList = null;
		if(list.size() > 0) {
			menuDOList = getMenuDOList(list);
		} else {
			result.setSuccess(false);
			return result;
		}
		
		AdminDO adminDO = getAdminDO(admin);
		if(adminDO != null) {
			adminDO.setMenus(menuDOList);
			result.setModel(ResultSupport.FIRST_MODEL_KEY, adminDO);
		} else {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			return result;
		}
		
		return result;
	}

	@Override
	public ResultDO list(AdminQuery adminQuery) {
		
		ResultSupport result = new ResultSupport();
		
		WAdminExample example = new WAdminExample();
		WAdminExample.Criteria c = example.createCriteria();
		
		if(StringUtil.isNotEmpty(adminQuery.getUsername())) {
			c.andWAUsernameEqualTo(adminQuery.getUsername());
		}
		
		if(StringUtil.isNotEmpty(adminQuery.getRealName())) {
			c.andWAUsernameEqualTo(adminQuery.getRealName());
		}
	
		if(StringUtil.isNotEmpty(adminQuery.getOrderByClause())) {	
			example.setOrderByClause(" " + adminQuery.getOrderByClause() + " " + adminQuery.getSort());
		} else {
			example.setOrderByClause(" CREATE_TIME DESC");
		}
		
		if(adminQuery.isPage()) {
			long count = 0;
			try {
				count = adminMapper.countByExample(example);
			} catch (Exception e) {
				result.setSuccess(false);
		        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
		        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
		        e.printStackTrace();
		        logger.error("[obj:member][opt:get][msg:"+e.getMessage()+"]");
		        return result;
			}
			result.setModel(ResultSupport.SECOND_MODEL_KEY, count);
			int pageNO = adminQuery.getPageNO();
			if(pageNO > 0) {
				pageNO = pageNO -1;
			}
			String pageByClause = " limit " + (pageNO * adminQuery.getPageRows())
					+ "," + adminQuery.getPageRows();
			example.setPageByClause(pageByClause);
		}
		
		List<WAdmin> list = null;
		
		try {
			list = adminMapper.selectByExample(example);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:supplier][opt:get][msg:"+e.getMessage()+"]");
	        return result;
		}
		
		List<AdminDO> adminList = getAdminDOList(list);
		
		if(adminList.size() > 0) {
			result.setModel(ResultSupport.FIRST_MODEL_KEY, adminList);
		} else {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        return result;
		}
		return result;
	}
	
	

}
