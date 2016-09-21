package com.umbrella.worker.dto;

import java.math.BigDecimal;

public class SupplierPayrecordDO extends BaseDO {

	private Integer id;

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
    
}
