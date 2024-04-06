package com.diy.service.Impl;

import com.diy.mapper.BrandMapper;
import com.diy.pojo.Brand;
import com.diy.pojo.PageBean;
import com.diy.service.BrandService;
import com.diy.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandServiceImpl implements BrandService {

    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * query all brands
     */
    @Override
    public List<Brand> queryAll(String user_name) {

        SqlSession Session = factory.openSession();

        BrandMapper mapper = Session.getMapper(BrandMapper.class);

        List<Brand> brands = mapper.queryAll(user_name);

        Session.close();

        return brands;

    }

    public List<String> getPaths(String name){
        SqlSession Session = factory.openSession();

        BrandMapper mapper = Session.getMapper(BrandMapper.class);

        List<String> paths = mapper.getPaths(name);

        Session.close();

        return paths;
    }

    /**
     * add new brand
     */
    @Override
    public void add(Brand brand) {
        SqlSession sess = factory.openSession();

        BrandMapper mapper = sess.getMapper(BrandMapper.class);

        mapper.add(brand);

        sess.commit();

        sess.close();
    }

    @Override
    public void update(Brand brand) {
        SqlSession sess = factory.openSession();

        BrandMapper mapper = sess.getMapper(BrandMapper.class);

        mapper.update(brand);

        sess.commit();

        sess.close();
    }

    @Override
    public void deleteById(int id) {
        SqlSession sess = factory.openSession();

        BrandMapper mapper = sess.getMapper(BrandMapper.class);

        mapper.deleteById(id);

        sess.commit();

        sess.close();

    }

    @Override
    public void deleteByIds(int[] ids) {
        SqlSession sess = factory.openSession();

        BrandMapper mapper = sess.getMapper(BrandMapper.class);

        mapper.deleteByIds(ids);

        sess.commit();

        sess.close();
    }

    /**
     * query by pagination
     */
    @Override
    public PageBean<Brand> selectByPage(int currentPage, int pageSize) {
        SqlSession sess = factory.openSession();
        BrandMapper mapper = sess.getMapper(BrandMapper.class);

        //get args for invoking
        int size = pageSize;
        int begin = (currentPage -1) * pageSize;
        //invoke method
        List<Brand> rowsInPage = mapper.selectByPage(begin, size);
        int count = mapper.selectTotalCount();
        //deposit result into a pageBean ob
        PageBean<Brand> pageBean = new PageBean<>();
        pageBean.setRowsInPage(rowsInPage);
        pageBean.setTotalCount(count);

        sess.close();

        return pageBean;
    }

    /**
     * query by condition and match pagination
     */
    @Override
    public PageBean<Brand> selectByPageWithCondition(int currentPage, int pageSize, Brand brand) {
        SqlSession sess = factory.openSession();
        BrandMapper mapper = sess.getMapper(BrandMapper.class);

        //get args for invoking
        int size = pageSize;
        int begin = (currentPage -1) * pageSize;

        //handle query by fuzzy match, when user input part of brand name or company name
        String user_name = brand.getUser_name();
        if (user_name != null && user_name.length() >0) {
            brand.setBrandName("%"+user_name+"%");
        }
        String brandName = brand.getBrandName();
        if (brandName != null && brandName.length() >0) {
            brand.setBrandName("%"+brandName+"%");
        }
        String companyName = brand.getCompanyName();
        if (companyName != null && companyName.length() >0) {
            brand.setCompanyName("%"+companyName+"%");
        }

        List<Brand> rowsInPage = mapper.selectByPageWithCondition(begin, size, brand);
        int totalCount = mapper.selectTotalCountWithCondition(brand);

        //wrap into a page bean ob
        PageBean<Brand> pageBean = new PageBean<>();
        pageBean.setRowsInPage(rowsInPage);
        pageBean.setTotalCount(totalCount);

        sess.close();

        return pageBean;
    }


}
