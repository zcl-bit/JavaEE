package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/**
 * @author Leevi
 * 日期2020-10-14  09:12
 * request的作用三: 获取请求参数
 * 1. getParameter(name): 根据一个参数名获取一个参数值
 * 2. getParameterValues(name): 根据一个参数名获取多个参数值
 * 3. getParameterMap(): 获取所有的请求参数
 *
 * 怎么解决POST方式提交请求参数乱码的问题: 在获取请求参数之前，调用request.setCharacterEncoding("UTF-8")
 */
@WebServlet("/demo03")
public class ServletDemo03 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        //获取请求参数
        //根据一个参数名获取一个参数值
        String username = request.getParameter("username");
        //System.out.println(username);

        //根据一个参数名获取多个参数值
        String[] hobbies = request.getParameterValues("hobby");
        //System.out.println(Arrays.toString(hobbies));

        // 获取所有的请求参数,存储到map中，参数名就是map的key(String)，参数值就是map的value(String[])
        Map<String, String[]> parameterMap = request.getParameterMap();
        for (Map.Entry<String, String[]> stringEntry : parameterMap.entrySet()) {
            System.out.println(stringEntry.getKey() + ":" + Arrays.toString(stringEntry.getValue()));
        }
    }
}
