package com.umbrella.worker.dto;

import java.util.Date;
import java.util.List;

public class MembersDO extends BaseDO {
    
	private Integer id;


    private String wMMobile;

    
    private Integer wMFace;
    
    
    private String rePassword;

    
    private String wMPassword;

    
    private String wMNickname;

    
    private String wMLoginIp;

    
    private Date wMRegTime;

   
    private String wMRegDevice;

   
    private String wMRegIp;
    
    
    private String smsCode;

    
    private MemberDetailDO memberDetailDO;
    
    private List<MemberCouponDO> memberCoupons;
    
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


	public String getRePassword() {
		return rePassword;
	}


	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
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


	public Date getwMRegTime() {
		return wMRegTime;
	}


	public void setwMRegTime(Date wMRegTime) {
		this.wMRegTime = wMRegTime;
	}


	public String getwMRegDevice() {
		return wMRegDevice;
	}


	public void setwMRegDevice(String wMRegDevice) {
		this.wMRegDevice = wMRegDevice;
	}


	public String getwMRegIp() {
		return wMRegIp;
	}


	public void setwMRegIp(String wMRegIp) {
		this.wMRegIp = wMRegIp;
	}


	public MemberDetailDO getMemberDetailDO() {
		return memberDetailDO;
	}


	public void setMemberDetailDO(MemberDetailDO memberDetailDO) {
		this.memberDetailDO = memberDetailDO;
	}


	public List<MemberCouponDO> getMemberCoupons() {
		return memberCoupons;
	}


	public void setMemberCoupons(List<MemberCouponDO> memberCoupons) {
		this.memberCoupons = memberCoupons;
	}


	public List<ContactDO> getContacts() {
		return contacts;
	}


	public void setContacts(List<ContactDO> contacts) {
		this.contacts = contacts;
	}


	public String getSmsCode() {
		return smsCode;
	}


	public void setSmsCode(String smsCode) {
		this.smsCode = smsCode;
	}
   
}