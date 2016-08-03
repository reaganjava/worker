package com.umbrella.worker.dao;

import com.umbrella.worker.entity.WWorkerItem;
import com.umbrella.worker.entity.WWorkerItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface WWorkerItemMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_worker_item
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    int countByExample(WWorkerItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_worker_item
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    int deleteByExample(WWorkerItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_worker_item
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_worker_item
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    int insert(WWorkerItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_worker_item
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    int insertSelective(WWorkerItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_worker_item
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    List<WWorkerItem> selectByExample(WWorkerItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_worker_item
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    WWorkerItem selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_worker_item
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    int updateByExampleSelective(@Param("record") WWorkerItem record, @Param("example") WWorkerItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_worker_item
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    int updateByExample(@Param("record") WWorkerItem record, @Param("example") WWorkerItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_worker_item
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    int updateByPrimaryKeySelective(WWorkerItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_worker_item
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    int updateByPrimaryKey(WWorkerItem record);
}