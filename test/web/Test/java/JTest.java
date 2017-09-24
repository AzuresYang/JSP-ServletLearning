
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class JTest extends HttpServlet{
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
        out.println("<h1>" + new java.util.Date() + "</h1>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
