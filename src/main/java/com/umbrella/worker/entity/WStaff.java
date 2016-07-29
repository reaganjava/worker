package com.umbrella.worker.entity;

import java.util.Date;

public class WStaff {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_staff.ID
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_staff.W_S_SUPPLIER_ID
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    private Integer wSSupplierId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_staff.W_S_ATTAC_ID
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    private Integer wSAttacId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_staff.W_STAFF_NAME
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    private String wStaffName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_staff.W_STAFF_GENDER
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    private Integer wStaffGender;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_staff.W_S_IDCARD
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    private String wSIdcard;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_staff.W_S_AGE
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    private Integer wSAge;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_staff.W_S_WOKER_YEAR
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    private Integer wSWokerYear;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_staff.W_S_GRADE
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    private Integer wSGrade;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_staff.W_S_SERVICE_TYPE
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    private Integer wSServiceType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_staff.W_S_TITLE
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    private String wSTitle;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_staff.W_S_SCORE
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    private Integer wSScore;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_staff.W_S_WORK_COUNT
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    private Integer wSWorkCount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_staff.W_S_DESC
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    private String wSDesc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_staff.W_S_COMPLAINT_COUNT
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    private Integer wSComplaintCount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_staff.CREATE_AUTHOR
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    private String createAuthor;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_staff.MODIFI_TIME
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    private Date modifiTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_staff.MODIFI_AUTHOR
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    private String modifiAuthor;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_staff.DATALEVEL
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    private Integer datalevel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_staff.STATUS
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    private String status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_staff.ID
     *
     * @return the value of w_staff.ID
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_staff.ID
     *
     * @param id the value for w_staff.ID
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_staff.W_S_SUPPLIER_ID
     *
     * @return the value of w_staff.W_S_SUPPLIER_ID
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public Integer getwSSupplierId() {
        return wSSupplierId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_staff.W_S_SUPPLIER_ID
     *
     * @param wSSupplierId the value for w_staff.W_S_SUPPLIER_ID
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public void setwSSupplierId(Integer wSSupplierId) {
        this.wSSupplierId = wSSupplierId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_staff.W_S_ATTAC_ID
     *
     * @return the value of w_staff.W_S_ATTAC_ID
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public Integer getwSAttacId() {
        return wSAttacId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_staff.W_S_ATTAC_ID
     *
     * @param wSAttacId the value for w_staff.W_S_ATTAC_ID
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public void setwSAttacId(Integer wSAttacId) {
        this.wSAttacId = wSAttacId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_staff.W_STAFF_NAME
     *
     * @return the value of w_staff.W_STAFF_NAME
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public String getwStaffName() {
        return wStaffName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_staff.W_STAFF_NAME
     *
     * @param wStaffName the value for w_staff.W_STAFF_NAME
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public void setwStaffName(String wStaffName) {
        this.wStaffName = wStaffName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_staff.W_STAFF_GENDER
     *
     * @return the value of w_staff.W_STAFF_GENDER
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public Integer getwStaffGender() {
        return wStaffGender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_staff.W_STAFF_GENDER
     *
     * @param wStaffGender the value for w_staff.W_STAFF_GENDER
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public void setwStaffGender(Integer wStaffGender) {
        this.wStaffGender = wStaffGender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_staff.W_S_IDCARD
     *
     * @return the value of w_staff.W_S_IDCARD
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public String getwSIdcard() {
        return wSIdcard;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_staff.W_S_IDCARD
     *
     * @param wSIdcard the value for w_staff.W_S_IDCARD
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public void setwSIdcard(String wSIdcard) {
        this.wSIdcard = wSIdcard;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_staff.W_S_AGE
     *
     * @return the value of w_staff.W_S_AGE
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public Integer getwSAge() {
        return wSAge;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_staff.W_S_AGE
     *
     * @param wSAge the value for w_staff.W_S_AGE
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public void setwSAge(Integer wSAge) {
        this.wSAge = wSAge;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_staff.W_S_WOKER_YEAR
     *
     * @return the value of w_staff.W_S_WOKER_YEAR
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public Integer getwSWokerYear() {
        return wSWokerYear;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_staff.W_S_WOKER_YEAR
     *
     * @param wSWokerYear the value for w_staff.W_S_WOKER_YEAR
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public void setwSWokerYear(Integer wSWokerYear) {
        this.wSWokerYear = wSWokerYear;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_staff.W_S_GRADE
     *
     * @return the value of w_staff.W_S_GRADE
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public Integer getwSGrade() {
        return wSGrade;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_staff.W_S_GRADE
     *
     * @param wSGrade the value for w_staff.W_S_GRADE
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public void setwSGrade(Integer wSGrade) {
        this.wSGrade = wSGrade;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_staff.W_S_SERVICE_TYPE
     *
     * @return the value of w_staff.W_S_SERVICE_TYPE
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public Integer getwSServiceType() {
        return wSServiceType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_staff.W_S_SERVICE_TYPE
     *
     * @param wSServiceType the value for w_staff.W_S_SERVICE_TYPE
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public void setwSServiceType(Integer wSServiceType) {
        this.wSServiceType = wSServiceType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_staff.W_S_TITLE
     *
     * @return the value of w_staff.W_S_TITLE
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public String getwSTitle() {
        return wSTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_staff.W_S_TITLE
     *
     * @param wSTitle the value for w_staff.W_S_TITLE
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public void setwSTitle(String wSTitle) {
        this.wSTitle = wSTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_staff.W_S_SCORE
     *
     * @return the value of w_staff.W_S_SCORE
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public Integer getwSScore() {
        return wSScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_staff.W_S_SCORE
     *
     * @param wSScore the value for w_staff.W_S_SCORE
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public void setwSScore(Integer wSScore) {
        this.wSScore = wSScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_staff.W_S_WORK_COUNT
     *
     * @return the value of w_staff.W_S_WORK_COUNT
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public Integer getwSWorkCount() {
        return wSWorkCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_staff.W_S_WORK_COUNT
     *
     * @param wSWorkCount the value for w_staff.W_S_WORK_COUNT
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public void setwSWorkCount(Integer wSWorkCount) {
        this.wSWorkCount = wSWorkCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_staff.W_S_DESC
     *
     * @return the value of w_staff.W_S_DESC
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public String getwSDesc() {
        return wSDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_staff.W_S_DESC
     *
     * @param wSDesc the value for w_staff.W_S_DESC
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public void setwSDesc(String wSDesc) {
        this.wSDesc = wSDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_staff.W_S_COMPLAINT_COUNT
     *
     * @return the value of w_staff.W_S_COMPLAINT_COUNT
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public Integer getwSComplaintCount() {
        return wSComplaintCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_staff.W_S_COMPLAINT_COUNT
     *
     * @param wSComplaintCount the value for w_staff.W_S_COMPLAINT_COUNT
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public void setwSComplaintCount(Integer wSComplaintCount) {
        this.wSComplaintCount = wSComplaintCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_staff.CREATE_AUTHOR
     *
     * @return the value of w_staff.CREATE_AUTHOR
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public String getCreateAuthor() {
        return createAuthor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_staff.CREATE_AUTHOR
     *
     * @param createAuthor the value for w_staff.CREATE_AUTHOR
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public void setCreateAuthor(String createAuthor) {
        this.createAuthor = createAuthor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_staff.MODIFI_TIME
     *
     * @return the value of w_staff.MODIFI_TIME
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public Date getModifiTime() {
        return modifiTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_staff.MODIFI_TIME
     *
     * @param modifiTime the value for w_staff.MODIFI_TIME
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public void setModifiTime(Date modifiTime) {
        this.modifiTime = modifiTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_staff.MODIFI_AUTHOR
     *
     * @return the value of w_staff.MODIFI_AUTHOR
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public String getModifiAuthor() {
        return modifiAuthor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_staff.MODIFI_AUTHOR
     *
     * @param modifiAuthor the value for w_staff.MODIFI_AUTHOR
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public void setModifiAuthor(String modifiAuthor) {
        this.modifiAuthor = modifiAuthor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_staff.DATALEVEL
     *
     * @return the value of w_staff.DATALEVEL
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public Integer getDatalevel() {
        return datalevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_staff.DATALEVEL
     *
     * @param datalevel the value for w_staff.DATALEVEL
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public void setDatalevel(Integer datalevel) {
        this.datalevel = datalevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_staff.STATUS
     *
     * @return the value of w_staff.STATUS
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_staff.STATUS
     *
     * @param status the value for w_staff.STATUS
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public void setStatus(String status) {
        this.status = status;
    }
}