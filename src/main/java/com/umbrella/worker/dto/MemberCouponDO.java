package com.umbrella.worker.dto;

import java.math.BigDecimal;
import java.util.Date;

public class MemberCouponDO extends BaseDO {
    
    private Integer id;

   
    private MembersDO membersDO;

    
    private String wMcCouponNo;

    
    private String wMcTitle;

   
    private Integer wMcType;

    
    private String wMcDesc;

    
    private Integer wMcAttacId;

   
    private BigDecimal wMcMoney;

   
    private Float wMcDiscount;

    
    private Date wMcBeginTime;

   
    private Date wMcEndTime;

   
    private Integer wMcIsPrescri;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public MembersDO getMembersDO() {
		return membersDO;
	}


	public void setMembersDO(MembersDO membersDO) {
		this.membersDO = membersDO;
	}


	public String getwMcCouponNo() {
		return wMcCouponNo;
	}


	public void setwMcCouponNo(String wMcCouponNo) {
		this.wMcCouponNo = wMcCouponNo;
	}


	public String getwMcTitle() {
		return wMcTitle;
	}


	public void setwMcTitle(String wMcTitle) {
		this.wMcTitle = wMcTitle;
	}


	public Integer getwMcType() {
		return wMcType;
	}


	public void setwMcType(Integer wMcType) {
		this.wMcType = wMcType;
	}


	public String getwMcDesc() {
		return wMcDesc;
	}


	public void setwMcDesc(String wMcDesc) {
		this.wMcDesc = wMcDesc;
	}


	public Integer getwMcAttacId() {
		return wMcAttacId;
	}


	public void setwMcAttacId(Integer wMcAttacId) {
		this.wMcAttacId = wMcAttacId;
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


	public Date getwMcBeginTime() {
		return wMcBeginTime;
	}


	public void setwMcBeginTime(Date wMcBeginTime) {
		this.wMcBeginTime = wMcBeginTime;
	}


	public Date getwMcEndTime() {
		return wMcEndTime;
	}


	public void setwMcEndTime(Date wMcEndTime) {
		this.wMcEndTime = wMcEndTime;
	}


	public Integer getwMcIsPrescri() {
		return wMcIsPrescri;
	}


	public void setwMcIsPrescri(Integer wMcIsPrescri) {
		this.wMcIsPrescri = wMcIsPrescri;
	}

    
}