package com.umbrella.worker.result;

import java.io.Serializable;

public interface JsonResultDO extends Serializable{

	public final String JSON_SUCCESS = "y";
	
	public final String JSON_FAILED = "n";
	
	public String getInfo();

	public void setInfo(String info);

	public String getStatus();

	public void setStatus(String status);
	
}
