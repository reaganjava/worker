package com.umbrella.worker.dto;

import java.math.BigDecimal;
import java.util.Date;

public class OrderDetailDO extends BaseDO {
    
	private Integer id;

   
	private Integer wOStiffId;

    
    private Integer wOTaskId;

    
    private String wOSupplierName;

    
    private String wOServerName;

   
    private Integer wOServerTime;

    
    private Date createTime;

    
    private Integer wOStaffCount;

    
    private Date wOStartTime;

    
    private BigDecimal wOPrice;

    
    private Date wOEndTime;

    
    private String wOContact;

    
    private String wOCity;

    
    private String wODistrict;

    
    private String wOTelephone;

    
    private String wOStaffTelephone;

    
    private String wOStaffContact;

    
    private String wOAddress;

   
    private Date wOSubscribe;
    
    
    private String wOMessage;
    
    
    private String subDate;
    
    
    private String subTime;



	public Integer getId() {
		return id;
	}


	public Integer getwOTaskId() {
		return wOTaskId;
	}


	public void setwOTaskId(Integer wOTaskId) {
		this.wOTaskId = wOTaskId;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getwOContact() {
		return wOContact;
	}


	public void setwOContact(String wOContact) {
		this.wOContact = wOContact;
	}


	public String getwOCity() {
		return wOCity;
	}


	public void setwOCity(String wOCity) {
		this.wOCity = wOCity;
	}


	public String getwODistrict() {
		return wODistrict;
	}


	public void setwODistrict(String wODistrict) {
		this.wODistrict = wODistrict;
	}


	public String getwOTelephone() {
		return wOTelephone;
	}


	public void setwOTelephone(String wOTelephone) {
		this.wOTelephone = wOTelephone;
	}


	public String getwOAddress() {
		return wOAddress;
	}


	public void setwOAddress(String wOAddress) {
		this.wOAddress = wOAddress;
	}


	public String getwOSupplierName() {
		return wOSupplierName;
	}


	public void setwOSupplierName(String wOSupplierName) {
		this.wOSupplierName = wOSupplierName;
	}

	public Integer getwOStiffId() {
		return wOStiffId;
	}


	public void setwOStiffId(Integer wOStiffId) {
		this.wOStiffId = wOStiffId;
	}


	public String getwOStaffTelephone() {
		return wOStaffTelephone;
	}


	public void setwOStaffTelephone(String wOStaffTelephone) {
		this.wOStaffTelephone = wOStaffTelephone;
	}


	public String getwOStaffContact() {
		return wOStaffContact;
	}


	public void setwOStaffContact(String wOStaffContact) {
		this.wOStaffContact = wOStaffContact;
	}


	public Date getwOSubscribe() {
		return wOSubscribe;
	}


	public void setwOSubscribe(Date wOSubscribe) {
		this.wOSubscribe = wOSubscribe;
	}


	public String getwOServerName() {
		return wOServerName;
	}


	public void setwOServerName(String wOServerName) {
		this.wOServerName = wOServerName;
	}


	public Integer getwOServerTime() {
		return wOServerTime;
	}


	public void setwOServerTime(Integer wOServerTime) {
		this.wOServerTime = wOServerTime;
	}


	public Date getCreateTime() {
		return createTime;
	}


	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	public Integer getwOStaffCount() {
		return wOStaffCount;
	}


	public void setwOStaffCount(Integer wOStaffCount) {
		this.wOStaffCount = wOStaffCount;
	}


	public Date getwOStartTime() {
		return wOStartTime;
	}


	public void setwOStartTime(Date wOStartTime) {
		this.wOStartTime = wOStartTime;
	}


	public BigDecimal getwOPrice() {
		return wOPrice;
	}


	public void setwOPrice(BigDecimal wOPrice) {
		this.wOPrice = wOPrice;
	}


	public Date getwOEndTime() {
		return wOEndTime;
	}


	public void setwOEndTime(Date wOEndTime) {
		this.wOEndTime = wOEndTime;
	}


	public String getwOMessage() {
		return wOMessage;
	}


	public void setwOMessage(String wOMessage) {
		this.wOMessage = wOMessage;
	}


	public String getSubDate() {
		return subDate;
	}


	public void setSubDate(String subDate) {
		this.subDate = subDate;
	}


	public String getSubTime() {
		return subTime;
	}


	public void setSubTime(String subTime) {
		this.subTime = subTime;
	}

}