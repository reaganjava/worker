package com.umbrella.worker.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class WorkerTaskDO extends BaseDO {
	
	private Integer id;
	
	
	private Integer itemId;
	
	
	private Integer staffId;
	
    
    private Integer wWSupplier;

    
    private String wWName;

    
    private BigDecimal wWPrice;

    
    private Integer wWPriceUnit;
    
    
    private Integer wWType;
    

    private String wWDesc;
    
    
    private List<WorkerItemDO> workerItems = new ArrayList<WorkerItemDO>();
    
    
    private List<WorkerStaffDO> workerStaffs = new ArrayList<WorkerStaffDO>();
    
    
    private List<SupplierDO> suppliers = new ArrayList<SupplierDO>();
    
    
    private List<Integer> removeItems = new ArrayList<Integer>();
    
    
    private List<Integer> removeStaff = new ArrayList<Integer>();


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getItemId() {
		return itemId;
	}


	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}


	public Integer getStaffId() {
		return staffId;
	}


	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}


	public Integer getwWSupplier() {
		return wWSupplier;
	}


	public void setwWSupplier(Integer wWSupplier) {
		this.wWSupplier = wWSupplier;
	}


	public BigDecimal getwWPrice() {
		return wWPrice;
	}


	public void setwWPrice(BigDecimal wWPrice) {
		this.wWPrice = wWPrice;
	}


	public Integer getwWType() {
		return wWType;
	}


	public void setwWType(Integer wWType) {
		this.wWType = wWType;
	}


	public String getwWDesc() {
		return wWDesc;
	}


	public void setwWDesc(String wWDesc) {
		this.wWDesc = wWDesc;
	}


	public List<WorkerItemDO> getWorkerItems() {
		return workerItems;
	}


	public void setWorkerItems(List<WorkerItemDO> workerItems) {
		this.workerItems = workerItems;
	}


	public List<WorkerStaffDO> getWorkerStaffs() {
		return workerStaffs;
	}


	public void setWorkerStaffs(List<WorkerStaffDO> workerStaffs) {
		this.workerStaffs = workerStaffs;
	}


	public String getwWName() {
		return wWName;
	}


	public void setwWName(String wWName) {
		this.wWName = wWName;
	}


	public Integer getwWPriceUnit() {
		return wWPriceUnit;
	}


	public void setwWPriceUnit(Integer wWPriceUnit) {
		this.wWPriceUnit = wWPriceUnit;
	}


	public List<SupplierDO> getSuppliers() {
		return suppliers;
	}


	public void setSuppliers(List<SupplierDO> suppliers) {
		this.suppliers = suppliers;
	}


	public List<Integer> getRemoveItems() {
		return removeItems;
	}


	public void setRemoveItems(List<Integer> removeItems) {
		this.removeItems = removeItems;
	}


	public List<Integer> getRemoveStaff() {
		return removeStaff;
	}


	public void setRemoveStaff(List<Integer> removeStaff) {
		this.removeStaff = removeStaff;
	}
	
	

}
