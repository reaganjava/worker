package com.umbrella.worker.query;

public class SmsCodeQuery extends BaseQuery {

	  private String wSmMobile;

	    
	  private String wSmCode;


	public String getwSmMobile() {
		return wSmMobile;
	}


	public void setwSmMobile(String wSmMobile) {
		this.wSmMobile = wSmMobile;
	}


	public String getwSmCode() {
		return wSmCode;
	}


	public void setwSmCode(String wSmCode) {
		this.wSmCode = wSmCode;
	}
	  
}
