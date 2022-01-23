package servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Leevi
 * 日期2020-10-14  11:17
 */
@WebServlet("/demo05")
public class ServletDemo05 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //将mm.jpg显示到客户端浏览器
        //1. 设置响应数据类型为:图片的mime-type
        String mimeType = getServletContext().getMimeType("mm.jpg");
        response.setHeader("Content-type",mimeType);

        //2. 使用字节输入流，将图片的信息读取到内存中
        InputStream is = getServletContext().getResourceAsStream("mm.jpg");

        //3. 我们要使用字节输出流，将图片的信息输出到浏览器
        ServletOutputStream os = response.getOutputStream();

        //4. 进行循环读写
        /*byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = is.read(buffer)) != -1){
            os.write(buffer,0,len);
        }*/
        IOUtils.copy(is,os);

        os.close();
        is.close();
    }
}
