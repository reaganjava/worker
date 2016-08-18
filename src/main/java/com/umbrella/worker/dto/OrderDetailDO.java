package com.umbrella.worker.dto;

import java.util.Date;

public class OrderDetailDO extends BaseDO {
    
	private Integer id;

   
    private Integer wOStiffId;
    
    
    private Integer wOTaskId;

   
    private String wOSupplierName;

  
    private String wOContact;

   
    private String wOCity;

    
    private String wODistrict;

   
    private String wOTelephone;

    
    private String wOStaffTelephone;

    
    private String wOStaffContact;

    
    private String wOAddress;

    
    private Date wOSubscribe;
    
    
    private String subDate;
    
    
    private String subTime;

   
    private OrderTaskDO orderTaskDO;


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

	public OrderTaskDO getOrderTaskDO() {
		return orderTaskDO;
	}


	public void setOrderTaskDO(OrderTaskDO orderTaskDO) {
		this.orderTaskDO = orderTaskDO;
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