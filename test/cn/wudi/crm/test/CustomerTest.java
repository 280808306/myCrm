package cn.wudi.crm.test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.wudi.crm.domain.Customer;
import cn.wudi.crm.domain.Employee;
import cn.wudi.crm.mapper.CustomerMapper;
import cn.wudi.crm.query.CustomerQuery;
import cn.wudi.crm.service.ICustomerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CustomerTest {
	@Autowired
	private ICustomerService customerService;
	
	@Autowired
	CustomerMapper customerMapper;
	
	@Test
	public void testName() throws Exception {
		customerMapper.createTable();
		Customer customer = new Customer();
		for (int i = 0; i < 51; i++) {
			customer.setName("就是干"+i);
			customer.setAge(22);
			customer.setGender(1);
			customer.setTel(12312312);
			customer.setInputTime(new Date());
			Employee emp = new Employee();
			emp.setId(1L);
			customer.setSeller(emp);
			customer.setInputUser(emp);
			customerService.save(customer);
		}
	}
	@Test
	public void testUpdate() throws Exception {
		Customer customer = new Customer();
		customer.setName("就是干111111");
		customer.setAge(222);
		customer.setGender(11);
		customer.setTel(12312312);
		customer.setInputTime(new Date());
		customer.setId(1L);
		customerService.update(customer);
	}
	@Test
	public void testDelete() throws Exception {
		customerService.delete(10L);
	}
	@Test
	public void testGet() throws Exception {
		Customer customer = customerService.get(26L);
		System.out.println(customer);
	}
	@Test
	public void testAll() throws Exception {
		CustomerQuery query = new CustomerQuery();
//		PageData<Customer> page = customerService.getPage(query);
//		System.out.println(page);
	}
}
