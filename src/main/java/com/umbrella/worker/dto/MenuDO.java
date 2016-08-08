package com.umbrella.worker.dto;

public class MenuDO extends BaseDO {

	private Integer id;

    
    private String wMItem;

    
    private String wMUrl;

    
    private Integer wMRoleId;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getwMItem() {
		return wMItem;
	}


	public void setwMItem(String wMItem) {
		this.wMItem = wMItem;
	}


	public String getwMUrl() {
		return wMUrl;
	}


	public void setwMUrl(String wMUrl) {
		this.wMUrl = wMUrl;
	}


	public Integer getwMRoleId() {
		return wMRoleId;
	}


	public void setwMRoleId(Integer wMRoleId) {
		this.wMRoleId = wMRoleId;
	}

}
