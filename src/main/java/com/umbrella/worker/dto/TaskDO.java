package com.umbrella.worker.dto;

import java.math.BigDecimal;

public class TaskDO {

	private Integer serviceType;

	private String serviceName;

	private Integer hours;

	private Integer staffCount;

	private Integer lockType;

	private Integer isLock;

	private Integer carType;

	private Integer pipType;

	private Integer toiletType;
	
	private String message;

	private BigDecimal price;

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public Integer getServiceType() {
		return serviceType;
	}

	public void setServiceType(Integer serviceType) {
		this.serviceType = serviceType;
	}

	public Integer getLockType() {
		return lockType;
	}

	public void setLockType(Integer lockType) {
		this.lockType = lockType;
	}

	public Integer getIsLock() {
		return isLock;
	}

	public void setIsLock(Integer isLock) {
		this.isLock = isLock;
	}

	public Integer getCarType() {
		return carType;
	}

	public void setCarType(Integer carType) {
		this.carType = carType;
	}

	public Integer getPipType() {
		return pipType;
	}

	public void setPipType(Integer pipType) {
		this.pipType = pipType;
	}

	public Integer getToiletType() {
		return toiletType;
	}

	public void setToiletType(Integer toiletType) {
		this.toiletType = toiletType;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}

	public Integer getStaffCount() {
		return staffCount;
	}

	public void setStaffCount(Integer staffCount) {
		this.staffCount = staffCount;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
