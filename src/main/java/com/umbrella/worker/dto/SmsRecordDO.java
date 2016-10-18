package com.umbrella.worker.dto;

import java.math.BigDecimal;

public class SmsRecordDO extends BaseDO{

	private Integer id;

    private Integer sSupplierId;

    private BigDecimal sFee;

    private String sMobile;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getsSupplierId() {
		return sSupplierId;
	}

	public void setsSupplierId(Integer sSupplierId) {
		this.sSupplierId = sSupplierId;
	}

	public BigDecimal getsFee() {
		return sFee;
	}

	public void setsFee(BigDecimal sFee) {
		this.sFee = sFee;
	}

	public String getsMobile() {
		return sMobile;
	}

	public void setsMobile(String sMobile) {
		this.sMobile = sMobile;
	}

}
