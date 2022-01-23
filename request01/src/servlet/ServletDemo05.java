package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Leevi
 * 日期2020-10-14  09:54
 */
@WebServlet("/demo05")
public class ServletDemo05 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //使用请求转发，跳转到hello.html页面
        //相对路径: 不以/开头的路径写法，是以目标资源相对当前资源的路径
        //绝对路径: 以/开头的路径写法，对于请求转发而言在完整url的基础之上省略"项目路径"，对于非请求转发而言在完整url的基础之上省略"服务器路径"
        //完整url: http://localhost:8080/项目名/资源名
        request.getRequestDispatcher("/hello.html").forward(request, response);
    }
}
