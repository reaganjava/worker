package com.umbrella.worker.dto;

import java.math.BigDecimal;

public class PayrecordDO extends BaseDO {

	private Integer id;

	private String wPrTradeNo;

	private String wPrOrderNo;

	private String wPrCouponNo;

	private BigDecimal wPrFee;

	private BigDecimal wPrCouponPrice;

	private Integer wPrIsCoupon;

	private String wPrPayChannel;

	private Integer wPrTimestamp;

	private Integer wPrStatus;
	
	private Integer payChannelValue;

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

	public BigDecimal getwPrCouponPrice() {
		return wPrCouponPrice;
	}

	public void setwPrCouponPrice(BigDecimal wPrCouponPrice) {
		this.wPrCouponPrice = wPrCouponPrice;
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

	public Integer getwPrStatus() {
		return wPrStatus;
	}

	public void setwPrStatus(Integer wPrStatus) {
		this.wPrStatus = wPrStatus;
	}

	public Integer getPayChannelValue() {
		return payChannelValue;
	}

	public void setPayChannelValue(Integer payChannelValue) {
		this.payChannelValue = payChannelValue;
	}
	
}