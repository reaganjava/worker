package com.umbrella.worker.dao;

import com.umbrella.worker.entity.WWorkerStaff;
import com.umbrella.worker.entity.WWorkerStaffExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface WWorkerStaffMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_worker_staff
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    int countByExample(WWorkerStaffExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_worker_staff
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    int deleteByExample(WWorkerStaffExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_worker_staff
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_worker_staff
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    int insert(WWorkerStaff record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_worker_staff
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    int insertSelective(WWorkerStaff record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_worker_staff
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    List<WWorkerStaff> selectByExample(WWorkerStaffExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_worker_staff
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    WWorkerStaff selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_worker_staff
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    int updateByExampleSelective(@Param("record") WWorkerStaff record, @Param("example") WWorkerStaffExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_worker_staff
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    int updateByExample(@Param("record") WWorkerStaff record, @Param("example") WWorkerStaffExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_worker_staff
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    int updateByPrimaryKeySelective(WWorkerStaff record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_worker_staff
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    int updateByPrimaryKey(WWorkerStaff record);
}