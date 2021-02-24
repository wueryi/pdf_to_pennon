package com.pennonedu.student_sign_api.dao;

import com.pennonedu.student_sign_api.entity.FlowFile;
import com.pennonedu.student_sign_api.entity.FlowFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowFileMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flow_file
     *
     * @mbg.generated
     */
    long countByExample(FlowFileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flow_file
     *
     * @mbg.generated
     */
    int deleteByExample(FlowFileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flow_file
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flow_file
     *
     * @mbg.generated
     */
    int insert(FlowFile record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flow_file
     *
     * @mbg.generated
     */
    int insertSelective(FlowFile record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flow_file
     *
     * @mbg.generated
     */
    List<FlowFile> selectByExampleWithRowbounds(FlowFileExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flow_file
     *
     * @mbg.generated
     */
    List<FlowFile> selectByExample(FlowFileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flow_file
     *
     * @mbg.generated
     */
    FlowFile selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flow_file
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") FlowFile record, @Param("example") FlowFileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flow_file
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") FlowFile record, @Param("example") FlowFileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flow_file
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(FlowFile record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flow_file
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(FlowFile record);
}