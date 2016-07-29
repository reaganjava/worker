package com.umbrella.worker.dto;

public class RatinDO extends BaseDO {
    
    private Integer id;

     
    private Integer wRScheduleId;

     
    private Integer wRScore;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getwRScheduleId() {
		return wRScheduleId;
	}


	public void setwRScheduleId(Integer wRScheduleId) {
		this.wRScheduleId = wRScheduleId;
	}


	public Integer getwRScore() {
		return wRScore;
	}


	public void setwRScore(Integer wRScore) {
		this.wRScore = wRScore;
	}

   
}