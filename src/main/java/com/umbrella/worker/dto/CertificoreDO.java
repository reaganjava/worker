package com.umbrella.worker.dto;

import java.util.Date;

public class CertificoreDO extends BaseDO {
    
    private Integer id;
  
    private StaffDO staffDO;
 
    private String wCeName;

    private Integer wCeAttacId;
 
    private Date wCeValidTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public StaffDO getStaffDO() {
		return staffDO;
	}

	public void setStaffDO(StaffDO staffDO) {
		this.staffDO = staffDO;
	}

	public String getwCeName() {
		return wCeName;
	}

	public void setwCeName(String wCeName) {
		this.wCeName = wCeName;
	}

	public Integer getwCeAttacId() {
		return wCeAttacId;
	}

	public void setwCeAttacId(Integer wCeAttacId) {
		this.wCeAttacId = wCeAttacId;
	}

	public Date getwCeValidTime() {
		return wCeValidTime;
	}

	public void setwCeValidTime(Date wCeValidTime) {
		this.wCeValidTime = wCeValidTime;
	}
    

}