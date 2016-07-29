package com.umbrella.worker.dao;

import com.umbrella.worker.entity.WOrderDetail;
import com.umbrella.worker.entity.WOrderDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WOrderDetailMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_order_detail
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    int countByExample(WOrderDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_order_detail
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    int deleteByExample(WOrderDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_order_detail
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_order_detail
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    int insert(WOrderDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_order_detail
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    int insertSelective(WOrderDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_order_detail
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    List<WOrderDetail> selectByExample(WOrderDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_order_detail
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    WOrderDetail selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_order_detail
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    int updateByExampleSelective(@Param("record") WOrderDetail record, @Param("example") WOrderDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_order_detail
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    int updateByExample(@Param("record") WOrderDetail record, @Param("example") WOrderDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_order_detail
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    int updateByPrimaryKeySelective(WOrderDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_order_detail
     *
     * @mbggenerated Fri Jul 29 12:03:32 CST 2016
     */
    int updateByPrimaryKey(WOrderDetail record);
}