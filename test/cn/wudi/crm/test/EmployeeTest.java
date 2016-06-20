package cn.wudi.crm.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.wudi.crm.domain.Employee;
import cn.wudi.crm.service.IEmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class EmployeeTest {
	@Autowired
	private IEmployeeService Service;
	@Test
	public void testName() throws Exception {
		Employee em = new Employee();
		em.setUsername("及时干");
		em.setPassword("sadasdas");
		em.setRealName("dasdada");
		Service.save(em);
	}
}
