package com.umbrella.worker.dao;

import com.umbrella.worker.entity.WOrder;
import com.umbrella.worker.entity.WOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WOrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_order
     *
     * @mbggenerated Tue Aug 02 17:01:48 CST 2016
     */
    int countByExample(WOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_order
     *
     * @mbggenerated Tue Aug 02 17:01:48 CST 2016
     */
    int deleteByExample(WOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_order
     *
     * @mbggenerated Tue Aug 02 17:01:48 CST 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_order
     *
     * @mbggenerated Tue Aug 02 17:01:48 CST 2016
     */
    int insert(WOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_order
     *
     * @mbggenerated Tue Aug 02 17:01:48 CST 2016
     */
    int insertSelective(WOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_order
     *
     * @mbggenerated Tue Aug 02 17:01:48 CST 2016
     */
    List<WOrder> selectByExample(WOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_order
     *
     * @mbggenerated Tue Aug 02 17:01:48 CST 2016
     */
    WOrder selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_order
     *
     * @mbggenerated Tue Aug 02 17:01:48 CST 2016
     */
    int updateByExampleSelective(@Param("record") WOrder record, @Param("example") WOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_order
     *
     * @mbggenerated Tue Aug 02 17:01:48 CST 2016
     */
    int updateByExample(@Param("record") WOrder record, @Param("example") WOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_order
     *
     * @mbggenerated Tue Aug 02 17:01:48 CST 2016
     */
    int updateByPrimaryKeySelective(WOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_order
     *
     * @mbggenerated Tue Aug 02 17:01:48 CST 2016
     */
    int updateByPrimaryKey(WOrder record);
}