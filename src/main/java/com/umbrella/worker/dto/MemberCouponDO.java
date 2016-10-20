package com.umbrella.worker.dto;

import java.math.BigDecimal;
import java.util.Date;

public class MemberCouponDO extends BaseDO {

	private Integer id;

    
    private String wCCouponNo;

    
    private Integer wMcMemberId;

    
    private Integer wMcCouponId;

    
    private String wMcCouponTitle;

    
    private Integer wMcCouponType;
    
    
    private BigDecimal wMcMoney;

    private Integer discount;
    
    private Float wMcDiscount;
    
    
    
    private Date wMcDeadline;

   
    private Date wMcUseDate;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getwMcMemberId() {
		return wMcMemberId;
	}


	public void setwMcMemberId(Integer wMcMemberId) {
		this.wMcMemberId = wMcMemberId;
	}


	public Integer getwMcCouponId() {
		return wMcCouponId;
	}


	public void setwMcCouponId(Integer wMcCouponId) {
		this.wMcCouponId = wMcCouponId;
	}


	public String getwMcCouponTitle() {
		return wMcCouponTitle;
	}


	public void setwMcCouponTitle(String wMcCouponTitle) {
		this.wMcCouponTitle = wMcCouponTitle;
	}


	public Integer getwMcCouponType() {
		return wMcCouponType;
	}


	public void setwMcCouponType(Integer wMcCouponType) {
		this.wMcCouponType = wMcCouponType;
	}


	public Date getwMcDeadline() {
		return wMcDeadline;
	}


	public void setwMcDeadline(Date wMcDeadline) {
		this.wMcDeadline = wMcDeadline;
	}


	public Date getwMcUseDate() {
		return wMcUseDate;
	}


	public void setwMcUseDate(Date wMcUseDate) {
		this.wMcUseDate = wMcUseDate;
	}


	public String getwCCouponNo() {
		return wCCouponNo;
	}


	public void setwCCouponNo(String wCCouponNo) {
		this.wCCouponNo = wCCouponNo;
	}


	public BigDecimal getwMcMoney() {
		return wMcMoney;
	}


	public void setwMcMoney(BigDecimal wMcMoney) {
		this.wMcMoney = wMcMoney;
	}


	public Float getwMcDiscount() {
		return wMcDiscount;
	}


	public void setwMcDiscount(Float wMcDiscount) {
		this.wMcDiscount = wMcDiscount;
	}


	public Integer getDiscount() {
		return (int) (wMcDiscount * 100);
	}

}
