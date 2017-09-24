package customerSys.filter;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.DataSourceUtils;
/**
 * Created by 28029 on 2017/9/17.
 * @Description：利用过滤器，在执行服务的时候，进行事务的处理，
 * 如果失败，则在过滤器层进行事物的回滚，而DAO层和Service层则专注于逻辑的实现
 */


public class TransactionFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException{

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain)throws  IOException, ServletException{
        Connection conn = null;
        try{
            conn = utils.DataSourceUtils.getConnection();
            if(null == conn)
                System.out.println("\n过滤器疑问：为空");
            if(conn.isClosed()){
                System.out.println("\n过滤器疑问：关闭了");
            }
            else
                System.out.println("\n过滤器:正常打开");


            conn.setAutoCommit(false);

            //利用ThreadLocal把获取数据库连接对象Connection和当前线程绑定
            ConnectionContext.getInstance().bind(conn);

            chain.doFilter(request, response);
            conn.commit();
        }catch(Exception e){
            e.printStackTrace();

            try{
                conn.rollback();
            }catch(SQLException es){
                es.printStackTrace();
            }

            HttpServletResponse res = (HttpServletResponse) response;
            HttpServletRequest req = (HttpServletRequest) request;

            request.getRequestDispatcher(req.getContextPath()+"/error.jsp").forward(request, response);
           // res.sendRedirect(req.getContextPath()+"/error.jsp");
        }finally{
            //解除绑定
            ConnectionContext.getInstance().remove();
            //关闭数据库连接
            try{
                conn.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void destroy() {

    }
}
