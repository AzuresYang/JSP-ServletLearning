package customerSys.filter;


import java.sql.Connection;
/**
 * Created by 28029 on 2017/9/17.
 */
public class ConnectionContext {
    private ConnectionContext(){

    }

    private static ConnectionContext connectionContext = new ConnectionContext();
    private ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<Connection>();



    public static ConnectionContext getInstance(){
        return connectionContext;
    }

    /**
     * @Author: AzureMDK
     * @Description:利用ThreadLocal把获取数据库连接对象Connection和当前线程绑定
     * @Date: 23:07 2017/9/17
     * @param
     */
    public void bind(Connection connection){
        connectionThreadLocal.set(connection);
    }

    public Connection getConnection(){
        return connectionThreadLocal.get();
    }

    public void remove(){
        connectionThreadLocal.remove();
    }

}
