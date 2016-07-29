package com.umbrella.worker.dto;

import java.util.Date;

public class OrderDetailDO extends BaseDO {
    
    private Integer id;

    
    private ScheduleDO scheduleDO;

    
    private String wOContact;

    
    private String wOCity;

    
    private String wODistrict;

    
    private String wOTelephone;

   
    private String wOAddress;

    
    private String wOSupplierName;

    
    private Date wOBeginTime;

    
    private Date wOEndTime;

    
    private Integer wOHour;

   
    private Integer wOStaffCount;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public ScheduleDO getScheduleDO() {
		return scheduleDO;
	}


	public void setScheduleDO(ScheduleDO scheduleDO) {
		this.scheduleDO = scheduleDO;
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


	public Date getwOBeginTime() {
		return wOBeginTime;
	}


	public void setwOBeginTime(Date wOBeginTime) {
		this.wOBeginTime = wOBeginTime;
	}


	public Date getwOEndTime() {
		return wOEndTime;
	}


	public void setwOEndTime(Date wOEndTime) {
		this.wOEndTime = wOEndTime;
	}


	public Integer getwOHour() {
		return wOHour;
	}


	public void setwOHour(Integer wOHour) {
		this.wOHour = wOHour;
	}


	public Integer getwOStaffCount() {
		return wOStaffCount;
	}


	public void setwOStaffCount(Integer wOStaffCount) {
		this.wOStaffCount = wOStaffCount;
	}

   
}