package com.zcl.context; /**
 * @author: zcl
 * @create: 2022/1/17 14:23
 * * 日期2020-10-12  15:19
 * * ServletContext的第三个作用: 获取资源文件的真实路径
 * * ServletContext的第四个作用: 直接将资源文件转换成字节输入流
 * * 工作空间和部署路径
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/demo04")
public class ServletDemo04 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //动态获取文件部署时候的路径: 使用ServletContext获取文件的真实路径
        String realPath = getServletContext().getRealPath("img/timg.jpg");
        System.out.println(realPath);
        //将 timg.jpg这张照片转换成字节输入流
        InputStream is = new FileInputStream(realPath);
        System.out.println(is);

        //原则: 如果是将类路径下载文件转换成流使用类加载器的getResourceAsStream()方法
        //如果是将web里面的资源转换成流就使用ServletContext的getResourceAsStream()方法
//        InputStream is = getServletContext().getResourceAsStream("img/timg.jpg");
//
//        System.out.println(is);

    }

}
