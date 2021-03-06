package saber.kuns.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import saber.kuns.annotation.MybatisDao;
import saber.kuns.entity.TblAccomodationSum;
import saber.kuns.entity.TblAccomodationSumExample;

@MybatisDao
public interface TblAccomodationSumMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_accomodation_sum
     *
     * @mbg.generated
     */
    long countByExample(TblAccomodationSumExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_accomodation_sum
     *
     * @mbg.generated
     */
    int deleteByExample(TblAccomodationSumExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_accomodation_sum
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_accomodation_sum
     *
     * @mbg.generated
     */
    int insert(TblAccomodationSum record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_accomodation_sum
     *
     * @mbg.generated
     */
    int insertSelective(TblAccomodationSum record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_accomodation_sum
     *
     * @mbg.generated
     */
    List<TblAccomodationSum> selectByExample(TblAccomodationSumExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_accomodation_sum
     *
     * @mbg.generated
     */
    TblAccomodationSum selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_accomodation_sum
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") TblAccomodationSum record, @Param("example") TblAccomodationSumExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_accomodation_sum
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") TblAccomodationSum record, @Param("example") TblAccomodationSumExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_accomodation_sum
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(TblAccomodationSum record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_accomodation_sum
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TblAccomodationSum record);
}