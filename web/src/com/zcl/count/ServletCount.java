package com.zcl.count; /**
 * @author: zcl
 * @create: 2022/1/17 14:50
 * 1. 在CountServlet创建出来的时候，往ServletContext中存储一个计数器，数值为0
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/count")
public class ServletCount extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ////往ServletContexe中存储一个计数器
        getServletContext().setAttribute("count",0);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //每次有用户访问我们的CountServlet，我们就将ServletContext中存储的访问次数+1
        //1、取出count的值
        Integer count = (Integer) getServletContext().getAttribute("count");
        //数值++
        count++;
        //将count存入到ServletContext中
        getServletContext().setAttribute("count", count);
    }

}
