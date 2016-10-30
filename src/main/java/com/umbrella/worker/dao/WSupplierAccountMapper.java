package com.umbrella.worker.dao;

import com.umbrella.worker.entity.WSupplierAccount;
import com.umbrella.worker.entity.WSupplierAccountExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface WSupplierAccountMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_supplier_account
     *
     * @mbggenerated Mon Oct 31 05:18:47 CST 2016
     */
    int countByExample(WSupplierAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_supplier_account
     *
     * @mbggenerated Mon Oct 31 05:18:47 CST 2016
     */
    int deleteByExample(WSupplierAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_supplier_account
     *
     * @mbggenerated Mon Oct 31 05:18:47 CST 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_supplier_account
     *
     * @mbggenerated Mon Oct 31 05:18:47 CST 2016
     */
    int insert(WSupplierAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_supplier_account
     *
     * @mbggenerated Mon Oct 31 05:18:47 CST 2016
     */
    int insertSelective(WSupplierAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_supplier_account
     *
     * @mbggenerated Mon Oct 31 05:18:47 CST 2016
     */
    List<WSupplierAccount> selectByExample(WSupplierAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_supplier_account
     *
     * @mbggenerated Mon Oct 31 05:18:47 CST 2016
     */
    WSupplierAccount selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_supplier_account
     *
     * @mbggenerated Mon Oct 31 05:18:47 CST 2016
     */
    int updateByExampleSelective(@Param("record") WSupplierAccount record, @Param("example") WSupplierAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_supplier_account
     *
     * @mbggenerated Mon Oct 31 05:18:47 CST 2016
     */
    int updateByExample(@Param("record") WSupplierAccount record, @Param("example") WSupplierAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_supplier_account
     *
     * @mbggenerated Mon Oct 31 05:18:47 CST 2016
     */
    int updateByPrimaryKeySelective(WSupplierAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_supplier_account
     *
     * @mbggenerated Mon Oct 31 05:18:47 CST 2016
     */
    int updateByPrimaryKey(WSupplierAccount record);
}