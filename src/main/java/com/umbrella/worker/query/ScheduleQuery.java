package com.umbrella.worker.query;

import java.util.Date;

public class ScheduleQuery extends BaseQuery {
    
    private Integer staffId;

     
    private Date date;

     
    private Date beignTime;

    
    private Date endTime;

    
    private Integer serviceType;

     
    private Integer isComplete;

     
    private Integer isTimeout;


	public Integer getStaffId() {
		return staffId;
	}


	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Date getBeignTime() {
		return beignTime;
	}


	public void setBeignTime(Date beignTime) {
		this.beignTime = beignTime;
	}


	public Date getEndTime() {
		return endTime;
	}


	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}


	public Integer getServiceType() {
		return serviceType;
	}


	public void setServiceType(Integer serviceType) {
		this.serviceType = serviceType;
	}


	public Integer getIsComplete() {
		return isComplete;
	}


	public void setIsComplete(Integer isComplete) {
		this.isComplete = isComplete;
	}


	public Integer getIsTimeout() {
		return isTimeout;
	}


	public void setIsTimeout(Integer isTimeout) {
		this.isTimeout = isTimeout;
	}


}