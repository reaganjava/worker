package com.umbrella.worker.dao;

import com.umbrella.worker.entity.WSchedule;
import com.umbrella.worker.entity.WScheduleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WScheduleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_schedule
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    int countByExample(WScheduleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_schedule
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    int deleteByExample(WScheduleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_schedule
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_schedule
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    int insert(WSchedule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_schedule
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    int insertSelective(WSchedule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_schedule
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    List<WSchedule> selectByExample(WScheduleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_schedule
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    WSchedule selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_schedule
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    int updateByExampleSelective(@Param("record") WSchedule record, @Param("example") WScheduleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_schedule
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    int updateByExample(@Param("record") WSchedule record, @Param("example") WScheduleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_schedule
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    int updateByPrimaryKeySelective(WSchedule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_schedule
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    int updateByPrimaryKey(WSchedule record);
}