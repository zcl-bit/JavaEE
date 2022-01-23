/**
 * @author: zcl
 * @create: 2022/1/18 12:42
 */

import org.apache.commons.io.IOUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//1. 获取到客户端想要下载的文件名
        String fileName = request.getParameter("fileName");

        //设置下载的文件的mime-type
        String mimeType = getServletContext().getMimeType(fileName);
        response.setHeader("Content-Type",mimeType);

        //2. 使用字节输入流读取客户端要下载的那个文件
        InputStream is = getServletContext().getResourceAsStream("file/" + fileName);

        //3. 使用字节输出流，将图片输出到浏览器
        ServletOutputStream os = response.getOutputStream();

        //输出之前，我们通过设置响应头的方式，指示客户端下载文件
        //我们先将fileName进行URL编码: 使用URLEncoder
        String encodeFileName = URLEncoder.encode(fileName, "UTF-8");
        response.setHeader("Content-Disposition","attachment;filename="+encodeFileName);

        IOUtils.copy(is,os);
        os.close();
        is.close();
    }

}
