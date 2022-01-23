package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Leevi
 * 日期2020-10-14  10:44
 * 重定向跳转和请求转发跳转的对比:
 * 1. 谁发起的跳转?
 * 1.1 请求转发的跳转是由服务器发起的
 * 1.2 重定向的跳转是由浏览器发起的
 * 2. 能跳转到哪些资源?
 * 2.1 请求转发只能跳转到本项目的资源
 * 2.2 重定向可以跳转到本项目和外部项目的资源
 * 3.是否能访问WEB-INF中的资源
 * 3.1 请求转发可以访问WEB-INF中的资源
 * 3.2 重定向没法访问WEB-INF中的资源
 * 4. 发起几次请求?
 * 4.1 请求转发只发起一次请求
 * 4.2 重定向会发起两次请求
 * 5. 地址栏是否发生变化?
 * 5.1 请求转发地址栏不变
 * 5.2 重定向地址栏会变化
 * 6. 是否能和request域对象存取值一起使用?
 * 6.1 请求转发能和request域对象存取值一起使用
 * 6.2 重定向不能和request域对象存取值一起使用
 */
@WebServlet("/demo03")
public class ServletDemo03 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //重定向跳转: 让浏览进行页面跳转
        //设置响应状态码为302
        /*response.setStatus(302);
        //跳转到百度首页
        response.setHeader("Location","https://www.baidu.com");*/

        //设置重定向的简单方式
        //response.sendRedirect("https://www.baidu.com");

        //请求转发跳转到WEB-INF中的demo.html
        request.getRequestDispatcher("WEB-INF/demo.html").forward(request, response);
    }
}
