package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Leevi
 * 日期2020-10-14  11:08
 * 解决字符数出输出字符串时候的中文乱码问题:
 * response.setContentType("text/html;charset=UTF-8")
 */
@WebServlet("/demo04")
public class ServletDemo04 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //通过response的字符输出流，向浏览器输出一段内容
        //字符输出流我们掌握俩方法:write()输出字符串、print()既能输出字符串也能输出非字符串
        response.getWriter().print("你好世界");
    }
}
