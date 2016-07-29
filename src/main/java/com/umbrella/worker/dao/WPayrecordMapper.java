package com.umbrella.worker.dao;

import com.umbrella.worker.entity.WPayrecord;
import com.umbrella.worker.entity.WPayrecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WPayrecordMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_payrecord
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    int countByExample(WPayrecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_payrecord
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    int deleteByExample(WPayrecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_payrecord
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_payrecord
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    int insert(WPayrecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_payrecord
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    int insertSelective(WPayrecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_payrecord
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    List<WPayrecord> selectByExample(WPayrecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_payrecord
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    WPayrecord selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_payrecord
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    int updateByExampleSelective(@Param("record") WPayrecord record, @Param("example") WPayrecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_payrecord
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    int updateByExample(@Param("record") WPayrecord record, @Param("example") WPayrecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_payrecord
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    int updateByPrimaryKeySelective(WPayrecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_payrecord
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    int updateByPrimaryKey(WPayrecord record);
}