package cn.wudi.crm.test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.wudi.crm.domain.Customer;
import cn.wudi.crm.domain.CustomerTraceHistory;
import cn.wudi.crm.domain.Employee;
import cn.wudi.crm.service.ICustomerTraceHistoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CustomerTraceHistoryTest {
	@Autowired
	private ICustomerTraceHistoryService customerTraceHistoryService;
	@Test
	public void testName() throws Exception {
		CustomerTraceHistory cth = new CustomerTraceHistory();
		Customer cus = new Customer();
		Employee emp = new Employee(); 
		for (int i = 0; i < 10; i++) {
			cth.setTraceTime(new Date());
			emp.setId(1L);
			cth.setTraceUser(emp);
			cus.setId(36L);
			cth.setCustomer(cus);
			cth.setTitle("就是干" + i);
			cth.setRemark("改变"+i);
			Customer customer = new Customer();
			customer.setId(1L);
			cth.setCustomer(customer);
			cth.setTraceResult(i);
			customerTraceHistoryService.save(cth);
		}
	}
	@Test
	public void testupdate() throws Exception {
		CustomerTraceHistory cth = new CustomerTraceHistory();
			cth.setTraceTime(new Date());
			cth.setTitle("修改后的数据");
			cth.setRemark("改变");
			cth.setTraceResult(232);
			cth.setId(2L);
			customerTraceHistoryService.update(cth);
	}
	@Test
	public void testDelete() throws Exception {
		customerTraceHistoryService.delete(3L);
	}
	@Test
	public void testGet() throws Exception {
//		CustomerTraceHistoryQuery query = new CustomerTraceHistoryQuery();
//		query.setRemark("qq");
//		 List<CustomerTraceHistory> rows = customerTraceHistoryService.queryList(query);
//		 for (CustomerTraceHistory customerTraceHistory : rows) {
//			System.out.println(customerTraceHistory);
//		}
	}
}
