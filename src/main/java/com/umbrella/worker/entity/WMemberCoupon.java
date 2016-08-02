package com.umbrella.worker.entity;

import java.util.Date;

public class WMemberCoupon {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_member_coupon.ID
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_member_coupon.W_MC_MEMBER_ID
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    private Integer wMcMemberId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_member_coupon.W_MC_COUPON_ID
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    private Integer wMcCouponId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_member_coupon.W_MC_COUPON_TITLE
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    private String wMcCouponTitle;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_member_coupon.W_MC_COUPON_TYPE
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    private Integer wMcCouponType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_member_coupon.W_MC_USE_DATE
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    private Date wMcUseDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_member_coupon.CREATE_TIME
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_member_coupon.CREATE_AUTHOR
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    private String createAuthor;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_member_coupon.MODIFI_TIME
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    private Date modifiTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_member_coupon.MODIFI_AUTHOR
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    private String modifiAuthor;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_member_coupon.DATALEVEL
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    private Integer datalevel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_member_coupon.STATUS
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    private Integer status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_member_coupon.ID
     *
     * @return the value of w_member_coupon.ID
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_member_coupon.ID
     *
     * @param id the value for w_member_coupon.ID
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_member_coupon.W_MC_MEMBER_ID
     *
     * @return the value of w_member_coupon.W_MC_MEMBER_ID
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public Integer getwMcMemberId() {
        return wMcMemberId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_member_coupon.W_MC_MEMBER_ID
     *
     * @param wMcMemberId the value for w_member_coupon.W_MC_MEMBER_ID
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public void setwMcMemberId(Integer wMcMemberId) {
        this.wMcMemberId = wMcMemberId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_member_coupon.W_MC_COUPON_ID
     *
     * @return the value of w_member_coupon.W_MC_COUPON_ID
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public Integer getwMcCouponId() {
        return wMcCouponId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_member_coupon.W_MC_COUPON_ID
     *
     * @param wMcCouponId the value for w_member_coupon.W_MC_COUPON_ID
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public void setwMcCouponId(Integer wMcCouponId) {
        this.wMcCouponId = wMcCouponId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_member_coupon.W_MC_COUPON_TITLE
     *
     * @return the value of w_member_coupon.W_MC_COUPON_TITLE
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public String getwMcCouponTitle() {
        return wMcCouponTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_member_coupon.W_MC_COUPON_TITLE
     *
     * @param wMcCouponTitle the value for w_member_coupon.W_MC_COUPON_TITLE
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public void setwMcCouponTitle(String wMcCouponTitle) {
        this.wMcCouponTitle = wMcCouponTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_member_coupon.W_MC_COUPON_TYPE
     *
     * @return the value of w_member_coupon.W_MC_COUPON_TYPE
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public Integer getwMcCouponType() {
        return wMcCouponType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_member_coupon.W_MC_COUPON_TYPE
     *
     * @param wMcCouponType the value for w_member_coupon.W_MC_COUPON_TYPE
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public void setwMcCouponType(Integer wMcCouponType) {
        this.wMcCouponType = wMcCouponType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_member_coupon.W_MC_USE_DATE
     *
     * @return the value of w_member_coupon.W_MC_USE_DATE
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public Date getwMcUseDate() {
        return wMcUseDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_member_coupon.W_MC_USE_DATE
     *
     * @param wMcUseDate the value for w_member_coupon.W_MC_USE_DATE
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public void setwMcUseDate(Date wMcUseDate) {
        this.wMcUseDate = wMcUseDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_member_coupon.CREATE_TIME
     *
     * @return the value of w_member_coupon.CREATE_TIME
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_member_coupon.CREATE_TIME
     *
     * @param createTime the value for w_member_coupon.CREATE_TIME
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_member_coupon.CREATE_AUTHOR
     *
     * @return the value of w_member_coupon.CREATE_AUTHOR
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public String getCreateAuthor() {
        return createAuthor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_member_coupon.CREATE_AUTHOR
     *
     * @param createAuthor the value for w_member_coupon.CREATE_AUTHOR
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public void setCreateAuthor(String createAuthor) {
        this.createAuthor = createAuthor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_member_coupon.MODIFI_TIME
     *
     * @return the value of w_member_coupon.MODIFI_TIME
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public Date getModifiTime() {
        return modifiTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_member_coupon.MODIFI_TIME
     *
     * @param modifiTime the value for w_member_coupon.MODIFI_TIME
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public void setModifiTime(Date modifiTime) {
        this.modifiTime = modifiTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_member_coupon.MODIFI_AUTHOR
     *
     * @return the value of w_member_coupon.MODIFI_AUTHOR
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public String getModifiAuthor() {
        return modifiAuthor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_member_coupon.MODIFI_AUTHOR
     *
     * @param modifiAuthor the value for w_member_coupon.MODIFI_AUTHOR
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public void setModifiAuthor(String modifiAuthor) {
        this.modifiAuthor = modifiAuthor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_member_coupon.DATALEVEL
     *
     * @return the value of w_member_coupon.DATALEVEL
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public Integer getDatalevel() {
        return datalevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_member_coupon.DATALEVEL
     *
     * @param datalevel the value for w_member_coupon.DATALEVEL
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public void setDatalevel(Integer datalevel) {
        this.datalevel = datalevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_member_coupon.STATUS
     *
     * @return the value of w_member_coupon.STATUS
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_member_coupon.STATUS
     *
     * @param status the value for w_member_coupon.STATUS
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}