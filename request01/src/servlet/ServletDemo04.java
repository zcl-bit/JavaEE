package servlet;

import org.apache.commons.beanutils.BeanUtils;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author Leevi
 * 日期2020-10-14  09:44
 * 将多个请求参数封装到Map中，有啥不好的地方吗?
 * 1. 获取的时候不够方便
 * 2. 数据转换不够方便
 *
 * 我们最好是将数据封装到JO（对象）中
 */
@WebServlet("/demo04")
public class ServletDemo04 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取所有的请求参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        //2. 借助BeanUtils，将parameterMap中的数据封装到User对象中
        User user = new User();
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //此时user中就存储了parameterMap中的数据:而且BeanUtils底层会自动进行数据类型的转换
        System.out.println(user);
    }
}
