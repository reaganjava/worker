package com.umbrella.worker.dao;

import com.umbrella.worker.entity.WContact;
import com.umbrella.worker.entity.WContactExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WContactMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_contact
     *
     * @mbggenerated Mon Aug 01 14:02:47 CST 2016
     */
    int countByExample(WContactExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_contact
     *
     * @mbggenerated Mon Aug 01 14:02:47 CST 2016
     */
    int deleteByExample(WContactExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_contact
     *
     * @mbggenerated Mon Aug 01 14:02:47 CST 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_contact
     *
     * @mbggenerated Mon Aug 01 14:02:47 CST 2016
     */
    int insert(WContact record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_contact
     *
     * @mbggenerated Mon Aug 01 14:02:47 CST 2016
     */
    int insertSelective(WContact record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_contact
     *
     * @mbggenerated Mon Aug 01 14:02:47 CST 2016
     */
    List<WContact> selectByExample(WContactExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_contact
     *
     * @mbggenerated Mon Aug 01 14:02:47 CST 2016
     */
    WContact selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_contact
     *
     * @mbggenerated Mon Aug 01 14:02:47 CST 2016
     */
    int updateByExampleSelective(@Param("record") WContact record, @Param("example") WContactExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_contact
     *
     * @mbggenerated Mon Aug 01 14:02:47 CST 2016
     */
    int updateByExample(@Param("record") WContact record, @Param("example") WContactExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_contact
     *
     * @mbggenerated Mon Aug 01 14:02:47 CST 2016
     */
    int updateByPrimaryKeySelective(WContact record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_contact
     *
     * @mbggenerated Mon Aug 01 14:02:47 CST 2016
     */
    int updateByPrimaryKey(WContact record);
}