package com.umbrella.worker.dto;

import java.math.BigDecimal;
import java.util.Date;

public class SupplierAccountDO extends BaseDO {
	
	private Integer id;

    private Integer wSupplierId;
    
    private String supplierName;

    private BigDecimal wABalance;

    private BigDecimal wALastWithdraw;

    private Date wALastWithdrawDate;

    private BigDecimal wALastSave;

    private Date wALastSaveDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getwSupplierId() {
		return wSupplierId;
	}

	public void setwSupplierId(Integer wSupplierId) {
		this.wSupplierId = wSupplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public BigDecimal getwABalance() {
		return wABalance;
	}

	public void setwABalance(BigDecimal wABalance) {
		this.wABalance = wABalance;
	}

	public BigDecimal getwALastWithdraw() {
		return wALastWithdraw;
	}

	public void setwALastWithdraw(BigDecimal wALastWithdraw) {
		this.wALastWithdraw = wALastWithdraw;
	}

	public Date getwALastWithdrawDate() {
		return wALastWithdrawDate;
	}

	public void setwALastWithdrawDate(Date wALastWithdrawDate) {
		this.wALastWithdrawDate = wALastWithdrawDate;
	}

	public BigDecimal getwALastSave() {
		return wALastSave;
	}

	public void setwALastSave(BigDecimal wALastSave) {
		this.wALastSave = wALastSave;
	}

	public Date getwALastSaveDate() {
		return wALastSaveDate;
	}

	public void setwALastSaveDate(Date wALastSaveDate) {
		this.wALastSaveDate = wALastSaveDate;
	}
    
    
}
