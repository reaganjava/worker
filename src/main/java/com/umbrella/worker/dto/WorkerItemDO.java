package com.umbrella.worker.dto;

public class WorkerItemDO extends BaseDO {
	
	private Integer id;
	
	
	private String wWiItem;

	
    private Integer wWiTaskId;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getwWiItem() {
		return wWiItem;
	}


	public void setwWiItem(String wWiItem) {
		this.wWiItem = wWiItem;
	}


	public Integer getwWiTaskId() {
		return wWiTaskId;
	}


	public void setwWiTaskId(Integer wWiTaskId) {
		this.wWiTaskId = wWiTaskId;
	}

}
