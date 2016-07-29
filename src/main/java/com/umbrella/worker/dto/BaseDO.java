package com.umbrella.worker.dto;

import java.util.Date;

public class BaseDO {
	
	private Date createTime;

   
    private String createAuthor;

    
    private Date modifiTime;

  
    private String modifiAuthor;


    private Integer datalevel;

  
    private Integer status;


	public Date getCreateTime() {
		return createTime;
	}


	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	public String getCreateAuthor() {
		return createAuthor;
	}


	public void setCreateAuthor(String createAuthor) {
		this.createAuthor = createAuthor;
	}


	public Date getModifiTime() {
		return modifiTime;
	}


	public void setModifiTime(Date modifiTime) {
		this.modifiTime = modifiTime;
	}


	public String getModifiAuthor() {
		return modifiAuthor;
	}


	public void setModifiAuthor(String modifiAuthor) {
		this.modifiAuthor = modifiAuthor;
	}


	public Integer getDatalevel() {
		return datalevel;
	}


	public void setDatalevel(Integer datalevel) {
		this.datalevel = datalevel;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}

    

}
