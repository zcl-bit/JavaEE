package com.zcl.context;
/**
 * @author: zcl
 * @create: 2022/1/17 13:59
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/demo02")
public class ServletDemo02 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取ServletContext对象
        ServletContext servletContext = getServletContext();

        //2. 调用servletContext对象的getAttribute(name)
        String str = (String) servletContext.getAttribute("str");

        System.out.println("在ServletDemo02中获取str的值为:" + str);
    }

}
