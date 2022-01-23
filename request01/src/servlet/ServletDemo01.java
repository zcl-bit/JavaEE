package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Leevi
 * 日期2020-10-14  08:54
 * request的作用一: 获取请求行的数据(了解)
 * 1. 获取请求方式: getMethod()
 * 2. 获取请求的url地址: getRequestURL()
 * 3. 获取请求的uri地址: getRequestURI()
 * 4. 获取请求的项目名: getContextPath()
 * 5. 获取请求的客户端的ip: getRemoteAddr()
 * 6. 获取请求的协议: getProtocol()
 */
@WebServlet("/demo01")
public class ServletDemo01 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求方式:
        String method = request.getMethod();
        //System.out.println(method);

        //2. 获取请求的url地址: http://localhost:8080/request_01/demo01
        //url: 统一资源定位符，也就是在互联网中访问该资源的地址
        StringBuffer requestURL = request.getRequestURL();
        //System.out.println(requestURL.toString());

        //3. 获取请求的uri地址: /request_01/demo01
        //uri: 统一资源标识符，也就是在当前服务器中可以使用这个地址来唯一标识一个资源
        String requestURI = request.getRequestURI();
        //System.out.println(requestURI);

        //4. 获取请求的项目名:
        String contextPath = request.getContextPath();
        //System.out.println(contextPath);

        //5. 获取请求的客户端的ip:
        String remoteAddr = request.getRemoteAddr();
        //System.out.println(remoteAddr);

        //6. 获取请求的协议:
        String protocol = request.getProtocol();
        System.out.println(protocol);
    }
}
