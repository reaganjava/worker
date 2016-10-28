package com.umbrella.worker.dto;

import java.math.BigDecimal;
import java.util.Date;

public class OrderDetailDO extends BaseDO {
    
	private Integer id;
	
	private Integer contactId;

   
	private Integer wOStiffId;

	
    private String wOSupplierName;

 
    private Integer wOServerTime;

    
    private Date createTime;

    
    private Integer wOStaffCount;

    
    private Date wOStartTime;
    
    
    private Integer wOLockType;
    

    private Integer wOIsLock;
    

    private Integer wOCarType;

  
    private Integer wOPipType;

    
    private Integer wOToiletType;
    
    
    private Integer wODamageType;
    
    
    private String wCaneclInfo;

    
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
    
 
	public Integer getId() {
		return id;
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


	public Integer getwOLockType() {
		return wOLockType;
	}


	public void setwOLockType(Integer wOLockType) {
		this.wOLockType = wOLockType;
	}


	public Integer getwOIsLock() {
		return wOIsLock;
	}


	public void setwOIsLock(Integer wOIsLock) {
		this.wOIsLock = wOIsLock;
	}


	public Integer getwOCarType() {
		return wOCarType;
	}


	public void setwOCarType(Integer wOCarType) {
		this.wOCarType = wOCarType;
	}


	public Integer getwOPipType() {
		return wOPipType;
	}


	public void setwOPipType(Integer wOPipType) {
		this.wOPipType = wOPipType;
	}


	public Integer getwOToiletType() {
		return wOToiletType;
	}


	public void setwOToiletType(Integer wOToiletType) {
		this.wOToiletType = wOToiletType;
	}


	public Date getwOSubscribe() {
		return wOSubscribe;
	}


	public void setwOSubscribe(Date wOSubscribe) {
		this.wOSubscribe = wOSubscribe;
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


	

	public String getwCaneclInfo() {
		return wCaneclInfo;
	}


	public void setwCaneclInfo(String wCaneclInfo) {
		this.wCaneclInfo = wCaneclInfo;
	}


	public Integer getwODamageType() {
		return wODamageType;
	}


	public void setwODamageType(Integer wODamageType) {
		this.wODamageType = wODamageType;
	}


	public Integer getContactId() {
		return contactId;
	}


	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

}