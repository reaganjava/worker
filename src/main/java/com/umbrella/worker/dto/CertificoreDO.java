package com.umbrella.worker.dto;

import java.util.Date;

public class CertificoreDO extends BaseDO {
    
    private Integer id;
  
    private ScheduleDO scheduleDO;
 
    private String wCeName;

    private Integer wCeAttacId;
 
    private Date wCeValidTime;

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