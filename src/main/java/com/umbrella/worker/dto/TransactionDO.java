package com.umbrella.worker.dto;

import java.math.BigDecimal;

public class TransactionDO extends BaseDO {
    
    private Integer id;

   
    private Integer wTrOrderId;

    
    private Integer wTrMembersId;

   
    private Integer wTrSupplierId;

    
    private String wTrTradeNo;

    
    private String wTrOrderNo;

    
    private Integer wTrType;

   
    private BigDecimal wTrMoney;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getwTrOrderId() {
		return wTrOrderId;
	}


	public void setwTrOrderId(Integer wTrOrderId) {
		this.wTrOrderId = wTrOrderId;
	}


	public Integer getwTrMembersId() {
		return wTrMembersId;
	}


	public void setwTrMembersId(Integer wTrMembersId) {
		this.wTrMembersId = wTrMembersId;
	}


	public Integer getwTrSupplierId() {
		return wTrSupplierId;
	}


	public void setwTrSupplierId(Integer wTrSupplierId) {
		this.wTrSupplierId = wTrSupplierId;
	}


	public String getwTrTradeNo() {
		return wTrTradeNo;
	}


	public void setwTrTradeNo(String wTrTradeNo) {
		this.wTrTradeNo = wTrTradeNo;
	}


	public String getwTrOrderNo() {
		return wTrOrderNo;
	}


	public void setwTrOrderNo(String wTrOrderNo) {
		this.wTrOrderNo = wTrOrderNo;
	}


	public Integer getwTrType() {
		return wTrType;
	}


	public void setwTrType(Integer wTrType) {
		this.wTrType = wTrType;
	}


	public BigDecimal getwTrMoney() {
		return wTrMoney;
	}


	public void setwTrMoney(BigDecimal wTrMoney) {
		this.wTrMoney = wTrMoney;
	}

    
    
}