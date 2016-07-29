package com.umbrella.worker.query;


public class OrderQuery extends BaseQuery {

    
    private Integer memberId;

   
    private Integer supplierId;
    
    
    private String tradeNo;

    
    private String orderNo;

   
    private Integer isEnd;

    
    private Integer isConfim;

   
    private Integer isPay;


	public Integer getMemberId() {
		return memberId;
	}


	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}


	public Integer getSupplierId() {
		return supplierId;
	}


	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}


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


	public Integer getIsEnd() {
		return isEnd;
	}


	public void setIsEnd(Integer isEnd) {
		this.isEnd = isEnd;
	}


	public Integer getIsConfim() {
		return isConfim;
	}


	public void setIsConfim(Integer isConfim) {
		this.isConfim = isConfim;
	}


	public Integer getIsPay() {
		return isPay;
	}


	public void setIsPay(Integer isPay) {
		this.isPay = isPay;
	}

}