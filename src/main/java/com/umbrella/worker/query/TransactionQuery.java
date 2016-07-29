package com.umbrella.worker.query;


public class TransactionQuery extends BaseQuery {
    
    private String tradeNo;

    
    private String orderNo;

    
    private Integer type;


	public String getTradeNo() {
		return tradeNo;
	}


	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}


	public String getOrderNo() {
		return orderNo;
	}


	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}


	public Integer getType() {
		return type;
	}


	public void setType(Integer type) {
		this.type = type;
	}

  
}