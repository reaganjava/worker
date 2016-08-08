package com.umbrella.worker.dto;

import java.util.Date;
import java.util.List;

public class AdminDO extends BaseDO {
  
    private Integer id;

  
    private SupplierDO supplierDO;

    
    private String wAUsername;

    
    private String wAPassword;

   
    private String wARealName;

   
    private String wATelephone;

   
    private Integer wARoleId;

   
    private Date wALastLogTime;

   
    private String wALoginIp;
    
    
    private List<MenuDO> menus;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public SupplierDO getSupplierDO() {
		return supplierDO;
	}


	public void setSupplierDO(SupplierDO supplierDO) {
		this.supplierDO = supplierDO;
	}


	public String getwAUsername() {
		return wAUsername;
	}


	public void setwAUsername(String wAUsername) {
		this.wAUsername = wAUsername;
	}


	public String getwAPassword() {
		return wAPassword;
	}


	public void setwAPassword(String wAPassword) {
		this.wAPassword = wAPassword;
	}


	public String getwARealName() {
		return wARealName;
	}


	public void setwARealName(String wARealName) {
		this.wARealName = wARealName;
	}


	public String getwATelephone() {
		return wATelephone;
	}


	public void setwATelephone(String wATelephone) {
		this.wATelephone = wATelephone;
	}


	public Integer getwARoleId() {
		return wARoleId;
	}


	public void setwARoleId(Integer wARoleId) {
		this.wARoleId = wARoleId;
	}


	public Date getwALastLogTime() {
		return wALastLogTime;
	}


	public void setwALastLogTime(Date wALastLogTime) {
		this.wALastLogTime = wALastLogTime;
	}


	public String getwALoginIp() {
		return wALoginIp;
	}


	public void setwALoginIp(String wALoginIp) {
		this.wALoginIp = wALoginIp;
	}


	public List<MenuDO> getMenus() {
		return menus;
	}


	public void setMenus(List<MenuDO> menus) {
		this.menus = menus;
	}

 
}