package com.umbrella.worker.dto;

import java.util.ArrayList;
import java.util.List;

public class WorkerItemDO extends BaseDO {
	
	private Integer id;
	
	
	private String wWiItem;

	
    private Integer wWiTaskId;
    
    
    private List<WorkerStaffDO> workerStaffs = new ArrayList<WorkerStaffDO>();


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getwWiItem() {
		return wWiItem;
	}


	public void setwWiItem(String wWiItem) {
		this.wWiItem = wWiItem;
	}


	public Integer getwWiTaskId() {
		return wWiTaskId;
	}


	public void setwWiTaskId(Integer wWiTaskId) {
		this.wWiTaskId = wWiTaskId;
	}


	public List<WorkerStaffDO> getWorkerStaffs() {
		return workerStaffs;
	}


	public void setWorkerStaffs(List<WorkerStaffDO> workerStaffs) {
		this.workerStaffs = workerStaffs;
	}

}
