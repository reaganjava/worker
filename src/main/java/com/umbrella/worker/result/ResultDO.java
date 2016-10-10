package com.umbrella.worker.result;

import java.io.Serializable;
import java.util.Map;

 
public interface ResultDO extends Serializable {
	
	String FIRST_MODEL_KEY="first_model";
	
	String SECOND_MODEL_KEY="second_model";
	
	String THIRD_MODEL_KEY="third_model";
	
	String PROPERTY_VALUE_SET_ERROR = "property setting fail";
	
	String PROPERTY_VALUE_SET_ERROR_MSG ="属性設定に失敗して";
	
	String SYSTEM_EXCEPTION_ERROR = "system exception error";
	
	String SYSTEM_EXCEPTION_ERROR_MSG = "システム異常エラー";
	
	String MEMBER_LOGIN_FAILED = "member login failed";
	
	String MEMBER_LOGIN_FAILED_MSG = "ログインに失敗して";
	
	/**
	 * 设置请求成功标志。
	 * 
	 * @param success
	 *            成功标志
	 */
	void setSuccess(boolean success);

	/**
	 * 请求是否成功。
	 * 
	 * @return 如果成功，则返回<code>true</code>
	 */
	boolean isSuccess();

	/**
	 * 获取返回码
	 * 
	 * @return 返回码
	 */
	String getErrorCode();
	/**
	 * 设置返回码
	 * 
	 * @param code
	 */
	void setErrorCode(String code);	
	
	
	String getErrorMsg();
	void setErrorMsg(String msg);
	
	
	/**
	 * 返回子的返回码
	 * 
	 * @return
	 */
	String getErrorSubCode();
	/**
	 * 设置子返回码
	 * 
	 * @param code
	 */
	void setErrorSubCode(String code);
	
	String getErrorSubMsg();
	void setErrorSubMsg(String msg);




	/**
	 * 取得model对象
	 * 
	 * @param key
	 *            字符串key
	 * @return model对象
	 */
	Object getModel(String key);

	/**
	 * 设置model对象。
	 * 
	 * @param key
	 *            字符串key
	 * @param model
	 *            model对象
	 */
	void setModel(String key, Object model);

	/**
	 * 取得所有model对象。
	 * 
	 * @return model对象表
	 */
	Map<String, Object> getModels();

}
