package com.umbrella.worker.entity;

public class WOrderStaff {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_order_staff.ID
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_order_staff.W_ORDER_DETAIL_ID
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    private Integer wOrderDetailId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_order_staff.W_STAFF_ID
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    private Integer wStaffId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_order_staff.ID
     *
     * @return the value of w_order_staff.ID
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_order_staff.ID
     *
     * @param id the value for w_order_staff.ID
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_order_staff.W_ORDER_DETAIL_ID
     *
     * @return the value of w_order_staff.W_ORDER_DETAIL_ID
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public Integer getwOrderDetailId() {
        return wOrderDetailId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_order_staff.W_ORDER_DETAIL_ID
     *
     * @param wOrderDetailId the value for w_order_staff.W_ORDER_DETAIL_ID
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public void setwOrderDetailId(Integer wOrderDetailId) {
        this.wOrderDetailId = wOrderDetailId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_order_staff.W_STAFF_ID
     *
     * @return the value of w_order_staff.W_STAFF_ID
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public Integer getwStaffId() {
        return wStaffId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_order_staff.W_STAFF_ID
     *
     * @param wStaffId the value for w_order_staff.W_STAFF_ID
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    public void setwStaffId(Integer wStaffId) {
        this.wStaffId = wStaffId;
    }
}