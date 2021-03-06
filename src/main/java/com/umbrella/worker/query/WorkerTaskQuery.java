package com.umbrella.worker.query;

public class WorkerTaskQuery extends BaseQuery {
	
	private Integer type;
	
	private Integer taskId;
	
	private String name;
	
	private Integer taskItemId;
	
	private Integer taskStaffId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public Integer getTaskItemId() {
		return taskItemId;
	}

	public void setTaskItemId(Integer taskItemId) {
		this.taskItemId = taskItemId;
	}

	public Integer getTaskStaffId() {
		return taskStaffId;
	}

	public void setTaskStaffId(Integer taskStaffId) {
		this.taskStaffId = taskStaffId;
	}
	 
}