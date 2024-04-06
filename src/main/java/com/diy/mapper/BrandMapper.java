package com.diy.mapper;

import com.diy.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BrandMapper {

    /**
     * query all brands
     */
    @Select("select * from mybatis.brand_pro where user_name = #{user_name}")
    @ResultMap("BrandResultMap")
    List<Brand> queryAll(String user_name);


    @Select("select mybatis.paths.paths from mybatis.brand_pro inner join mybatis.paths on mybatis.brand_pro.brand_name=" +
            "mybatis.paths.name where mybatis.brand_pro.brand_name = #{name}")
    List<String> getPaths(String name);


    /**
     * add new brand
     */
    @Insert("insert into mybatis.brand_pro values (null, #{brandName},#{companyName},#{ordered},#{description},#{status},#{user_name})")
    void add(Brand brand);

    /**
     * update edited brand info
     */
    @Update("update mybatis.brand_pro set brand_name = #{brandName}, company_name = #{companyName},ordered = #{ordered},description = #{description}, user_name = #{user_name} where id = #{id}")
    void update(Brand brand);

    /**
     * delete one brand by id
     */
    @Delete("delete from mybatis.brand_pro where id = #{id}")
    void deleteById(int id);

    /**
     * delete many brand by many ids
     * here we need to use dynamic sql, so we don't use annotation sql
     */
    void deleteByIds(@Param("ids")int[] ids);

    /**
     * query by pagination
     */
    @Select("select * from mybatis.brand_pro limit #{begin}, #{size}")
    @ResultMap("BrandResultMap")
    List<Brand> selectByPage(@Param("begin")int begin, @Param("size") int size);
    @Select("select count(*) from mybatis.brand_pro")
    int selectTotalCount();

    /**
     * query by condition box
     * and match pagination also
     * dynamic sql, use xml file write sql statement
     */
    List<Brand> selectByPageWithCondition(@Param("begin")int begin, @Param("size") int size, @Param("brand") Brand brand);
    int selectTotalCountWithCondition(Brand brand);


}
