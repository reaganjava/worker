package com.umbrella.worker.dto;

import java.util.Date;
import java.util.List;

public class MembersDO extends BaseDO {
    
    private Integer id;

   
    private String wMMobile;

    
    private Integer wMFace;

    
    private String wMPassword;

    
    private String wMNickname;

    
    private String wMLoginIp;

    
    private Date wMRegisterTime;

   
    private Date wMLastLoginTime;
    
    
    private MemberCouponDO memberCouponDO;
    
    private List<ContactDO> contacts;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getwMMobile() {
		return wMMobile;
	}


	public void setwMMobile(String wMMobile) {
		this.wMMobile = wMMobile;
	}


	public Integer getwMFace() {
		return wMFace;
	}


	public void setwMFace(Integer wMFace) {
		this.wMFace = wMFace;
	}


	public String getwMPassword() {
		return wMPassword;
	}


	public void setwMPassword(String wMPassword) {
		this.wMPassword = wMPassword;
	}


	public String getwMNickname() {
		return wMNickname;
	}


	public void setwMNickname(String wMNickname) {
		this.wMNickname = wMNickname;
	}


	public String getwMLoginIp() {
		return wMLoginIp;
	}


	public void setwMLoginIp(String wMLoginIp) {
		this.wMLoginIp = wMLoginIp;
	}


	public Date getwMRegisterTime() {
		return wMRegisterTime;
	}


	public void setwMRegisterTime(Date wMRegisterTime) {
		this.wMRegisterTime = wMRegisterTime;
	}


	public Date getwMLastLoginTime() {
		return wMLastLoginTime;
	}


	public void setwMLastLoginTime(Date wMLastLoginTime) {
		this.wMLastLoginTime = wMLastLoginTime;
	}


	public MemberCouponDO getMemberCouponDO() {
		return memberCouponDO;
	}


	public void setMemberCouponDO(MemberCouponDO memberCouponDO) {
		this.memberCouponDO = memberCouponDO;
	}


	public List<ContactDO> getContacts() {
		return contacts;
	}


	public void setContacts(List<ContactDO> contacts) {
		this.contacts = contacts;
	}
   
}