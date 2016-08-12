package com.umbrella.worker.dao;

import com.umbrella.worker.entity.WSupplier;
import com.umbrella.worker.entity.WSupplierExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface WSupplierMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_supplier
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    int countByExample(WSupplierExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_supplier
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    int deleteByExample(WSupplierExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_supplier
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_supplier
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    int insert(WSupplier record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_supplier
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    int insertSelective(WSupplier record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_supplier
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    List<WSupplier> selectByExample(WSupplierExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_supplier
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    WSupplier selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_supplier
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    int updateByExampleSelective(@Param("record") WSupplier record, @Param("example") WSupplierExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_supplier
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    int updateByExample(@Param("record") WSupplier record, @Param("example") WSupplierExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_supplier
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    int updateByPrimaryKeySelective(WSupplier record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_supplier
     *
     * @mbggenerated Tue Aug 02 16:49:02 CST 2016
     */
    int updateByPrimaryKey(WSupplier record);
    
    
    List<WSupplier> selectSupplierByWorkerId(Integer id);
}