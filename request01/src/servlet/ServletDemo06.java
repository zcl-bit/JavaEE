package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Leevi
 * 日期2020-10-14  10:02
 * request域对象的作用范围只在一次请求之间
 * 所以request作为域对象存取值必须和请求转发一起使用
 */
@WebServlet("/demo06")
public class ServletDemo06 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str = "周杰棍";
        //将str存入域对象
        request.setAttribute("str",str);

        //跳转到ServletDemo07
        request.getRequestDispatcher("demo07").forward(request, response);
    }
}
