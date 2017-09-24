package customerSys.service;
import customerSys.domain.Customer;
import customerSys.dao.CustomerDao;
import customerSys.domain.PageBean;

/**
 * Created by 28029 on 2017/9/12.
 */

//提供增删查改的服务

public class CustomerService {
   private CustomerDao cusDao = new CustomerDao();
   public void addCustomer(Customer iCustomer) {
         cusDao.addCustomer(iCustomer);
   }

   public void deleteCustomer(Customer iCustomer){

   }

   public void editCustomer(Customer iCustomer){

   }

   public Customer  queryCustomer(String id){
         return cusDao.find(id);
   }

   public PageBean<Customer> query(Customer customer, int currentPageCode, int pageRecords)
   {
      return cusDao.query(customer, currentPageCode, pageRecords);
   }

   public long queryCount(customerSys.domain.Customer customer){
      return cusDao.queryCount(customer);
   }

}
