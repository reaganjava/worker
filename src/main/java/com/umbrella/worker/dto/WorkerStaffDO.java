package com.umbrella.worker.dto;

public class WorkerStaffDO extends BaseDO {

	    private Integer id;
 
	    
	    private Integer wWsTaskId;

	     
	    private Integer wWsStaffCount;

	    
	    private Integer wWsHours;


		public Integer getId() {
			return id;
		}


		public void setId(Integer id) {
			this.id = id;
		}


		public Integer getwWsTaskId() {
			return wWsTaskId;
		}


		public void setwWsTaskId(Integer wWsTaskId) {
			this.wWsTaskId = wWsTaskId;
		}


		public Integer getwWsStaffCount() {
			return wWsStaffCount;
		}


		public void setwWsStaffCount(Integer wWsStaffCount) {
			this.wWsStaffCount = wWsStaffCount;
		}


		public Integer getwWsHours() {
			return wWsHours;
		}


		public void setwWsHours(Integer wWsHours) {
			this.wWsHours = wWsHours;
		}

	    
}
