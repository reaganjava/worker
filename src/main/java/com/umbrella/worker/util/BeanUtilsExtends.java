package com.umbrella.worker.util;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.result.ResultSupport;



public class BeanUtilsExtends {
	static {
		//ConvertUtils.register(new DateConverter(), java.util.Date.class);
		ConvertUtils.register(new Converter() {
			public Object convert(Class type, Object value) {
				return value == null ? null : value;
			}
		}, java.util.Date.class);
		
		ConvertUtils.register(new Converter() {
			public Object convert(Class type, Object value) {
				return value == null ? null : value;
			}
		}, java.lang.Integer.class);

		ConvertUtils.register(new Converter() {
			public Object convert(Class type, Object value) {
				return value == null ? null : value;
			}
		}, java.lang.Long.class);
	}

	/*public static void copyProperties(Object dest, Object orig) {
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException ex) {
			ex.printStackTrace();
		} catch (InvocationTargetException ex) {
			ex.printStackTrace();
		}
	}*/
	
	/**
	 * 拷贝数据到DTO对象
	 * 
	 * @param dest 目标DTO
	 * @param orig 源DAO
	 * @return 是否拷贝成功 true成功false失败
	 */
	public static boolean copyProperties(Object dest, Object orig) {
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}
	
	/* 本来就是个简单的调用还包装一个方法来这就是脱了裤子放屁
	 * 拷贝DTO到实体对象
	 */
	public static ResultSupport copy(Object dest, Object orig) {
		ResultSupport result = new ResultSupport();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (Exception e) {
			result.setSuccess(false);
		    result.setErrorCode(ResultDO.PROPERTY_VALUE_SET_ERROR);
		    result.setErrorMsg(ResultDO.PROPERTY_VALUE_SET_ERROR_MSG);
		}
		return result;
	}

}
