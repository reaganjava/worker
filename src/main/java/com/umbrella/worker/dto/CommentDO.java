package com.umbrella.worker.dto;

public class CommentDO extends BaseDO {
    
    private Integer id;

    private Integer wMembersId;

    private Integer wStaffId;

    private String wCTitle;
    
    private String wCContent;

    private String wCNickname;

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

	public Integer getwStaffId() {
		return wStaffId;
	}

	public void setwStaffId(Integer wStaffId) {
		this.wStaffId = wStaffId;
	}

	public String getwCTitle() {
		return wCTitle;
	}

	public void setwCTitle(String wCTitle) {
		this.wCTitle = wCTitle;
	}

	public String getwCContent() {
		return wCContent;
	}

	public void setwCContent(String wCContent) {
		this.wCContent = wCContent;
	}

	public String getwCNickname() {
		return wCNickname;
	}

	public void setwCNickname(String wCNickname) {
		this.wCNickname = wCNickname;
	}

}