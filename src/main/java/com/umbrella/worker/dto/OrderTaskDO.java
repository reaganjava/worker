package com.umbrella.worker.dto;

import java.math.BigDecimal;

public class OrderTaskDO extends BaseDO {

	private Integer id;

	private Integer workerTaskId;
	
	private Integer workerItemId;
	
	private Integer workerStaffId;
	
	private Integer wOOrderId;

	private String wOTaskName;

	private BigDecimal wOTaskPrice;

	private BigDecimal wOTaskPriceCount;

	private String wOTaskItem;

	private Integer wOTaskStaffCount;

	private Integer wOTaskHours;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getWorkerTaskId() {
		return workerTaskId;
	}

	public void setWorkerTaskId(Integer workerTaskId) {
		this.workerTaskId = workerTaskId;
	}

	public Integer getWorkerItemId() {
		return workerItemId;
	}

	public void setWorkerItemId(Integer workerItemId) {
		this.workerItemId = workerItemId;
	}

	public Integer getWorkerStaffId() {
		return workerStaffId;
	}

	public void setWorkerStaffId(Integer workerStaffId) {
		this.workerStaffId = workerStaffId;
	}

	public Integer getwOOrderId() {
		return wOOrderId;
	}

	public void setwOOrderId(Integer wOOrderId) {
		this.wOOrderId = wOOrderId;
	}

	public String getwOTaskName() {
		return wOTaskName;
	}

	public void setwOTaskName(String wOTaskName) {
		this.wOTaskName = wOTaskName;
	}

	public BigDecimal getwOTaskPrice() {
		return wOTaskPrice;
	}

	public void setwOTaskPrice(BigDecimal wOTaskPrice) {
		this.wOTaskPrice = wOTaskPrice;
	}

	public BigDecimal getwOTaskPriceCount() {
		return wOTaskPriceCount;
	}

	public void setwOTaskPriceCount(BigDecimal wOTaskPriceCount) {
		this.wOTaskPriceCount = wOTaskPriceCount;
	}

	public String getwOTaskItem() {
		return wOTaskItem;
	}

	public void setwOTaskItem(String wOTaskItem) {
		this.wOTaskItem = wOTaskItem;
	}

	public Integer getwOTaskStaffCount() {
		return wOTaskStaffCount;
	}

	public void setwOTaskStaffCount(Integer wOTaskStaffCount) {
		this.wOTaskStaffCount = wOTaskStaffCount;
	}

	public Integer getwOTaskHours() {
		return wOTaskHours;
	}

	public void setwOTaskHours(Integer wOTaskHours) {
		this.wOTaskHours = wOTaskHours;
	}


}
