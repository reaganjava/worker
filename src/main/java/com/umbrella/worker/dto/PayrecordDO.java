package com.umbrella.worker.dto;

import java.math.BigDecimal;

public class PayrecordDO extends BaseDO {
   
    private Integer id;

    
    private String wPrTradeNo;

   
    private String wPrOrderNo;

    
    private String wPrCouponNo;

   
    private BigDecimal wPrFee;

   
    private Integer wPrIsCoupon;

    
    private String wPrPayChannel;

   
    private Integer wPrTimestamp;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getwPrTradeNo() {
		return wPrTradeNo;
	}


	public void setwPrTradeNo(String wPrTradeNo) {
		this.wPrTradeNo = wPrTradeNo;
	}


	public String getwPrOrderNo() {
		return wPrOrderNo;
	}


	public void setwPrOrderNo(String wPrOrderNo) {
		this.wPrOrderNo = wPrOrderNo;
	}


	public String getwPrCouponNo() {
		return wPrCouponNo;
	}


	public void setwPrCouponNo(String wPrCouponNo) {
		this.wPrCouponNo = wPrCouponNo;
	}


	public BigDecimal getwPrFee() {
		return wPrFee;
	}


	public void setwPrFee(BigDecimal wPrFee) {
		this.wPrFee = wPrFee;
	}


	public Integer getwPrIsCoupon() {
		return wPrIsCoupon;
	}


	public void setwPrIsCoupon(Integer wPrIsCoupon) {
		this.wPrIsCoupon = wPrIsCoupon;
	}


	public String getwPrPayChannel() {
		return wPrPayChannel;
	}


	public void setwPrPayChannel(String wPrPayChannel) {
		this.wPrPayChannel = wPrPayChannel;
	}


	public Integer getwPrTimestamp() {
		return wPrTimestamp;
	}


	public void setwPrTimestamp(Integer wPrTimestamp) {
		this.wPrTimestamp = wPrTimestamp;
	}

   
}