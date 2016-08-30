package com.umbrella.worker.dao;

import com.umbrella.worker.entity.WAttachment;
import com.umbrella.worker.entity.WAttachmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WAttachmentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_attachment
     *
     * @mbggenerated Fri Aug 26 17:24:04 CST 2016
     */
    int countByExample(WAttachmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_attachment
     *
     * @mbggenerated Fri Aug 26 17:24:04 CST 2016
     */
    int deleteByExample(WAttachmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_attachment
     *
     * @mbggenerated Fri Aug 26 17:24:04 CST 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_attachment
     *
     * @mbggenerated Fri Aug 26 17:24:04 CST 2016
     */
    int insert(WAttachment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_attachment
     *
     * @mbggenerated Fri Aug 26 17:24:04 CST 2016
     */
    int insertSelective(WAttachment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_attachment
     *
     * @mbggenerated Fri Aug 26 17:24:04 CST 2016
     */
    List<WAttachment> selectByExample(WAttachmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_attachment
     *
     * @mbggenerated Fri Aug 26 17:24:04 CST 2016
     */
    WAttachment selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_attachment
     *
     * @mbggenerated Fri Aug 26 17:24:04 CST 2016
     */
    int updateByExampleSelective(@Param("record") WAttachment record, @Param("example") WAttachmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_attachment
     *
     * @mbggenerated Fri Aug 26 17:24:04 CST 2016
     */
    int updateByExample(@Param("record") WAttachment record, @Param("example") WAttachmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_attachment
     *
     * @mbggenerated Fri Aug 26 17:24:04 CST 2016
     */
    int updateByPrimaryKeySelective(WAttachment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_attachment
     *
     * @mbggenerated Fri Aug 26 17:24:04 CST 2016
     */
    int updateByPrimaryKey(WAttachment record);
}