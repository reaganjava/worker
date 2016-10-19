package com.umbrella.worker.dao;

import com.umbrella.worker.entity.WMemberCoupon;
import com.umbrella.worker.entity.WMemberCouponExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface WMemberCouponMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_member_coupon
     *
     * @mbggenerated Thu Oct 20 03:40:41 CST 2016
     */
    int countByExample(WMemberCouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_member_coupon
     *
     * @mbggenerated Thu Oct 20 03:40:41 CST 2016
     */
    int deleteByExample(WMemberCouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_member_coupon
     *
     * @mbggenerated Thu Oct 20 03:40:41 CST 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_member_coupon
     *
     * @mbggenerated Thu Oct 20 03:40:41 CST 2016
     */
    int insert(WMemberCoupon record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_member_coupon
     *
     * @mbggenerated Thu Oct 20 03:40:41 CST 2016
     */
    int insertSelective(WMemberCoupon record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_member_coupon
     *
     * @mbggenerated Thu Oct 20 03:40:41 CST 2016
     */
    List<WMemberCoupon> selectByExample(WMemberCouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_member_coupon
     *
     * @mbggenerated Thu Oct 20 03:40:41 CST 2016
     */
    WMemberCoupon selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_member_coupon
     *
     * @mbggenerated Thu Oct 20 03:40:41 CST 2016
     */
    int updateByExampleSelective(@Param("record") WMemberCoupon record, @Param("example") WMemberCouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_member_coupon
     *
     * @mbggenerated Thu Oct 20 03:40:41 CST 2016
     */
    int updateByExample(@Param("record") WMemberCoupon record, @Param("example") WMemberCouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_member_coupon
     *
     * @mbggenerated Thu Oct 20 03:40:41 CST 2016
     */
    int updateByPrimaryKeySelective(WMemberCoupon record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_member_coupon
     *
     * @mbggenerated Thu Oct 20 03:40:41 CST 2016
     */
    int updateByPrimaryKey(WMemberCoupon record);
}