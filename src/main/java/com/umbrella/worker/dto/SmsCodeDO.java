package com.umbrella.worker.dto;

import java.util.Date;

public class SmsCodeDO extends BaseDO {

	private Integer id;

    
    private String wSmMobile;
    
    
    private String wSmTempKey;

    
    private String wSmCode;

    
    private Date wSmValidTime;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getwSmMobile() {
		return wSmMobile;
	}


	public void setwSmMobile(String wSmMobile) {
		this.wSmMobile = wSmMobile;
	}


	public String getwSmTempKey() {
		return wSmTempKey;
	}


	public void setwSmTempKey(String wSmTempKey) {
		this.wSmTempKey = wSmTempKey;
	}


	public String getwSmCode() {
		return wSmCode;
	}


	public void setwSmCode(String wSmCode) {
		this.wSmCode = wSmCode;
	}


	public Date getwSmValidTime() {
		return wSmValidTime;
	}


	public void setwSmValidTime(Date wSmValidTime) {
		this.wSmValidTime = wSmValidTime;
	}

}
