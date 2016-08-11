package com.umbrella.worker.result;

public class JsonResultSupport implements JsonResultDO {

	private static final long serialVersionUID = 7673462871624797027L;

	private String info;
	
	private String status;

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

}
