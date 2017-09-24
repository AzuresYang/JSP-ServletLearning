package utils;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
/**
 * Created by 28029 on 2017/9/19.
 */
public class ExQueryRunner extends QueryRunner{
    @Override
    public int[] batch(String sql, Object[][] params) throws SQLException {
        Connection con = DataSourceUtils.getConnection();
        int[] result = super.batch(con, sql, params);
        DataSourceUtils.closeConnection(con);
        return result;
    }

    @Override
    public <T> T query(String sql, ResultSetHandler<T> rsh, Object... params)
            throws SQLException {
        Connection con = DataSourceUtils.getConnection();
        T result = super.query(con, sql, rsh, params);
        DataSourceUtils.closeConnection(con);
        return result;
    }

    @Override
    public <T> T query(String sql, ResultSetHandler<T> rsh) throws SQLException {
        Connection con = DataSourceUtils.getConnection();
        T result = super.query(con, sql, rsh);
        DataSourceUtils.closeConnection(con);
        return result;
    }

    @Override
    public int update(String sql) throws SQLException {
        Connection con = DataSourceUtils.getConnection();
        int result = super.update(con, sql);
        DataSourceUtils.closeConnection(con);
        return result;
    }

    @Override
    public int update(String sql, Object param) throws SQLException {
        Connection con = DataSourceUtils.getConnection();
        int result = super.update(con, sql, param);
        DataSourceUtils.closeConnection(con);
        return result;
    }

    @Override
    public int update(String sql, Object... params) throws SQLException {
        Connection con = DataSourceUtils.getConnection();
        int result = super.update(con, sql, params);
        DataSourceUtils.closeConnection(con);
        return result;
    }
}
