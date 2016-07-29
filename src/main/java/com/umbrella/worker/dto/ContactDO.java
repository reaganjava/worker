package com.umbrella.worker.dto;

public class ContactDO extends BaseDO {
    
    private Integer id;

   
    private MembersDO membersDO;

   
    private String wCContact;

    
    private String wCCity;

    
    private String wCDistrict;

    
    private String wCTelephone;

   
    private String wCAddress;

    
    private Integer wCDefault;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public MembersDO getMembersDO() {
		return membersDO;
	}


	public void setMembersDO(MembersDO membersDO) {
		this.membersDO = membersDO;
	}


	public String getwCContact() {
		return wCContact;
	}


	public void setwCContact(String wCContact) {
		this.wCContact = wCContact;
	}


	public String getwCCity() {
		return wCCity;
	}


	public void setwCCity(String wCCity) {
		this.wCCity = wCCity;
	}


	public String getwCDistrict() {
		return wCDistrict;
	}


	public void setwCDistrict(String wCDistrict) {
		this.wCDistrict = wCDistrict;
	}


	public String getwCTelephone() {
		return wCTelephone;
	}


	public void setwCTelephone(String wCTelephone) {
		this.wCTelephone = wCTelephone;
	}


	public String getwCAddress() {
		return wCAddress;
	}


	public void setwCAddress(String wCAddress) {
		this.wCAddress = wCAddress;
	}


	public Integer getwCDefault() {
		return wCDefault;
	}


	public void setwCDefault(Integer wCDefault) {
		this.wCDefault = wCDefault;
	}

    
}