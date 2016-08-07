package com.umbrella.worker.dto;

import java.util.Date;

public class MemberCouponDO extends BaseDO {

	private Integer id;

    
    private Integer wMcMemberId;

    
    private Integer wMcCouponId;

    
    private String wMcCouponTitle;

    
    private Integer wMcCouponType;

   
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


	public Date getwMcUseDate() {
		return wMcUseDate;
	}


	public void setwMcUseDate(Date wMcUseDate) {
		this.wMcUseDate = wMcUseDate;
	}

}
