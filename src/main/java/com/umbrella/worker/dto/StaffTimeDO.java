package com.umbrella.worker.dto;

import java.util.Date;

public class StaffTimeDO extends BaseDO {
	private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_staff_time.T_STAFF_ID
     *
     * @mbggenerated Sun Oct 30 20:21:25 CST 2016
     */
    private Integer tStaffId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_staff_time.T_SUPPLIER_ID
     *
     * @mbggenerated Sun Oct 30 20:21:25 CST 2016
     */
    private Integer tSupplierId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_staff_time.T_SERVICE_NAME
     *
     * @mbggenerated Sun Oct 30 20:21:25 CST 2016
     */
    private String tServiceName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_staff_time.T_ORDERNO
     *
     * @mbggenerated Sun Oct 30 20:21:25 CST 2016
     */
    private String tOrderno;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_staff_time.T_STAFF_NAME
     *
     * @mbggenerated Sun Oct 30 20:21:25 CST 2016
     */
    private String tStaffName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_staff_time.T_STAFF_MOBILE
     *
     * @mbggenerated Sun Oct 30 20:21:25 CST 2016
     */
    private String tStaffMobile;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_staff_time.T_START_TIME
     *
     * @mbggenerated Sun Oct 30 20:21:25 CST 2016
     */
    private Date tStartTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_staff_time.T_MEMBER_NAME
     *
     * @mbggenerated Sun Oct 30 20:21:25 CST 2016
     */
    private String tMemberName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_staff_time.T_MEMBER_MOBILE
     *
     * @mbggenerated Sun Oct 30 20:21:25 CST 2016
     */
    private String tMemberMobile;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_staff_time.T_END_TIME
     *
     * @mbggenerated Sun Oct 30 20:21:25 CST 2016
     */
    private Date tEndTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer gettStaffId() {
		return tStaffId;
	}

	public void settStaffId(Integer tStaffId) {
		this.tStaffId = tStaffId;
	}

	public Integer gettSupplierId() {
		return tSupplierId;
	}

	public void settSupplierId(Integer tSupplierId) {
		this.tSupplierId = tSupplierId;
	}

	public String gettServiceName() {
		return tServiceName;
	}

	public void settServiceName(String tServiceName) {
		this.tServiceName = tServiceName;
	}

	public String gettOrderno() {
		return tOrderno;
	}

	public void settOrderno(String tOrderno) {
		this.tOrderno = tOrderno;
	}

	public String gettStaffName() {
		return tStaffName;
	}

	public void settStaffName(String tStaffName) {
		this.tStaffName = tStaffName;
	}

	public String gettStaffMobile() {
		return tStaffMobile;
	}

	public void settStaffMobile(String tStaffMobile) {
		this.tStaffMobile = tStaffMobile;
	}

	public Date gettStartTime() {
		return tStartTime;
	}

	public void settStartTime(Date tStartTime) {
		this.tStartTime = tStartTime;
	}

	public String gettMemberName() {
		return tMemberName;
	}

	public void settMemberName(String tMemberName) {
		this.tMemberName = tMemberName;
	}

	public String gettMemberMobile() {
		return tMemberMobile;
	}

	public void settMemberMobile(String tMemberMobile) {
		this.tMemberMobile = tMemberMobile;
	}

	public Date gettEndTime() {
		return tEndTime;
	}

	public void settEndTime(Date tEndTime) {
		this.tEndTime = tEndTime;
	}
    
}