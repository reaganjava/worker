package com.umbrella.worker.dto;

import java.math.BigDecimal;
import java.util.Date;

public class CouponDO extends BaseDO {
    
	
    private Integer id;

    
    private String wCCouponNo;

    
    private String wCTitle;

    
    private Integer wCType;

    
    private String wCDesc;

    
    private Integer wCAttacId;

    
    private BigDecimal wCMoney;

    
    private Float wCDiscount;

   
    private Date wCBeginTime;

    
    private Date wCEndTime;

    
    private Integer wCPublishiCount;

    
    private Integer wIsEnd;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getwCCouponNo() {
		return wCCouponNo;
	}


	public void setwCCouponNo(String wCCouponNo) {
		this.wCCouponNo = wCCouponNo;
	}


	public String getwCTitle() {
		return wCTitle;
	}


	public void setwCTitle(String wCTitle) {
		this.wCTitle = wCTitle;
	}


	public Integer getwCType() {
		return wCType;
	}


	public void setwCType(Integer wCType) {
		this.wCType = wCType;
	}


	public String getwCDesc() {
		return wCDesc;
	}


	public void setwCDesc(String wCDesc) {
		this.wCDesc = wCDesc;
	}


	public Integer getwCAttacId() {
		return wCAttacId;
	}


	public void setwCAttacId(Integer wCAttacId) {
		this.wCAttacId = wCAttacId;
	}


	public BigDecimal getwCMoney() {
		return wCMoney;
	}


	public void setwCMoney(BigDecimal wCMoney) {
		this.wCMoney = wCMoney;
	}


	public Float getwCDiscount() {
		return wCDiscount;
	}


	public void setwCDiscount(Float wCDiscount) {
		this.wCDiscount = wCDiscount;
	}


	public Date getwCBeginTime() {
		return wCBeginTime;
	}


	public void setwCBeginTime(Date wCBeginTime) {
		this.wCBeginTime = wCBeginTime;
	}


	public Date getwCEndTime() {
		return wCEndTime;
	}


	public void setwCEndTime(Date wCEndTime) {
		this.wCEndTime = wCEndTime;
	}


	public Integer getwCPublishiCount() {
		return wCPublishiCount;
	}


	public void setwCPublishiCount(Integer wCPublishiCount) {
		this.wCPublishiCount = wCPublishiCount;
	}


	public Integer getwIsEnd() {
		return wIsEnd;
	}


	public void setwIsEnd(Integer wIsEnd) {
		this.wIsEnd = wIsEnd;
	}

	
}