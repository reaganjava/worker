package com.umbrella.worker.dto;

import java.util.Date;

public class OrderDetailDO extends BaseDO {
    
	private Integer id;

   
    private Integer wOStiffId;

   
    private String wOSupplierName;

  
    private String wOContact;

   
    private String wOCity;

    
    private String wODistrict;

   
    private String wOTelephone;

    
    private String wOStaffTelephone;

    
    private String wOStaffContact;

    
    private String wOAddress;

    
    private Date wOSubscribe;

   
    private WorkerTaskDO workerTaskDO;


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


	public WorkerTaskDO getWorkerTaskDO() {
		return workerTaskDO;
	}


	public void setWorkerTaskDO(WorkerTaskDO workerTaskDO) {
		this.workerTaskDO = workerTaskDO;
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

}