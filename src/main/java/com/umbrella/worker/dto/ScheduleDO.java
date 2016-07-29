package com.umbrella.worker.dto;

import java.util.Date;

public class ScheduleDO extends BaseDO {
    
    private Integer id;

    
    private StaffDO staffDO;

     
    private Date wSDate;

     
    private Date wSBeignTime;

    
    private Date wSEndTime;

     
    private Integer wSHour;

    
    private String wSDesc;

    
    private Integer wSServiceType;

     
    private Integer wSIsComplete;

     
    private Integer wSIsTimeout;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public StaffDO getStaffDO() {
		return staffDO;
	}


	public void setStaffDO(StaffDO staffDO) {
		this.staffDO = staffDO;
	}


	public Date getwSDate() {
		return wSDate;
	}


	public void setwSDate(Date wSDate) {
		this.wSDate = wSDate;
	}


	public Date getwSBeignTime() {
		return wSBeignTime;
	}


	public void setwSBeignTime(Date wSBeignTime) {
		this.wSBeignTime = wSBeignTime;
	}


	public Date getwSEndTime() {
		return wSEndTime;
	}


	public void setwSEndTime(Date wSEndTime) {
		this.wSEndTime = wSEndTime;
	}


	public Integer getwSHour() {
		return wSHour;
	}


	public void setwSHour(Integer wSHour) {
		this.wSHour = wSHour;
	}


	public String getwSDesc() {
		return wSDesc;
	}


	public void setwSDesc(String wSDesc) {
		this.wSDesc = wSDesc;
	}


	public Integer getwSServiceType() {
		return wSServiceType;
	}


	public void setwSServiceType(Integer wSServiceType) {
		this.wSServiceType = wSServiceType;
	}


	public Integer getwSIsComplete() {
		return wSIsComplete;
	}


	public void setwSIsComplete(Integer wSIsComplete) {
		this.wSIsComplete = wSIsComplete;
	}


	public Integer getwSIsTimeout() {
		return wSIsTimeout;
	}


	public void setwSIsTimeout(Integer wSIsTimeout) {
		this.wSIsTimeout = wSIsTimeout;
	}

     
    
}