package com.umbrella.worker.dao;

import com.umbrella.worker.entity.WSmsTemplate;
import com.umbrella.worker.entity.WSmsTemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface WSmsTemplateMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_sms_template
     *
     * @mbggenerated Fri Aug 05 11:25:33 CST 2016
     */
    int countByExample(WSmsTemplateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_sms_template
     *
     * @mbggenerated Fri Aug 05 11:25:33 CST 2016
     */
    int deleteByExample(WSmsTemplateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_sms_template
     *
     * @mbggenerated Fri Aug 05 11:25:33 CST 2016
     */
    int deleteByPrimaryKey(String wSmKey);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_sms_template
     *
     * @mbggenerated Fri Aug 05 11:25:33 CST 2016
     */
    int insert(WSmsTemplate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_sms_template
     *
     * @mbggenerated Fri Aug 05 11:25:33 CST 2016
     */
    int insertSelective(WSmsTemplate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_sms_template
     *
     * @mbggenerated Fri Aug 05 11:25:33 CST 2016
     */
    List<WSmsTemplate> selectByExample(WSmsTemplateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_sms_template
     *
     * @mbggenerated Fri Aug 05 11:25:33 CST 2016
     */
    WSmsTemplate selectByPrimaryKey(String wSmKey);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_sms_template
     *
     * @mbggenerated Fri Aug 05 11:25:33 CST 2016
     */
    int updateByExampleSelective(@Param("record") WSmsTemplate record, @Param("example") WSmsTemplateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_sms_template
     *
     * @mbggenerated Fri Aug 05 11:25:33 CST 2016
     */
    int updateByExample(@Param("record") WSmsTemplate record, @Param("example") WSmsTemplateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_sms_template
     *
     * @mbggenerated Fri Aug 05 11:25:33 CST 2016
     */
    int updateByPrimaryKeySelective(WSmsTemplate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_sms_template
     *
     * @mbggenerated Fri Aug 05 11:25:33 CST 2016
     */
    int updateByPrimaryKey(WSmsTemplate record);
}