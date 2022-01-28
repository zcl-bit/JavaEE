package com.zcl.web.servlet; /**
 * @author: zcl
 * @create: 2022/1/23 9:36
 */

import com.zcl.pojo.LinkMan;
import com.zcl.pojo.PageBean;
import com.zcl.service.LinkManService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/linkman")
public class LinkManServlet extends BaseServlet {
    private LinkManService linkManService = new LinkManService();
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request, response);
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //1、获取请求参数action的值
//        String action = request.getParameter("action");
//        //2、判断请求参数action的值
//        if ("findAll".equals(action)) {
//            //调用findAll方法处理查询所有的请求
//            findAll(request, response);
//        }
//        if ("add".equals(action)) {
//            //调用add方法处理查询所有的请求
//            add(request, response);
//        }
//        if ("delete".equals(action)) {
//            //调用delete方法处理查询所有的请求
//            delete(request, response);
//        }
//        if ("findOne".equals(action)) {
//            //调用findOne方法处理查询所有的请求
//            findOne(request, response);
//        }
//        if ("update".equals(action)) {
//            //调用findOne方法处理查询所有的请求
//            update(request, response);
//        }
//        if ("findByPage".equals(action)) {
//            //调用findOne方法处理查询所有的请求
//            findByPage(request, response);
//        }
//    }

    /**
     * 查询单个联系人信息
     *
     * @param request
     * @param response
     */
    private void findOne(HttpServletRequest request, HttpServletResponse response) {
        try {
            //1、获取到请求参数id的值
            Integer id = Integer.valueOf(request.getParameter("id"));
            //2、调用业务层的方法根据id查询联系人
            LinkMan linkMan = linkManService.findById(id);
            //3、将linkman对象存储到request域对象中
            request.setAttribute("linkMan",linkMan);
            //4、跳转到update.jsp页面
            request.getRequestDispatcher("update.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 添加联系人
     *
     * @param request
     * @param response
     */
    public void add(HttpServletRequest request, HttpServletResponse response) {
        try {
            //1、获取所有联系人信息，封装到LinkMan对象中
            Map<String, String[]> parameterMap = request.getParameterMap();
            LinkMan linkMan = new LinkMan();
            BeanUtils.populate(linkMan, parameterMap);
            //2、调用业务层的方法，添加联系人
            linkManService.add(linkMan);
            //3、添加成功则跳转到查询所有联系人
            response.sendRedirect("linkman?action=findAll");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据id删除联系人
     *
     * @param request
     * @param response
     */
    public void delete(HttpServletRequest request, HttpServletResponse response) {
        try {
            //1、获取请求参数id
            Integer id = Integer.valueOf(request.getParameter("id"));
            //2、调用业务层的方法根据id删除联系人
            linkManService.deleteById(id);
            //3、添加成功则跳转到查询所有联系人
            response.sendRedirect("linkman?action=findAll");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询所有联系人
     *
     * @param request
     * @param response
     */
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            //1、调用业务层方法查询所有联系人信息
            List<LinkMan> linkManList = null;
            linkManList = linkManService.findAll();
            //2、将linkmanlist存储到request域对象中
            request.setAttribute("list", linkManList);
            //3、请求转发跳转到list.jsp进行展示
            request.getRequestDispatcher("list.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 修改联系人
     *
     * @param request
     * @param response
     */
    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            //1、获取客户端携带过来的联系人信息
            Map<String, String[]> parameterMap = request.getParameterMap();
            //2、将联系人信息存储到linkMan对象中
            LinkMan linkMan = new LinkMan();
            BeanUtils.populate(linkMan,parameterMap);
            //3、调用业务层的方法，修改联系人
            linkManService.update(linkMan);
            //4、跳转到查询所有联系人信息
            response.sendRedirect("linkman?action=findAll");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 分页查询
     *
     * @param request
     * @param response
     */
    public void findByPage(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            //1、获取请求参数
            Long currentPage = Long.valueOf(request.getParameter("currentPage"));
            Integer pageSize = Integer.valueOf(request.getParameter("pageSize"));
            //2、调用业务层的方法进行分页查询
            PageBean<LinkMan> pageBean = linkManService.findByPage(currentPage,pageSize);
            //3、将pageBean存储到域对象
            request.setAttribute("pageBean",pageBean);
            //4、跳转到List_page页面
            request.getRequestDispatcher("list_page.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
            //分页查询失败
            response.getWriter().write("分页查询失败");
        }


    }

}
