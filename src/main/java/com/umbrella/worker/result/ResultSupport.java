package com.umbrella.worker.result;

import java.util.HashMap;
import java.util.Map;

public class ResultSupport implements ResultDO {

	private static final long serialVersionUID = 4661096805690919752L;

	private boolean success = true;
	//如果成功success=true，以下内容为空
	private String errorCode;
	private String errorMsg;
	private String errorSubCode;
	private String errorSubMsg;

	private Map<String, Object> models = new HashMap<String, Object>(4);

	/**
	 * 创建一个result。
	 */
	public ResultSupport() {
	}

	/**
	 * 创建一个result。
	 * 
	 * @param success
	 *            是否成功
	 */
	public ResultSupport(boolean success) {
		this.success = success;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getModel(String key) {
		return getModels().get(key);
	}

	public void setModel(String key, Object model) {
		getModels().put(key, model);
	}

	public Map<String, Object> getModels() {
		return models;
	}


	public String getErrorCode() {
		// TODO Auto-generated method stub
		return errorCode;
	}

	
	public void setErrorCode(String code) {
		errorCode = code;
	}

	
	public void setErrorMsg(String msg) {
		errorMsg = msg;

	}

	
	public String getErrorMsg() {
		// TODO Auto-generated method stub
		return errorMsg;
	}

	
	public void setErrorSubCode(String code) {
		errorSubMsg = code;

	}

	
	public String getErrorSubCode() {
		// TODO Auto-generated method stub
		return errorSubCode;
	}


	public String getErrorSubMsg() {
		// TODO Auto-generated method stub
		return errorSubMsg;
	}

	public void setErrorSubMsg(String errorSubMsg) {
		this.errorSubMsg = errorSubMsg;
	}

	@Override
	public String toString() {
		return "ResultSupport [success=" + success + ", errorCode=" + errorCode
				+ ", errorMsg=" + errorMsg + ", errorSubCode=" + errorSubCode
				+ ", errorSubMsg=" + errorSubMsg + ", models=" + models + "]";
	}

}
