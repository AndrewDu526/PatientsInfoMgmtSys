package com.diy.service;

import com.diy.pojo.Brand;
import com.diy.pojo.PageBean;

import java.util.List;


/**
 * in service layer, we use an interface, instead of service class directly
 */
public interface BrandService {

    /**
     * query all brands
     */
    List<Brand> queryAll(String user_name);

    List<String> getPaths(String name);

    /**
     * add new brand
     */
    void add(Brand brand);

    /**
     * update edited brand info
     */
    void update(Brand brand);

    /**
     * delete one brand by id
     */
    void deleteById(int id);

    /**
     * delete many brand by many ids
     */
    void deleteByIds(int[] ids);

    /**
     * query by pagination
     */
    PageBean<Brand> selectByPage(int currentPage, int pageSize);
//    int selectTotalCount();//no need this, the impl Class can invoke it directly by mapper

    /**
     * query by condition and match pagination
     */
    PageBean<Brand> selectByPageWithCondition(int currentPage, int pageSize, Brand brand);


}
