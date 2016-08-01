package com.umbrella.worker.dao;

import com.umbrella.worker.entity.WStaff;
import com.umbrella.worker.entity.WStaffExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WStaffMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_staff
     *
     * @mbggenerated Mon Aug 01 14:02:47 CST 2016
     */
    int countByExample(WStaffExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_staff
     *
     * @mbggenerated Mon Aug 01 14:02:47 CST 2016
     */
    int deleteByExample(WStaffExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_staff
     *
     * @mbggenerated Mon Aug 01 14:02:47 CST 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_staff
     *
     * @mbggenerated Mon Aug 01 14:02:47 CST 2016
     */
    int insert(WStaff record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_staff
     *
     * @mbggenerated Mon Aug 01 14:02:47 CST 2016
     */
    int insertSelective(WStaff record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_staff
     *
     * @mbggenerated Mon Aug 01 14:02:47 CST 2016
     */
    List<WStaff> selectByExample(WStaffExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_staff
     *
     * @mbggenerated Mon Aug 01 14:02:47 CST 2016
     */
    WStaff selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_staff
     *
     * @mbggenerated Mon Aug 01 14:02:47 CST 2016
     */
    int updateByExampleSelective(@Param("record") WStaff record, @Param("example") WStaffExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_staff
     *
     * @mbggenerated Mon Aug 01 14:02:47 CST 2016
     */
    int updateByExample(@Param("record") WStaff record, @Param("example") WStaffExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_staff
     *
     * @mbggenerated Mon Aug 01 14:02:47 CST 2016
     */
    int updateByPrimaryKeySelective(WStaff record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_staff
     *
     * @mbggenerated Mon Aug 01 14:02:47 CST 2016
     */
    int updateByPrimaryKey(WStaff record);
}