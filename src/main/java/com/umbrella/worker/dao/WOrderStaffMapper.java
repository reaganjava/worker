package com.umbrella.worker.dao;

import com.umbrella.worker.entity.WOrderStaff;
import com.umbrella.worker.entity.WOrderStaffExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WOrderStaffMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_order_staff
     *
     * @mbggenerated Mon Aug 01 14:02:47 CST 2016
     */
    int countByExample(WOrderStaffExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_order_staff
     *
     * @mbggenerated Mon Aug 01 14:02:47 CST 2016
     */
    int deleteByExample(WOrderStaffExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_order_staff
     *
     * @mbggenerated Mon Aug 01 14:02:47 CST 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_order_staff
     *
     * @mbggenerated Mon Aug 01 14:02:47 CST 2016
     */
    int insert(WOrderStaff record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_order_staff
     *
     * @mbggenerated Mon Aug 01 14:02:47 CST 2016
     */
    int insertSelective(WOrderStaff record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_order_staff
     *
     * @mbggenerated Mon Aug 01 14:02:47 CST 2016
     */
    List<WOrderStaff> selectByExample(WOrderStaffExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_order_staff
     *
     * @mbggenerated Mon Aug 01 14:02:47 CST 2016
     */
    WOrderStaff selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_order_staff
     *
     * @mbggenerated Mon Aug 01 14:02:47 CST 2016
     */
    int updateByExampleSelective(@Param("record") WOrderStaff record, @Param("example") WOrderStaffExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_order_staff
     *
     * @mbggenerated Mon Aug 01 14:02:47 CST 2016
     */
    int updateByExample(@Param("record") WOrderStaff record, @Param("example") WOrderStaffExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_order_staff
     *
     * @mbggenerated Mon Aug 01 14:02:47 CST 2016
     */
    int updateByPrimaryKeySelective(WOrderStaff record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_order_staff
     *
     * @mbggenerated Mon Aug 01 14:02:47 CST 2016
     */
    int updateByPrimaryKey(WOrderStaff record);
}