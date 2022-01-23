import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import utils.DruidUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author Leevi
 * 日期2020-10-14  14:39
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决请求参数的中文乱码问题
        request.setCharacterEncoding("UTF-8");
        //响应数据的中文乱码问题
        response.setContentType("text/html;charset=UTF-8");
        //1. 获取客户端提交的所有请求参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        //2. 将所有请求参数封装到User对象中
        User user = new User();
        try {
            BeanUtils.populate(user,parameterMap);
            //3. 使用dbutil将user中的数据存储到表中
            QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
            String sql = "insert into user1 values (null,?,?,?,?,?,?,0)";
            queryRunner.update(sql,user.getUsername(),user.getPassword(),
                    user.getAddress(),user.getNickname(),user.getGender(),user.getEmail());

            //注册成功，跳转到登录页面: 如果一定要用请求转发才用请求转发
            response.sendRedirect("login.html");
        } catch (Exception e) {
            e.printStackTrace();
            //注册失败,在浏览器页面显示注册失败
            response.getWriter().write("注册失败");
        }


    }
}
