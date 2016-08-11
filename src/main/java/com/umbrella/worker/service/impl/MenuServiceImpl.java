package com.umbrella.worker.service.impl;

import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umbrella.worker.dao.WMenuMapper;
import com.umbrella.worker.dto.MenuDO;
import com.umbrella.worker.entity.WMenu;
import com.umbrella.worker.entity.WMenuExample;
import com.umbrella.worker.query.MenuQuery;
import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.result.ResultSupport;
import com.umbrella.worker.service.IMenuService;
import com.umbrella.worker.util.BeanUtilsExtends;
import com.umbrella.worker.util.StringUtil;

@Service("menuService")
public class MenuServiceImpl  extends BaseServiceImpl implements IMenuService{
	
	private static Logger logger = Logger.getLogger(MenuServiceImpl.class);

	@Autowired
	private WMenuMapper menuMapper;
	
	@Override
	public ResultDO create(MenuDO menuDO) {
		
		WMenu menu = new WMenu();
		
		ResultSupport result = BeanUtilsExtends.copy(menu, menuDO);
		
		if(!result.isSuccess()) {
			return result;
		}
		
		int recordNum = -1;
		
		menuDO.setDatalevel(1);
		menuDO.setStatus(1);
		menuDO.setCreateTime(Calendar.getInstance().getTime());
		menuDO.setModifiTime(Calendar.getInstance().getTime());
		
		try {
			recordNum = menuMapper.insertSelective(menu);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
			logger.error("[obj:menuDO][opt:create][msg:" + e.getMessage()
			+ "]");
			return result;
		}
		
		if(recordNum == 1) {
			result.setModel(ResultDO.FIRST_MODEL_KEY, menu.getId());
		} else {
			result.setSuccess(false);
		}
		return result;
	}

	@Override
	public ResultDO modifi(MenuDO menuDO) {
		
		WMenu menu = new WMenu();

		ResultSupport result = BeanUtilsExtends.copy(menu, menuDO);
		// 拷贝失败
		if (!result.isSuccess()) {
			return result;
		}
		menu.setModifiTime(Calendar.getInstance().getTime());
		int recordNum = -1;
		try {
			recordNum = menuMapper.updateByPrimaryKey(menu);
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
	public ResultDO remove(int menuId) {
		
		ResultSupport result = new ResultSupport();
		
		WMenu menu = new WMenu();
		
		if(StringUtil.isGreatOne(menuId)) {
			menu.setId(menuId);
		} else {
		    result.setSuccess(false);
		    return result;
		}
		menu.setDatalevel(-1);
		int recordNum = -1;
		try {
			recordNum = menuMapper.updateByPrimaryKeySelective(menu);
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
	public ResultDO get(int menuId) {
		
		ResultSupport result = new ResultSupport();
		
		WMenu menu = null;
		if(!StringUtil.isGreatOne(menuId)) {
			 result.setSuccess(false);
			 return result;
		} 
		
		try {
			menu = menuMapper.selectByPrimaryKey(menuId);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:supplier][opt:get][msg:"+e.getMessage()+"]");
	        return result;
		}
		
		MenuDO menuDO = getMenuDO(menu);
		if(menuDO != null) {
			result.setModel(ResultSupport.FIRST_MODEL_KEY, menuDO);
		} else {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			return result;
		}
		
		return result;
	}

	@Override
	public ResultDO list(MenuQuery menuQuery) {
		
		ResultSupport result = new ResultSupport();
		
		WMenuExample example = new WMenuExample();
		WMenuExample.Criteria c = example.createCriteria();
		
		if(StringUtil.isGreatOne(menuQuery.getId())) {
			c.andIdEqualTo(menuQuery.getId());
		}
		
		if(StringUtil.isGreatOne(menuQuery.getRoleId())) {
			c.andWMRoleIdLessThanOrEqualTo(menuQuery.getRoleId());
		}
		
		if(StringUtil.isNotEmpty(menuQuery.getOrderByClause())) {	
			example.setOrderByClause(" " + menuQuery.getOrderByClause() + " " + menuQuery.getSort());
		} else {
			example.setOrderByClause(" CREATE_TIME DESC");
		}
		
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
		
		System.out.println(list.size());
		
		List<MenuDO> menuList = getMenuDOList(list);
		System.out.println(menuList);
	
		if(menuList != null) {
			result.setModel(ResultSupport.FIRST_MODEL_KEY, menuList);
		} else {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        return result;
		}
		return result;
	}
	
	
	
}
