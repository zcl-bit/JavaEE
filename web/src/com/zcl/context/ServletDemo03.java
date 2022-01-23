package com.zcl.context;
/**
 * @author: zcl
 * @create: 2022/1/17 14:06
 *  * 日期2020-10-12  15:13
 *  * 使用ServletContext获取文件的mime-type
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/demo03")
public class ServletDemo03 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileName = "一本道.avi";

        //使用ServletContext可以获取文件的mime-type
        String mimeType = getServletContext().getMimeType(fileName);
        System.out.println(mimeType);
    }

}
