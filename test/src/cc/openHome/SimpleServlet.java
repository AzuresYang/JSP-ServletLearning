package cc.openHome;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 * Created by 28029 on 2017/9/8.
 */

public class SimpleServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)throws ServletException, IOException{
        response.setContentType("text/html;charset = UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Simple Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>" + "现在的时间是："+new java.util.Date() + "</h1>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
