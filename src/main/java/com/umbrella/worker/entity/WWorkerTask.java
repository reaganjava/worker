package com.umbrella.worker.entity;

import java.math.BigDecimal;
import java.util.Date;

public class WWorkerTask {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_worker_task.ID
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_worker_task.W_W_SUPPLIER
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
     */
    private Integer wWSupplier;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_worker_task.W_W_NAME
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
     */
    private String wWName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_worker_task.W_W_PRICE
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
     */
    private BigDecimal wWPrice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_worker_task.W_W_PRICE_UNIT
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
     */
    private Integer wWPriceUnit;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_worker_task.W_W_TYPE
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
     */
    private Integer wWType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_worker_task.W_W_DESC
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
     */
    private String wWDesc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_worker_task.CREATE_TIME
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_worker_task.CREATE_AUTHOR
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
     */
    private String createAuthor;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_worker_task.MODIFI_TIME
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
     */
    private Date modifiTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_worker_task.MODIFI_AUTHOR
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
     */
    private String modifiAuthor;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_worker_task.DATALEVEL
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
     */
    private Integer datalevel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_worker_task.STATUS
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
     */
    private Integer status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_worker_task.ID
     *
     * @return the value of w_worker_task.ID
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_worker_task.ID
     *
     * @param id the value for w_worker_task.ID
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_worker_task.W_W_SUPPLIER
     *
     * @return the value of w_worker_task.W_W_SUPPLIER
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
     */
    public Integer getwWSupplier() {
        return wWSupplier;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_worker_task.W_W_SUPPLIER
     *
     * @param wWSupplier the value for w_worker_task.W_W_SUPPLIER
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
     */
    public void setwWSupplier(Integer wWSupplier) {
        this.wWSupplier = wWSupplier;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_worker_task.W_W_NAME
     *
     * @return the value of w_worker_task.W_W_NAME
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
     */
    public String getwWName() {
        return wWName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_worker_task.W_W_NAME
     *
     * @param wWName the value for w_worker_task.W_W_NAME
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
     */
    public void setwWName(String wWName) {
        this.wWName = wWName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_worker_task.W_W_PRICE
     *
     * @return the value of w_worker_task.W_W_PRICE
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
     */
    public BigDecimal getwWPrice() {
        return wWPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_worker_task.W_W_PRICE
     *
     * @param wWPrice the value for w_worker_task.W_W_PRICE
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
     */
    public void setwWPrice(BigDecimal wWPrice) {
        this.wWPrice = wWPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_worker_task.W_W_PRICE_UNIT
     *
     * @return the value of w_worker_task.W_W_PRICE_UNIT
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
     */
    public Integer getwWPriceUnit() {
        return wWPriceUnit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_worker_task.W_W_PRICE_UNIT
     *
     * @param wWPriceUnit the value for w_worker_task.W_W_PRICE_UNIT
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
     */
    public void setwWPriceUnit(Integer wWPriceUnit) {
        this.wWPriceUnit = wWPriceUnit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_worker_task.W_W_TYPE
     *
     * @return the value of w_worker_task.W_W_TYPE
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
     */
    public Integer getwWType() {
        return wWType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_worker_task.W_W_TYPE
     *
     * @param wWType the value for w_worker_task.W_W_TYPE
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
     */
    public void setwWType(Integer wWType) {
        this.wWType = wWType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_worker_task.W_W_DESC
     *
     * @return the value of w_worker_task.W_W_DESC
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
     */
    public String getwWDesc() {
        return wWDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_worker_task.W_W_DESC
     *
     * @param wWDesc the value for w_worker_task.W_W_DESC
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
     */
    public void setwWDesc(String wWDesc) {
        this.wWDesc = wWDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_worker_task.CREATE_TIME
     *
     * @return the value of w_worker_task.CREATE_TIME
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_worker_task.CREATE_TIME
     *
     * @param createTime the value for w_worker_task.CREATE_TIME
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_worker_task.CREATE_AUTHOR
     *
     * @return the value of w_worker_task.CREATE_AUTHOR
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
     */
    public String getCreateAuthor() {
        return createAuthor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_worker_task.CREATE_AUTHOR
     *
     * @param createAuthor the value for w_worker_task.CREATE_AUTHOR
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
     */
    public void setCreateAuthor(String createAuthor) {
        this.createAuthor = createAuthor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_worker_task.MODIFI_TIME
     *
     * @return the value of w_worker_task.MODIFI_TIME
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
     */
    public Date getModifiTime() {
        return modifiTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_worker_task.MODIFI_TIME
     *
     * @param modifiTime the value for w_worker_task.MODIFI_TIME
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
     */
    public void setModifiTime(Date modifiTime) {
        this.modifiTime = modifiTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_worker_task.MODIFI_AUTHOR
     *
     * @return the value of w_worker_task.MODIFI_AUTHOR
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
     */
    public String getModifiAuthor() {
        return modifiAuthor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_worker_task.MODIFI_AUTHOR
     *
     * @param modifiAuthor the value for w_worker_task.MODIFI_AUTHOR
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
     */
    public void setModifiAuthor(String modifiAuthor) {
        this.modifiAuthor = modifiAuthor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_worker_task.DATALEVEL
     *
     * @return the value of w_worker_task.DATALEVEL
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
     */
    public Integer getDatalevel() {
        return datalevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_worker_task.DATALEVEL
     *
     * @param datalevel the value for w_worker_task.DATALEVEL
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
     */
    public void setDatalevel(Integer datalevel) {
        this.datalevel = datalevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_worker_task.STATUS
     *
     * @return the value of w_worker_task.STATUS
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_worker_task.STATUS
     *
     * @param status the value for w_worker_task.STATUS
     *
     * @mbggenerated Wed Aug 03 14:05:33 CST 2016
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}