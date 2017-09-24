package customerSys.dao;

import customerSys.domain.Customer;
import customerSys.domain.PageBean;
import customerSys.filter.ConnectionContext;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.CurrentLineInfo;
import utils.DataSourceUtils;
import utils.ExQueryRunner;
import utils.WLoger;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 28029 on 2017/9/12.
 */
public class CustomerDao {

    private ExQueryRunner eqr = new ExQueryRunner();

    public static void main(String args[]) {

        CustomerDao dao = new CustomerDao();
        Customer cus = new Customer();

        cus.setGender("male");
        cus.setName("TestCus");
        cus.setPhone(null);
        cus.setEmail(null);

        for(int i = 100; i>=0; i--)
        {
            cus.setId(utils.CommonUtils.uuid());
            dao.addCustomer(cus);
        }


        PageBean<Customer> pb = dao.query(cus, 1, 100);
        System.out.println("总共：" + pb.getToTalRecords());
        int i = 1;
        for (Customer item : pb.getBeanList()) {
            System.out.println(i + ":---" + item.toString());
            i++;
        }

    }

    public void addCustomer(Customer c) {
        try {

            String sql = "insert into t_customer values(?,?,?,?,?,?)";
            Object[] params = {c.getId(), c.getName(), c.getGender(),
                    c.getPhone(), c.getEmail(), c.getDescription()};

            eqr.update(utils.DataSourceUtils.getConnection(), sql, params);
            WLoger.getInstance().loger("加入客户成功");


        } catch (SQLException e) {
            e.printStackTrace();
            WLoger.getInstance().errorLoger("加入客户消息时出错了");
        }
    }

    public void updateCustomer(Customer c) {
        try {
            QueryRunner qr = new QueryRunner();
            String sql = "insert into t_customer values(?,?,?,?,?,?)";
            Object[] params = {c.getId(), c.getName(), c.getGender(),
                    c.getPhone(), c.getEmail(), c.getDescription()};
            qr.update(ConnectionContext.getInstance().getConnection(), sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Customer find(String id) {
        try {

            QueryRunner qr = new QueryRunner();
            String sql = "select * from t_customer where id=?";
            Object[] params = {id};
            return qr.query(ConnectionContext.getInstance().getConnection(), sql, new BeanHandler<>(Customer.class), params);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;//失败返回null
        }

    }

    public void queryCustomer() throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from t_customer;";
        Customer bean = qr.query(sql, new BeanHandler<>(Customer.class));

        System.out.println(bean);
    }

    //根据当前页码，返回一页符合的customer
    public PageBean<Customer> query(Customer customer, int currentPageCode, int pageRecords) {
        try {
            PageBean<Customer> pb = new PageBean<>();

            pb.setCurrentPageCode(currentPageCode);
            pb.setPeerPageRecords(pageRecords);
            List<Object> params = new ArrayList<>();

            StringBuilder cntSql = new StringBuilder("select count(*) from t_customer ");
            StringBuilder whereSql = new StringBuilder("where 1=1 ");

            String name = customer.getName();
            if (null != name && !name.trim().isEmpty()) {
                whereSql.append("and name like ? ");
                params.add("%" + name + "%");
            }

            String gender = customer.getGender();
            if (gender != null && !gender.trim().isEmpty()) {
                whereSql.append("and gender=? ");
                params.add(gender);
            }

            String phone = customer.getPhone();
            if (phone != null && !phone.trim().isEmpty()) {
                whereSql.append("and phone like ? ");
                params.add("%" + phone + "%");
            }

            String email = customer.getEmail();
            if (email != null && !email.trim().isEmpty()) {
                whereSql.append("and email like ? ");
                params.add("%" + email + "%");
            }

            Number num = (Number) eqr.query(cntSql.append(whereSql).append(";").toString(), new ScalarHandler<>(), params.toArray());
            int tr = num.intValue();
            pb.setTotalRecords(tr);
            pb.setTotalPage(pb.calTotalPage(pb.getToTalRecords(), pb.getPeerPageRecords())); //设置总页数


            StringBuilder sql = new StringBuilder("select * from t_customer ");
            StringBuilder limitSql = new StringBuilder("limit ?,? ");

            params.add((currentPageCode - 1) * pageRecords); //查询当前页的起点
            params.add(pageRecords); //从当前页的起点查询查询了多个记录

            List<Customer> beanList = eqr.query(
                    sql.append(whereSql).append(limitSql).append(";").toString(),
                    new BeanListHandler<Customer>(Customer.class),
                    params.toArray());

            pb.setBeanList(beanList);
            return pb;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public long queryCount(Customer customer) {
        try {
            List<Object> params = new ArrayList<>();

            StringBuilder cntSql = new StringBuilder("select count(*) from t_customer ");
            StringBuilder whereSql = new StringBuilder("where 1=1 ");

            String name = customer.getName();
            if (null != name && !name.trim().isEmpty()) {
                whereSql.append("and name like ? ");
                params.add("%" + name + "%");
            }

            String gender = customer.getGender();
            if (gender != null && !gender.trim().isEmpty()) {
                whereSql.append("and gender=? ");
                params.add(gender);
            }

            String phone = customer.getPhone();
            if (phone != null && !phone.trim().isEmpty()) {
                whereSql.append("and phone like ? ");
                params.add("%" + phone + "%");
            }

            String email = customer.getEmail();
            if (email != null && !email.trim().isEmpty()) {
                whereSql.append("and email like ? ");
                params.add("%" + email + "%");
            }

            Number num = (Number) eqr.query(cntSql.append(whereSql).append(";").toString(), new ScalarHandler<>(), params.toArray());

            return num.longValue();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }

    }
}