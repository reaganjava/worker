package com.umbrella.worker.entity;

import java.util.Date;

public class WContact {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_contact.ID
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_contact.W_C_MEMBERS_ID
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    private Integer wCMembersId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_contact.W_C_CONTACT
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    private String wCContact;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_contact.W_C_CITY
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    private String wCCity;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_contact.W_C_DISTRICT
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    private String wCDistrict;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_contact.W_C_TELEPHONE
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    private String wCTelephone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_contact.W_C_ADDRESS
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    private String wCAddress;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_contact.W_C_DEFAULT
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    private Integer wCDefault;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_contact.CREATE_TIME
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_contact.CREATE_AUTHOR
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    private String createAuthor;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_contact.MODIFI_TIME
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    private Date modifiTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_contact.MODIFI_AUTHOR
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    private String modifiAuthor;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_contact.DATALEVEL
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    private Integer datalevel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_contact.STATUS
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    private Integer status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_contact.ID
     *
     * @return the value of w_contact.ID
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_contact.ID
     *
     * @param id the value for w_contact.ID
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_contact.W_C_MEMBERS_ID
     *
     * @return the value of w_contact.W_C_MEMBERS_ID
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public Integer getwCMembersId() {
        return wCMembersId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_contact.W_C_MEMBERS_ID
     *
     * @param wCMembersId the value for w_contact.W_C_MEMBERS_ID
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public void setwCMembersId(Integer wCMembersId) {
        this.wCMembersId = wCMembersId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_contact.W_C_CONTACT
     *
     * @return the value of w_contact.W_C_CONTACT
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public String getwCContact() {
        return wCContact;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_contact.W_C_CONTACT
     *
     * @param wCContact the value for w_contact.W_C_CONTACT
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public void setwCContact(String wCContact) {
        this.wCContact = wCContact;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_contact.W_C_CITY
     *
     * @return the value of w_contact.W_C_CITY
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public String getwCCity() {
        return wCCity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_contact.W_C_CITY
     *
     * @param wCCity the value for w_contact.W_C_CITY
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public void setwCCity(String wCCity) {
        this.wCCity = wCCity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_contact.W_C_DISTRICT
     *
     * @return the value of w_contact.W_C_DISTRICT
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public String getwCDistrict() {
        return wCDistrict;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_contact.W_C_DISTRICT
     *
     * @param wCDistrict the value for w_contact.W_C_DISTRICT
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public void setwCDistrict(String wCDistrict) {
        this.wCDistrict = wCDistrict;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_contact.W_C_TELEPHONE
     *
     * @return the value of w_contact.W_C_TELEPHONE
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public String getwCTelephone() {
        return wCTelephone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_contact.W_C_TELEPHONE
     *
     * @param wCTelephone the value for w_contact.W_C_TELEPHONE
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public void setwCTelephone(String wCTelephone) {
        this.wCTelephone = wCTelephone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_contact.W_C_ADDRESS
     *
     * @return the value of w_contact.W_C_ADDRESS
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public String getwCAddress() {
        return wCAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_contact.W_C_ADDRESS
     *
     * @param wCAddress the value for w_contact.W_C_ADDRESS
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public void setwCAddress(String wCAddress) {
        this.wCAddress = wCAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_contact.W_C_DEFAULT
     *
     * @return the value of w_contact.W_C_DEFAULT
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public Integer getwCDefault() {
        return wCDefault;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_contact.W_C_DEFAULT
     *
     * @param wCDefault the value for w_contact.W_C_DEFAULT
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public void setwCDefault(Integer wCDefault) {
        this.wCDefault = wCDefault;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_contact.CREATE_TIME
     *
     * @return the value of w_contact.CREATE_TIME
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_contact.CREATE_TIME
     *
     * @param createTime the value for w_contact.CREATE_TIME
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_contact.CREATE_AUTHOR
     *
     * @return the value of w_contact.CREATE_AUTHOR
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public String getCreateAuthor() {
        return createAuthor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_contact.CREATE_AUTHOR
     *
     * @param createAuthor the value for w_contact.CREATE_AUTHOR
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public void setCreateAuthor(String createAuthor) {
        this.createAuthor = createAuthor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_contact.MODIFI_TIME
     *
     * @return the value of w_contact.MODIFI_TIME
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public Date getModifiTime() {
        return modifiTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_contact.MODIFI_TIME
     *
     * @param modifiTime the value for w_contact.MODIFI_TIME
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public void setModifiTime(Date modifiTime) {
        this.modifiTime = modifiTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_contact.MODIFI_AUTHOR
     *
     * @return the value of w_contact.MODIFI_AUTHOR
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public String getModifiAuthor() {
        return modifiAuthor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_contact.MODIFI_AUTHOR
     *
     * @param modifiAuthor the value for w_contact.MODIFI_AUTHOR
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public void setModifiAuthor(String modifiAuthor) {
        this.modifiAuthor = modifiAuthor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_contact.DATALEVEL
     *
     * @return the value of w_contact.DATALEVEL
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public Integer getDatalevel() {
        return datalevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_contact.DATALEVEL
     *
     * @param datalevel the value for w_contact.DATALEVEL
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public void setDatalevel(Integer datalevel) {
        this.datalevel = datalevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_contact.STATUS
     *
     * @return the value of w_contact.STATUS
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_contact.STATUS
     *
     * @param status the value for w_contact.STATUS
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}