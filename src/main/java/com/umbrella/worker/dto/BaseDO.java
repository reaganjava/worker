package com.umbrella.worker.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseDO {
	
	private Date createTime;
	
	
	private String formatDate;

   
    private String createAuthor;

    
    private Date modifiTime;

  
    private String modifiAuthor;


    private Integer datalevel;

  
    private Integer status;


	public String getFormatDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		this.formatDate = dateFormat.format(this.getCreateTime());
		return formatDate;
	}


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
