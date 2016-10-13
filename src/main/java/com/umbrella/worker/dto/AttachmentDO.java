package com.umbrella.worker.dto;

public class AttachmentDO extends BaseDO {
	
	private Integer id;

    private String wAttachName;

    private String wAttachPath;

    private String wAttachUri;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getwAttachName() {
		return wAttachName;
	}

	public void setwAttachName(String wAttachName) {
		this.wAttachName = wAttachName;
	}

	public String getwAttachPath() {
		return wAttachPath;
	}

	public void setwAttachPath(String wAttachPath) {
		this.wAttachPath = wAttachPath;
	}

	public String getwAttachUri() {
		return wAttachUri;
	}

	public void setwAttachUri(String wAttachUri) {
		this.wAttachUri = wAttachUri;
	}
    
}
