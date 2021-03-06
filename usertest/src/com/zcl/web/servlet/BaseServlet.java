package com.zcl.web.servlet;
/**
 * @author: zcl
 * @create: 2022/1/23 14:49
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、获取请求参数action的值
        String action = request.getParameter("action");
        //2、判断请求参数action的值
        try {
            //action其实就是要调用的方法的方法名，那么也就是已知方法名要去调用本类的某个方法，可以使用反射
            //1、根据方法名获取方法
            Method method = this.getClass().getMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            //2、调用方法
            method.invoke(this,request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
