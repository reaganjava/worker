package com.umbrella.worker.dto;

import java.util.Date;

public class MemberDetailDO extends BaseDO{

	private Integer id;

   
    private Integer wMdCouponCount;

    
    private Integer wMdUseCount;

   
    private Integer wMdScore;

    
    private Integer wMdGarde;

    
    private Date wMdBirthday;

    
    private String wMdOccupation;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getwMdCouponCount() {
		return wMdCouponCount;
	}


	public void setwMdCouponCount(Integer wMdCouponCount) {
		this.wMdCouponCount = wMdCouponCount;
	}


	public Integer getwMdUseCount() {
		return wMdUseCount;
	}


	public void setwMdUseCount(Integer wMdUseCount) {
		this.wMdUseCount = wMdUseCount;
	}


	public Integer getwMdScore() {
		return wMdScore;
	}


	public void setwMdScore(Integer wMdScore) {
		this.wMdScore = wMdScore;
	}


	public Integer getwMdGarde() {
		return wMdGarde;
	}


	public void setwMdGarde(Integer wMdGarde) {
		this.wMdGarde = wMdGarde;
	}


	public Date getwMdBirthday() {
		return wMdBirthday;
	}


	public void setwMdBirthday(Date wMdBirthday) {
		this.wMdBirthday = wMdBirthday;
	}


	public String getwMdOccupation() {
		return wMdOccupation;
	}


	public void setwMdOccupation(String wMdOccupation) {
		this.wMdOccupation = wMdOccupation;
	}
    
}
