package com.umbrella.worker.entity;

import java.math.BigDecimal;
import java.util.Date;

public class WSupplierAccount {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_supplier_account.ID
     *
     * @mbggenerated Tue Sep 20 05:56:16 CST 2016
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_supplier_account.W_SUPPLIER_ID
     *
     * @mbggenerated Tue Sep 20 05:56:16 CST 2016
     */
    private Integer wSupplierId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_supplier_account.W_A_BALANCE
     *
     * @mbggenerated Tue Sep 20 05:56:16 CST 2016
     */
    private BigDecimal wABalance;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_supplier_account.W_A_LAST_WITHDRAW
     *
     * @mbggenerated Tue Sep 20 05:56:16 CST 2016
     */
    private BigDecimal wALastWithdraw;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_supplier_account.W_A_LAST_WITHDRAW_DATE
     *
     * @mbggenerated Tue Sep 20 05:56:16 CST 2016
     */
    private Date wALastWithdrawDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_supplier_account.W_A_LAST_SAVE
     *
     * @mbggenerated Tue Sep 20 05:56:16 CST 2016
     */
    private BigDecimal wALastSave;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_supplier_account.W_A_LAST_SAVE_DATE
     *
     * @mbggenerated Tue Sep 20 05:56:16 CST 2016
     */
    private Date wALastSaveDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_supplier_account.CREATE_TIME
     *
     * @mbggenerated Tue Sep 20 05:56:16 CST 2016
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_supplier_account.CREATE_AUTHOR
     *
     * @mbggenerated Tue Sep 20 05:56:16 CST 2016
     */
    private String createAuthor;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_supplier_account.MODIFI_TIME
     *
     * @mbggenerated Tue Sep 20 05:56:16 CST 2016
     */
    private Date modifiTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_supplier_account.MODIFI_AUTHOR
     *
     * @mbggenerated Tue Sep 20 05:56:16 CST 2016
     */
    private String modifiAuthor;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_supplier_account.DATALEVEL
     *
     * @mbggenerated Tue Sep 20 05:56:16 CST 2016
     */
    private Integer datalevel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_supplier_account.STATUS
     *
     * @mbggenerated Tue Sep 20 05:56:16 CST 2016
     */
    private Integer status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_supplier_account.ID
     *
     * @return the value of w_supplier_account.ID
     *
     * @mbggenerated Tue Sep 20 05:56:16 CST 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_supplier_account.ID
     *
     * @param id the value for w_supplier_account.ID
     *
     * @mbggenerated Tue Sep 20 05:56:16 CST 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_supplier_account.W_SUPPLIER_ID
     *
     * @return the value of w_supplier_account.W_SUPPLIER_ID
     *
     * @mbggenerated Tue Sep 20 05:56:16 CST 2016
     */
    public Integer getwSupplierId() {
        return wSupplierId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_supplier_account.W_SUPPLIER_ID
     *
     * @param wSupplierId the value for w_supplier_account.W_SUPPLIER_ID
     *
     * @mbggenerated Tue Sep 20 05:56:16 CST 2016
     */
    public void setwSupplierId(Integer wSupplierId) {
        this.wSupplierId = wSupplierId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_supplier_account.W_A_BALANCE
     *
     * @return the value of w_supplier_account.W_A_BALANCE
     *
     * @mbggenerated Tue Sep 20 05:56:16 CST 2016
     */
    public BigDecimal getwABalance() {
        return wABalance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_supplier_account.W_A_BALANCE
     *
     * @param wABalance the value for w_supplier_account.W_A_BALANCE
     *
     * @mbggenerated Tue Sep 20 05:56:16 CST 2016
     */
    public void setwABalance(BigDecimal wABalance) {
        this.wABalance = wABalance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_supplier_account.W_A_LAST_WITHDRAW
     *
     * @return the value of w_supplier_account.W_A_LAST_WITHDRAW
     *
     * @mbggenerated Tue Sep 20 05:56:16 CST 2016
     */
    public BigDecimal getwALastWithdraw() {
        return wALastWithdraw;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_supplier_account.W_A_LAST_WITHDRAW
     *
     * @param wALastWithdraw the value for w_supplier_account.W_A_LAST_WITHDRAW
     *
     * @mbggenerated Tue Sep 20 05:56:16 CST 2016
     */
    public void setwALastWithdraw(BigDecimal wALastWithdraw) {
        this.wALastWithdraw = wALastWithdraw;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_supplier_account.W_A_LAST_WITHDRAW_DATE
     *
     * @return the value of w_supplier_account.W_A_LAST_WITHDRAW_DATE
     *
     * @mbggenerated Tue Sep 20 05:56:16 CST 2016
     */
    public Date getwALastWithdrawDate() {
        return wALastWithdrawDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_supplier_account.W_A_LAST_WITHDRAW_DATE
     *
     * @param wALastWithdrawDate the value for w_supplier_account.W_A_LAST_WITHDRAW_DATE
     *
     * @mbggenerated Tue Sep 20 05:56:16 CST 2016
     */
    public void setwALastWithdrawDate(Date wALastWithdrawDate) {
        this.wALastWithdrawDate = wALastWithdrawDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_supplier_account.W_A_LAST_SAVE
     *
     * @return the value of w_supplier_account.W_A_LAST_SAVE
     *
     * @mbggenerated Tue Sep 20 05:56:16 CST 2016
     */
    public BigDecimal getwALastSave() {
        return wALastSave;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_supplier_account.W_A_LAST_SAVE
     *
     * @param wALastSave the value for w_supplier_account.W_A_LAST_SAVE
     *
     * @mbggenerated Tue Sep 20 05:56:16 CST 2016
     */
    public void setwALastSave(BigDecimal wALastSave) {
        this.wALastSave = wALastSave;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_supplier_account.W_A_LAST_SAVE_DATE
     *
     * @return the value of w_supplier_account.W_A_LAST_SAVE_DATE
     *
     * @mbggenerated Tue Sep 20 05:56:16 CST 2016
     */
    public Date getwALastSaveDate() {
        return wALastSaveDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_supplier_account.W_A_LAST_SAVE_DATE
     *
     * @param wALastSaveDate the value for w_supplier_account.W_A_LAST_SAVE_DATE
     *
     * @mbggenerated Tue Sep 20 05:56:16 CST 2016
     */
    public void setwALastSaveDate(Date wALastSaveDate) {
        this.wALastSaveDate = wALastSaveDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_supplier_account.CREATE_TIME
     *
     * @return the value of w_supplier_account.CREATE_TIME
     *
     * @mbggenerated Tue Sep 20 05:56:16 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_supplier_account.CREATE_TIME
     *
     * @param createTime the value for w_supplier_account.CREATE_TIME
     *
     * @mbggenerated Tue Sep 20 05:56:16 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_supplier_account.CREATE_AUTHOR
     *
     * @return the value of w_supplier_account.CREATE_AUTHOR
     *
     * @mbggenerated Tue Sep 20 05:56:16 CST 2016
     */
    public String getCreateAuthor() {
        return createAuthor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_supplier_account.CREATE_AUTHOR
     *
     * @param createAuthor the value for w_supplier_account.CREATE_AUTHOR
     *
     * @mbggenerated Tue Sep 20 05:56:16 CST 2016
     */
    public void setCreateAuthor(String createAuthor) {
        this.createAuthor = createAuthor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_supplier_account.MODIFI_TIME
     *
     * @return the value of w_supplier_account.MODIFI_TIME
     *
     * @mbggenerated Tue Sep 20 05:56:16 CST 2016
     */
    public Date getModifiTime() {
        return modifiTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_supplier_account.MODIFI_TIME
     *
     * @param modifiTime the value for w_supplier_account.MODIFI_TIME
     *
     * @mbggenerated Tue Sep 20 05:56:16 CST 2016
     */
    public void setModifiTime(Date modifiTime) {
        this.modifiTime = modifiTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_supplier_account.MODIFI_AUTHOR
     *
     * @return the value of w_supplier_account.MODIFI_AUTHOR
     *
     * @mbggenerated Tue Sep 20 05:56:16 CST 2016
     */
    public String getModifiAuthor() {
        return modifiAuthor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_supplier_account.MODIFI_AUTHOR
     *
     * @param modifiAuthor the value for w_supplier_account.MODIFI_AUTHOR
     *
     * @mbggenerated Tue Sep 20 05:56:16 CST 2016
     */
    public void setModifiAuthor(String modifiAuthor) {
        this.modifiAuthor = modifiAuthor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_supplier_account.DATALEVEL
     *
     * @return the value of w_supplier_account.DATALEVEL
     *
     * @mbggenerated Tue Sep 20 05:56:16 CST 2016
     */
    public Integer getDatalevel() {
        return datalevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_supplier_account.DATALEVEL
     *
     * @param datalevel the value for w_supplier_account.DATALEVEL
     *
     * @mbggenerated Tue Sep 20 05:56:16 CST 2016
     */
    public void setDatalevel(Integer datalevel) {
        this.datalevel = datalevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_supplier_account.STATUS
     *
     * @return the value of w_supplier_account.STATUS
     *
     * @mbggenerated Tue Sep 20 05:56:16 CST 2016
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_supplier_account.STATUS
     *
     * @param status the value for w_supplier_account.STATUS
     *
     * @mbggenerated Tue Sep 20 05:56:16 CST 2016
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}