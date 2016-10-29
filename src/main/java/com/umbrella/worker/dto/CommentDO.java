package com.umbrella.worker.dto;

public class CommentDO extends BaseDO {
    
	private Integer id;

   
    private Integer wMembersId;
    

    private String wCContent;
    

    private String wName;
    

    
    private String wMobile;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getwMembersId() {
		return wMembersId;
	}

	public void setwMembersId(Integer wMembersId) {
		this.wMembersId = wMembersId;
	}

	public String getwCContent() {
		return wCContent;
	}

	public void setwCContent(String wCContent) {
		this.wCContent = wCContent;
	}

	public String getwName() {
		return wName;
	}

	public void setwName(String wName) {
		this.wName = wName;
	}

	public String getwMobile() {
		return wMobile;
	}

	public void setwMobile(String wMobile) {
		this.wMobile = wMobile;
	}

	
}