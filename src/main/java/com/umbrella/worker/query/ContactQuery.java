package com.umbrella.worker.query;

public class ContactQuery extends BaseQuery {
    
    private Integer memberId;
    
    private Integer isDefault;

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}    
}