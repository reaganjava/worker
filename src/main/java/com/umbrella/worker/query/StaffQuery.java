package com.umbrella.worker.query;


public class StaffQuery extends BaseQuery {
    
    private Integer supplierId;

  
    private String staffName;

     
    private Integer staffGender;

     
    private String idcard;


    private Integer wokerYear;

    
    private Integer grade;

    
    private Integer serviceType;


	public Integer getSupplierId() {
		return supplierId;
	}


	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}


	public String getStaffName() {
		return staffName;
	}


	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}


	public Integer getStaffGender() {
		return staffGender;
	}


	public void setStaffGender(Integer staffGender) {
		this.staffGender = staffGender;
	}


	public String getIdcard() {
		return idcard;
	}


	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}


	public Integer getWokerYear() {
		return wokerYear;
	}


	public void setWokerYear(Integer wokerYear) {
		this.wokerYear = wokerYear;
	}


	public Integer getGrade() {
		return grade;
	}


	public void setGrade(Integer grade) {
		this.grade = grade;
	}


	public Integer getServiceType() {
		return serviceType;
	}


	public void setServiceType(Integer serviceType) {
		this.serviceType = serviceType;
	}

    
   
}