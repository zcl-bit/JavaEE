package com.zcl.count; /**
 * @author: zcl
 * @create: 2022/1/17 14:55
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/show01")
public class ShowServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //展示用户的访问次数
        //从servletContext中取出count
        Integer count = (Integer) getServletContext().getAttribute("count");
        response.getWriter().print(count);
    }

}
