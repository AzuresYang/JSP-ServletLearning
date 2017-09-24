package utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

/**
 * Created by 28029 on 2017/9/16.
 */
public class DataSourceUtils {
    public static void main(String[] args) {
    }
    private static ComboPooledDataSource ds = null;
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

    static {
        try{
            ds = new ComboPooledDataSource();
        }catch(Exception e){
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Connection getConnection() throws SQLException{
        //从当前线程中获取连接
        Connection conn = threadLocal.get();
        if( null == conn){
            conn = ds.getConnection();
        }
        return conn;
    }
    public static  DataSource getDataSource()
    {
   /**
    * @Author: AzureMDK
    * @Description:获得数据源
    * @Date: 20:35 2017/9/17
    */
        return ds;
    }

    public static void startTransaction() {
        try{
            Connection conn = getConnection();
            conn.setAutoCommit(false);
            threadLocal.set(conn);
        }catch(Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    public static void rollbackTransaction() throws SQLException{
        Connection con = threadLocal.get();
        if(null == con)
            throw new SQLException("没有事务不能回滚！");
        con.rollback();
        con.close();
        con = null;
        threadLocal.remove();
    }

    /**
     * @Author: AzureMDK
     * @Description:提交更新
     * @Date: 22:20 2017/9/17
     * @param
     */
    public static void commit(){
        Connection conn = threadLocal.get();
        try{

            if(null != conn){
                conn.commit();
                conn.close();
                conn = null;
                threadLocal.remove();
            }
        }catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @Author: AzureMDK
     * @Description:把数据库连接返会给数据库连接池子
     * @Date: 22:22 2017/9/17
     * @param
     */

    public static void releaseConnection(Connection conn){
        Connection mCon = threadLocal.get();
        try{

            if(mCon != conn){
                {
                    if(null != conn && !conn.isClosed())
                    conn.close();
                    conn = null;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void closeResource(Connection conn , Statement st, ResultSet rs)
    {
        /**
         * @Author: AzureMDK
         * @Description:
         * @Date: 20:41 2017/9/17
         * @param conn
         * @param st
         * @param rs
         */
        closeResultSet(rs);
        closeStatement(st);
        closeConnection(conn);
    }

    public static void closeConnection(Connection conn)
    {
        if( null != conn)
        {
            try
            {
                conn.close();
            }catch(SQLException e){
                e.printStackTrace();
            }finally {
                conn = null;
            }
        }
    }

    public static void closeStatement(Statement st)
    {
        if (null != st){
            try{
                st.close();
            }catch(SQLException e){
                e.printStackTrace();
            }finally {
                st = null;
            }
        }
    }

    public static void closeResultSet(ResultSet rs){
        if( null != rs){
            try{
                rs.close();
            }catch(SQLException e){
                e.printStackTrace();
            }finally {
                rs = null;
            }
        }
    }


}
