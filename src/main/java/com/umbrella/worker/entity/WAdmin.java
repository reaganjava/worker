package com.umbrella.worker.entity;

import java.util.Date;

public class WAdmin {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_admin.ID
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_admin.W_A_SUPPLIER_ID
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    private Integer wASupplierId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_admin.W_A_USERNAME
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    private String wAUsername;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_admin.W_A_PASSWORD
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    private String wAPassword;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_admin.W_A_REAL_NAME
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    private String wARealName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_admin.W_A_TELEPHONE
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    private String wATelephone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_admin.W_A_ROLE_ID
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    private Integer wARoleId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_admin.W_A_LAST_LOG_TIME
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    private Date wALastLogTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_admin.W_A_LOGIN_IP
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    private String wALoginIp;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_admin.CREATE_TIME
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_admin.CREATE_AUTHOR
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    private String createAuthor;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_admin.MODIFI_TIME
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    private Date modifiTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_admin.MODIFI_AUTHOR
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    private String modifiAuthor;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_admin.DATALEVEL
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    private Integer datalevel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_admin.STATUS
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    private Integer status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_admin.ID
     *
     * @return the value of w_admin.ID
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_admin.ID
     *
     * @param id the value for w_admin.ID
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_admin.W_A_SUPPLIER_ID
     *
     * @return the value of w_admin.W_A_SUPPLIER_ID
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public Integer getwASupplierId() {
        return wASupplierId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_admin.W_A_SUPPLIER_ID
     *
     * @param wASupplierId the value for w_admin.W_A_SUPPLIER_ID
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public void setwASupplierId(Integer wASupplierId) {
        this.wASupplierId = wASupplierId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_admin.W_A_USERNAME
     *
     * @return the value of w_admin.W_A_USERNAME
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public String getwAUsername() {
        return wAUsername;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_admin.W_A_USERNAME
     *
     * @param wAUsername the value for w_admin.W_A_USERNAME
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public void setwAUsername(String wAUsername) {
        this.wAUsername = wAUsername;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_admin.W_A_PASSWORD
     *
     * @return the value of w_admin.W_A_PASSWORD
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public String getwAPassword() {
        return wAPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_admin.W_A_PASSWORD
     *
     * @param wAPassword the value for w_admin.W_A_PASSWORD
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public void setwAPassword(String wAPassword) {
        this.wAPassword = wAPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_admin.W_A_REAL_NAME
     *
     * @return the value of w_admin.W_A_REAL_NAME
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public String getwARealName() {
        return wARealName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_admin.W_A_REAL_NAME
     *
     * @param wARealName the value for w_admin.W_A_REAL_NAME
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public void setwARealName(String wARealName) {
        this.wARealName = wARealName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_admin.W_A_TELEPHONE
     *
     * @return the value of w_admin.W_A_TELEPHONE
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public String getwATelephone() {
        return wATelephone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_admin.W_A_TELEPHONE
     *
     * @param wATelephone the value for w_admin.W_A_TELEPHONE
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public void setwATelephone(String wATelephone) {
        this.wATelephone = wATelephone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_admin.W_A_ROLE_ID
     *
     * @return the value of w_admin.W_A_ROLE_ID
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public Integer getwARoleId() {
        return wARoleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_admin.W_A_ROLE_ID
     *
     * @param wARoleId the value for w_admin.W_A_ROLE_ID
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public void setwARoleId(Integer wARoleId) {
        this.wARoleId = wARoleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_admin.W_A_LAST_LOG_TIME
     *
     * @return the value of w_admin.W_A_LAST_LOG_TIME
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public Date getwALastLogTime() {
        return wALastLogTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_admin.W_A_LAST_LOG_TIME
     *
     * @param wALastLogTime the value for w_admin.W_A_LAST_LOG_TIME
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public void setwALastLogTime(Date wALastLogTime) {
        this.wALastLogTime = wALastLogTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_admin.W_A_LOGIN_IP
     *
     * @return the value of w_admin.W_A_LOGIN_IP
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public String getwALoginIp() {
        return wALoginIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_admin.W_A_LOGIN_IP
     *
     * @param wALoginIp the value for w_admin.W_A_LOGIN_IP
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public void setwALoginIp(String wALoginIp) {
        this.wALoginIp = wALoginIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_admin.CREATE_TIME
     *
     * @return the value of w_admin.CREATE_TIME
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_admin.CREATE_TIME
     *
     * @param createTime the value for w_admin.CREATE_TIME
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_admin.CREATE_AUTHOR
     *
     * @return the value of w_admin.CREATE_AUTHOR
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public String getCreateAuthor() {
        return createAuthor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_admin.CREATE_AUTHOR
     *
     * @param createAuthor the value for w_admin.CREATE_AUTHOR
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public void setCreateAuthor(String createAuthor) {
        this.createAuthor = createAuthor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_admin.MODIFI_TIME
     *
     * @return the value of w_admin.MODIFI_TIME
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public Date getModifiTime() {
        return modifiTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_admin.MODIFI_TIME
     *
     * @param modifiTime the value for w_admin.MODIFI_TIME
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public void setModifiTime(Date modifiTime) {
        this.modifiTime = modifiTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_admin.MODIFI_AUTHOR
     *
     * @return the value of w_admin.MODIFI_AUTHOR
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public String getModifiAuthor() {
        return modifiAuthor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_admin.MODIFI_AUTHOR
     *
     * @param modifiAuthor the value for w_admin.MODIFI_AUTHOR
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public void setModifiAuthor(String modifiAuthor) {
        this.modifiAuthor = modifiAuthor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_admin.DATALEVEL
     *
     * @return the value of w_admin.DATALEVEL
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public Integer getDatalevel() {
        return datalevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_admin.DATALEVEL
     *
     * @param datalevel the value for w_admin.DATALEVEL
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public void setDatalevel(Integer datalevel) {
        this.datalevel = datalevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_admin.STATUS
     *
     * @return the value of w_admin.STATUS
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_admin.STATUS
     *
     * @param status the value for w_admin.STATUS
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}