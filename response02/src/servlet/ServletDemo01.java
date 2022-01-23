package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Leevi
 * 日期2020-10-14  10:23
 * respons的作用1: 设置响应行的数据
 * 设置响应状态码,常见的状态码:
 * 1. 200 OK
 * 2. 302 重定向
 * 3. 304 从缓存中获取
 * 4. 403 拒绝
 * 5. 404 资源未找到
 * 6. 500 服务器异常
 */
@WebServlet("/demo01")
public class ServletDemo01 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //服务器拒绝处理该请求
        response.setStatus(403);
    }
}
