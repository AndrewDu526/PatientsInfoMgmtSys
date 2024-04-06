package com.diy.web.servlet;

import com.alibaba.fastjson.JSON;
import com.diy.pojo.Brand;
import com.diy.pojo.PageBean;
import com.diy.service.BrandService;
import com.diy.service.Impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet{

    private BrandService BS = new BrandServiceImpl();

    /**
     * see all brand's info on page
     */
    public void queryAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("brand queryAll~~~");
        resp.setContentType("text/json;charset=utf-8");
        String user_name = req.getParameter("user_name");
        //use service invoke method ,get return ob
        List<Brand> brands = BS.queryAll(user_name);
        //convert it to json
        String jbs = JSON.toJSONString(brands);

        //output
        resp.getWriter().write(jbs);
    }

    /**
     * add a new brand
     */
    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("brand add~~~");
        //receive request
        BufferedReader brd = req.getReader();
        //reader request params, json string, no matter how long it is ,it is one line
        String params = brd.readLine();
        //convert to a brand ob
        Brand brand = JSON.parseObject(params,Brand.class);
        //invoke add method
        BS.add(brand);
        //response a msg means success
        resp.getWriter().write("bingo");

    }

    public void getPaths(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        String name = req.getParameter("brandName");

        List<String> paths = BS.getPaths(name);

        String jbs = JSON.toJSONString(paths);

        resp.getWriter().write(jbs);

    }

    /**
     * edit a brand
     */
    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // solve garbled char problem first
        req.setCharacterEncoding("utf-8");
        //get params in JSON from req
        BufferedReader reader = req.getReader();
        String params = reader.readLine();//no matter how long, it is one line
        //get a brand ob from json
        Brand brand = JSON.parseObject(params, Brand.class);
        //invoke update method put brand in ()
        BS.update(brand);

        //till now no problem, resp a bingo
        resp.getWriter().write("bingo");

    }

    /**
     * delete only one brand
     */
    public void deleteById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //this parameter is transited by GET way, so no need JSON.parseObject
        String sid = req.getParameter("id");
        //convert to int
        int id = Integer.parseInt(sid);

        BS.deleteById(id);

        resp.getWriter().write("bingo");
    }

    /**
     * delete many brands
     */
    public void deleteByIds(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // solve garbled char problem first, in case
//        req.setCharacterEncoding("utf-8");
        //get params in JSON from req
        BufferedReader reader = req.getReader();
        String params = reader.readLine();//no matter how long, it is one line
        //get an array from json
        int[] ids = JSON.parseObject(params, int[].class);

        BS.deleteByIds(ids);

        resp.getWriter().write("bingo");

    }

    /**
     * for pagination query
     */
    public void selectByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // receive current page and it's size  ===> URL:/selectByPage?currentPage=1&pageSize=5
        String _currentPage = req.getParameter("currentPage");
        String _pageSize = req.getParameter("pageSize");

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        //use service invoke method ,get return ob
        PageBean<Brand> pageBean = BS.selectByPage(currentPage, pageSize);

        //convert it to json
        String jpb = JSON.toJSONString(pageBean);

        //output
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jpb);
    }

    /**
     * query by condition and match pagination
     */
    public void selectByPageWithCondition(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // receive current page and it's size  ===> URL:/selectByPage?currentPage=1&pageSize=5
        String _currentPage = req.getParameter("currentPage");
        String _pageSize = req.getParameter("pageSize");

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        //get condition params from post request body
        BufferedReader reader = req.getReader();
        String params = reader.readLine();
        //convert params to a brand ob
        Brand brand = JSON.parseObject(params, Brand.class);

        //use service invoke method ,get return ob
        PageBean<Brand> pageBean = BS.selectByPageWithCondition(currentPage, pageSize,brand);

        //convert it to json
        String jpb = JSON.toJSONString(pageBean);

        //output
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jpb);
    }
}
