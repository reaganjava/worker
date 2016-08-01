package com.umbrella.worker.entity;

import java.math.BigDecimal;
import java.util.Date;

public class WOrder {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_order.ID
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_order.W_O_MEMBERS_ID
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    private Integer wOMembersId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_order.W_O_SUPPLIER_ID
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    private Integer wOSupplierId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_order.W_O_ORDER_NO
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    private String wOOrderNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_order.W_O_PAY_TYPE
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    private Integer wOPayType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_order.W_O_FEE
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    private BigDecimal wOFee;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_order.W_O_IS_END
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    private Integer wOIsEnd;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_order.W_O_IS_CONFIM
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    private Integer wOIsConfim;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_order.W_O_IS_PAY
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    private Integer wOIsPay;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_order.CREATE_AUTHOR
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    private String createAuthor;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_order.MODIFI_TIME
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    private Date modifiTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_order.MODIFI_AUTHOR
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    private String modifiAuthor;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_order.DATALEVEL
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    private Integer datalevel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_order.STATUS
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    private Integer status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_order.ID
     *
     * @return the value of w_order.ID
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_order.ID
     *
     * @param id the value for w_order.ID
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_order.W_O_MEMBERS_ID
     *
     * @return the value of w_order.W_O_MEMBERS_ID
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public Integer getwOMembersId() {
        return wOMembersId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_order.W_O_MEMBERS_ID
     *
     * @param wOMembersId the value for w_order.W_O_MEMBERS_ID
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public void setwOMembersId(Integer wOMembersId) {
        this.wOMembersId = wOMembersId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_order.W_O_SUPPLIER_ID
     *
     * @return the value of w_order.W_O_SUPPLIER_ID
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public Integer getwOSupplierId() {
        return wOSupplierId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_order.W_O_SUPPLIER_ID
     *
     * @param wOSupplierId the value for w_order.W_O_SUPPLIER_ID
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public void setwOSupplierId(Integer wOSupplierId) {
        this.wOSupplierId = wOSupplierId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_order.W_O_ORDER_NO
     *
     * @return the value of w_order.W_O_ORDER_NO
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public String getwOOrderNo() {
        return wOOrderNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_order.W_O_ORDER_NO
     *
     * @param wOOrderNo the value for w_order.W_O_ORDER_NO
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public void setwOOrderNo(String wOOrderNo) {
        this.wOOrderNo = wOOrderNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_order.W_O_PAY_TYPE
     *
     * @return the value of w_order.W_O_PAY_TYPE
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public Integer getwOPayType() {
        return wOPayType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_order.W_O_PAY_TYPE
     *
     * @param wOPayType the value for w_order.W_O_PAY_TYPE
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public void setwOPayType(Integer wOPayType) {
        this.wOPayType = wOPayType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_order.W_O_FEE
     *
     * @return the value of w_order.W_O_FEE
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public BigDecimal getwOFee() {
        return wOFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_order.W_O_FEE
     *
     * @param wOFee the value for w_order.W_O_FEE
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public void setwOFee(BigDecimal wOFee) {
        this.wOFee = wOFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_order.W_O_IS_END
     *
     * @return the value of w_order.W_O_IS_END
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public Integer getwOIsEnd() {
        return wOIsEnd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_order.W_O_IS_END
     *
     * @param wOIsEnd the value for w_order.W_O_IS_END
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public void setwOIsEnd(Integer wOIsEnd) {
        this.wOIsEnd = wOIsEnd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_order.W_O_IS_CONFIM
     *
     * @return the value of w_order.W_O_IS_CONFIM
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public Integer getwOIsConfim() {
        return wOIsConfim;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_order.W_O_IS_CONFIM
     *
     * @param wOIsConfim the value for w_order.W_O_IS_CONFIM
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public void setwOIsConfim(Integer wOIsConfim) {
        this.wOIsConfim = wOIsConfim;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_order.W_O_IS_PAY
     *
     * @return the value of w_order.W_O_IS_PAY
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public Integer getwOIsPay() {
        return wOIsPay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_order.W_O_IS_PAY
     *
     * @param wOIsPay the value for w_order.W_O_IS_PAY
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public void setwOIsPay(Integer wOIsPay) {
        this.wOIsPay = wOIsPay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_order.CREATE_AUTHOR
     *
     * @return the value of w_order.CREATE_AUTHOR
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public String getCreateAuthor() {
        return createAuthor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_order.CREATE_AUTHOR
     *
     * @param createAuthor the value for w_order.CREATE_AUTHOR
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public void setCreateAuthor(String createAuthor) {
        this.createAuthor = createAuthor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_order.MODIFI_TIME
     *
     * @return the value of w_order.MODIFI_TIME
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public Date getModifiTime() {
        return modifiTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_order.MODIFI_TIME
     *
     * @param modifiTime the value for w_order.MODIFI_TIME
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public void setModifiTime(Date modifiTime) {
        this.modifiTime = modifiTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_order.MODIFI_AUTHOR
     *
     * @return the value of w_order.MODIFI_AUTHOR
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public String getModifiAuthor() {
        return modifiAuthor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_order.MODIFI_AUTHOR
     *
     * @param modifiAuthor the value for w_order.MODIFI_AUTHOR
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public void setModifiAuthor(String modifiAuthor) {
        this.modifiAuthor = modifiAuthor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_order.DATALEVEL
     *
     * @return the value of w_order.DATALEVEL
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public Integer getDatalevel() {
        return datalevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_order.DATALEVEL
     *
     * @param datalevel the value for w_order.DATALEVEL
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public void setDatalevel(Integer datalevel) {
        this.datalevel = datalevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_order.STATUS
     *
     * @return the value of w_order.STATUS
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_order.STATUS
     *
     * @param status the value for w_order.STATUS
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}