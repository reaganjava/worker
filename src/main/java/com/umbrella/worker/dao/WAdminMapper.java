package com.umbrella.worker.dao;

import com.umbrella.worker.entity.WAdmin;
import com.umbrella.worker.entity.WAdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WAdminMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_admin
     *
     * @mbggenerated Mon Aug 01 14:02:47 CST 2016
     */
    int countByExample(WAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_admin
     *
     * @mbggenerated Mon Aug 01 14:02:47 CST 2016
     */
    int deleteByExample(WAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_admin
     *
     * @mbggenerated Mon Aug 01 14:02:47 CST 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_admin
     *
     * @mbggenerated Mon Aug 01 14:02:47 CST 2016
     */
    int insert(WAdmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_admin
     *
     * @mbggenerated Mon Aug 01 14:02:47 CST 2016
     */
    int insertSelective(WAdmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_admin
     *
     * @mbggenerated Mon Aug 01 14:02:47 CST 2016
     */
    List<WAdmin> selectByExample(WAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_admin
     *
     * @mbggenerated Mon Aug 01 14:02:47 CST 2016
     */
    WAdmin selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_admin
     *
     * @mbggenerated Mon Aug 01 14:02:47 CST 2016
     */
    int updateByExampleSelective(@Param("record") WAdmin record, @Param("example") WAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_admin
     *
     * @mbggenerated Mon Aug 01 14:02:47 CST 2016
     */
    int updateByExample(@Param("record") WAdmin record, @Param("example") WAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_admin
     *
     * @mbggenerated Mon Aug 01 14:02:47 CST 2016
     */
    int updateByPrimaryKeySelective(WAdmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_admin
     *
     * @mbggenerated Mon Aug 01 14:02:47 CST 2016
     */
    int updateByPrimaryKey(WAdmin record);
}