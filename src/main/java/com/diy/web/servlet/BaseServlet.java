package com.diy.web.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * replace HttpServlet, according request path tail, decide which method be invoked
 */

public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get req path
        String URI = req.getRequestURI();// /JavaWeb_last/brand/queryAll
//        System.out.println(URI);
        // split last part
        int index = URI.lastIndexOf('/');
        String methodName = URI.substring(index + 1);
//        System.out.println(methodName);
        /**
         * execute method,
         * but we just got the name of method, it is a string, can not be invoked
         * we must get the Class file of brand servlet, then we can invoke the method
         */
        //System.out.println(this);//if we visit service by brand servlet, "this" will present brand servlet
        /**
         * so we can get Class file just by this, then we get the method
         */
        Class<? extends BaseServlet> cls = this.getClass();
        try {
            //get the method, and need the general args req and resp
            Method mth = cls.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            //finally, invoking
            mth.invoke(this,req,resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }


}
