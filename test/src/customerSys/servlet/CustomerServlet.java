package customerSys.servlet;

import customerSys.domain.Customer;
import customerSys.domain.PageBean;
import customerSys.service.CustomerService;
import utils.BaseServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import utils.CommonUtils;
import utils.WLoger;

/**
 * Created by 28029 on 2017/9/18.
 */
@WebServlet(name = "CustomerServlet")
public class CustomerServlet extends BaseServlet {
    private CustomerService customerService = new CustomerService();

    public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Customer customer = utils.CommonUtils.toBean(request.getParameterMap(), Customer.class);
        customer.setId(utils.CommonUtils.uuid());

        customerService.addCustomer(customer);


        request.setAttribute("msg", "恭喜，成功添加客户");
        utils.WLoger.getInstance().loger("调用成功");
        return "f:/index.jsp";
    }

    public String query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer customer = utils.CommonUtils.toBean(request.getParameterMap(), Customer.class);
        customer = encoding(customer);

        int pc = getPc(request);
        int pr = 10;

        long countValue = customerService.queryCount(customer);
        long totalPage = PageBean.calTotalPage(countValue, pr);

        //范围界定
        pc = pc >totalPage? (int) totalPage :pc;
        pc = pc <=0 ? 1:pc;


        PageBean<Customer> pb = customerService.query(customer, pc, pr);
        pb.setUrl(getUrl(request));
        request.setAttribute("pb", pb);
        return "/listCustomer.jsp";

    }

    /**
     * @Decription 对Customer中的内容进行utf-8编码
     * @param customer
     * @return
     * @throws UnsupportedEncodingException
     */

    private Customer encoding(Customer customer) throws UnsupportedEncodingException {
        String name = customer.getName();
        String gender = customer.getGender();
        String phone = customer.getPhone();
        String email = customer.getEmail();

        if (name != null && !name.trim().isEmpty()) {
            name = new String(name.getBytes("ISO-8859-1"), "utf-8");
            customer.setName(name);
        }
        if (gender != null && !gender.trim().isEmpty()) {
            gender = new String(gender.getBytes("ISO-8859-1"), "utf-8");
            customer.setGender(gender);
        }
        if (phone != null && !phone.trim().isEmpty()) {
            phone = new String(phone.getBytes("ISO-8859-1"), "utf-8");
            customer.setPhone(phone);
        }
        if (email != null && !email.trim().isEmpty()) {
            email = new String(email.getBytes("ISO-8859-1"), "utf-8");
            customer.setEmail(email);
        }
        return customer;
    }
    /**
     * @Description:将请求中的&'pc='去掉，去掉一个请求参数
     * @param request
     * @return
     */
    private String getUrl(HttpServletRequest request){
        String contextPath = request.getContextPath();
        String servletPath = request.getServletPath();
        String queryString = request.getQueryString();

        if(queryString.contains("&pc=")){
            int index = queryString.lastIndexOf("&pc=");
            queryString = queryString.substring(0, index);
        }

        return contextPath + servletPath + "?" + queryString;

    }

    //获取pc的值，pc是当前页码：pageCurrent
    //pr:每页记录数
    private int getPc(HttpServletRequest request) {
        String value = request.getParameter("pc");
        if (value == null || value.trim().isEmpty()) {
            return 1;
        }
        return Integer.parseInt(value);
    }
}
