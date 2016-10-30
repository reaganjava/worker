package com.umbrella.worker.dto;

import java.math.BigDecimal;

public class SupplierPayrecordDO extends BaseDO {

	private Integer id;
	
	private Integer wPSupperId;
	
	private String supplierName;

    private BigDecimal wPAmount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getwPAmount() {
		return wPAmount;
	}

	public void setwPAmount(BigDecimal wPAmount) {
		this.wPAmount = wPAmount;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public Integer getwPSupperId() {
		return wPSupperId;
	}

	public void setwPSupperId(Integer wPSupperId) {
		this.wPSupperId = wPSupperId;
	}
    
}
