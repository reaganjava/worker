package com.umbrella.worker.entity;

import java.math.BigDecimal;
import java.util.Date;

public class WCoupon {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_coupon.ID
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_coupon.W_C_COUPON_NO
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    private String wCCouponNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_coupon.W_C_TITLE
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    private String wCTitle;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_coupon.W_C_TYPE
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    private Integer wCType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_coupon.W_C_DESC
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    private String wCDesc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_coupon.W_C_ATTAC_ID
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    private Integer wCAttacId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_coupon.W_C_MONEY
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    private BigDecimal wCMoney;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_coupon.W_C_DISCOUNT
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    private Float wCDiscount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_coupon.W_C_BEGIN_TIME
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    private Date wCBeginTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_coupon.W_C_END_TIME
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    private Date wCEndTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_coupon.W_C_PUBLISHI_COUNT
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    private Integer wCPublishiCount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_coupon.W_IS_END
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    private Integer wIsEnd;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_coupon.CREATE_TIME
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_coupon.CREATE_AUTHOR
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    private String createAuthor;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_coupon.MODIFI_TIME
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    private Date modifiTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_coupon.MODIFI_AUTHOR
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    private String modifiAuthor;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_coupon.DATALEVEL
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    private Integer datalevel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_coupon.STATUS
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    private Integer status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_coupon.ID
     *
     * @return the value of w_coupon.ID
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_coupon.ID
     *
     * @param id the value for w_coupon.ID
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_coupon.W_C_COUPON_NO
     *
     * @return the value of w_coupon.W_C_COUPON_NO
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public String getwCCouponNo() {
        return wCCouponNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_coupon.W_C_COUPON_NO
     *
     * @param wCCouponNo the value for w_coupon.W_C_COUPON_NO
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public void setwCCouponNo(String wCCouponNo) {
        this.wCCouponNo = wCCouponNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_coupon.W_C_TITLE
     *
     * @return the value of w_coupon.W_C_TITLE
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public String getwCTitle() {
        return wCTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_coupon.W_C_TITLE
     *
     * @param wCTitle the value for w_coupon.W_C_TITLE
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public void setwCTitle(String wCTitle) {
        this.wCTitle = wCTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_coupon.W_C_TYPE
     *
     * @return the value of w_coupon.W_C_TYPE
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public Integer getwCType() {
        return wCType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_coupon.W_C_TYPE
     *
     * @param wCType the value for w_coupon.W_C_TYPE
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public void setwCType(Integer wCType) {
        this.wCType = wCType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_coupon.W_C_DESC
     *
     * @return the value of w_coupon.W_C_DESC
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public String getwCDesc() {
        return wCDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_coupon.W_C_DESC
     *
     * @param wCDesc the value for w_coupon.W_C_DESC
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public void setwCDesc(String wCDesc) {
        this.wCDesc = wCDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_coupon.W_C_ATTAC_ID
     *
     * @return the value of w_coupon.W_C_ATTAC_ID
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public Integer getwCAttacId() {
        return wCAttacId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_coupon.W_C_ATTAC_ID
     *
     * @param wCAttacId the value for w_coupon.W_C_ATTAC_ID
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public void setwCAttacId(Integer wCAttacId) {
        this.wCAttacId = wCAttacId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_coupon.W_C_MONEY
     *
     * @return the value of w_coupon.W_C_MONEY
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public BigDecimal getwCMoney() {
        return wCMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_coupon.W_C_MONEY
     *
     * @param wCMoney the value for w_coupon.W_C_MONEY
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public void setwCMoney(BigDecimal wCMoney) {
        this.wCMoney = wCMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_coupon.W_C_DISCOUNT
     *
     * @return the value of w_coupon.W_C_DISCOUNT
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public Float getwCDiscount() {
        return wCDiscount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_coupon.W_C_DISCOUNT
     *
     * @param wCDiscount the value for w_coupon.W_C_DISCOUNT
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public void setwCDiscount(Float wCDiscount) {
        this.wCDiscount = wCDiscount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_coupon.W_C_BEGIN_TIME
     *
     * @return the value of w_coupon.W_C_BEGIN_TIME
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public Date getwCBeginTime() {
        return wCBeginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_coupon.W_C_BEGIN_TIME
     *
     * @param wCBeginTime the value for w_coupon.W_C_BEGIN_TIME
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public void setwCBeginTime(Date wCBeginTime) {
        this.wCBeginTime = wCBeginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_coupon.W_C_END_TIME
     *
     * @return the value of w_coupon.W_C_END_TIME
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public Date getwCEndTime() {
        return wCEndTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_coupon.W_C_END_TIME
     *
     * @param wCEndTime the value for w_coupon.W_C_END_TIME
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public void setwCEndTime(Date wCEndTime) {
        this.wCEndTime = wCEndTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_coupon.W_C_PUBLISHI_COUNT
     *
     * @return the value of w_coupon.W_C_PUBLISHI_COUNT
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public Integer getwCPublishiCount() {
        return wCPublishiCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_coupon.W_C_PUBLISHI_COUNT
     *
     * @param wCPublishiCount the value for w_coupon.W_C_PUBLISHI_COUNT
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public void setwCPublishiCount(Integer wCPublishiCount) {
        this.wCPublishiCount = wCPublishiCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_coupon.W_IS_END
     *
     * @return the value of w_coupon.W_IS_END
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public Integer getwIsEnd() {
        return wIsEnd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_coupon.W_IS_END
     *
     * @param wIsEnd the value for w_coupon.W_IS_END
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public void setwIsEnd(Integer wIsEnd) {
        this.wIsEnd = wIsEnd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_coupon.CREATE_TIME
     *
     * @return the value of w_coupon.CREATE_TIME
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_coupon.CREATE_TIME
     *
     * @param createTime the value for w_coupon.CREATE_TIME
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_coupon.CREATE_AUTHOR
     *
     * @return the value of w_coupon.CREATE_AUTHOR
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public String getCreateAuthor() {
        return createAuthor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_coupon.CREATE_AUTHOR
     *
     * @param createAuthor the value for w_coupon.CREATE_AUTHOR
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public void setCreateAuthor(String createAuthor) {
        this.createAuthor = createAuthor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_coupon.MODIFI_TIME
     *
     * @return the value of w_coupon.MODIFI_TIME
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public Date getModifiTime() {
        return modifiTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_coupon.MODIFI_TIME
     *
     * @param modifiTime the value for w_coupon.MODIFI_TIME
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public void setModifiTime(Date modifiTime) {
        this.modifiTime = modifiTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_coupon.MODIFI_AUTHOR
     *
     * @return the value of w_coupon.MODIFI_AUTHOR
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public String getModifiAuthor() {
        return modifiAuthor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_coupon.MODIFI_AUTHOR
     *
     * @param modifiAuthor the value for w_coupon.MODIFI_AUTHOR
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public void setModifiAuthor(String modifiAuthor) {
        this.modifiAuthor = modifiAuthor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_coupon.DATALEVEL
     *
     * @return the value of w_coupon.DATALEVEL
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public Integer getDatalevel() {
        return datalevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_coupon.DATALEVEL
     *
     * @param datalevel the value for w_coupon.DATALEVEL
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public void setDatalevel(Integer datalevel) {
        this.datalevel = datalevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_coupon.STATUS
     *
     * @return the value of w_coupon.STATUS
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_coupon.STATUS
     *
     * @param status the value for w_coupon.STATUS
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}