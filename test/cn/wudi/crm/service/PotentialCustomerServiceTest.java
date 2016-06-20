package cn.wudi.crm.service;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.wudi.crm.domain.Employee;
import cn.wudi.crm.domain.PotentialCustomer;
import cn.wudi.crm.test.BaseSpringTest;

public class PotentialCustomerServiceTest extends BaseSpringTest {

	@Autowired
	private IPotentialCustomerService potentialCustomerService;
	
	@Test
	public void testSave() {
		for (int i = 0; i < 50; i++) {
			PotentialCustomer customer = new PotentialCustomer();
			customer.setName("tom"+i);
			customer.setRemark("sdf"+i);
			customer.setInputTime(new Date());
			Employee inputUser = new Employee();
			inputUser.setId(1L);
			customer.setInputUser(inputUser);
			customer.setSuccessRate(70.0F);
			potentialCustomerService.save(customer);
		}

	}

	@Test
	public void testUpdate() {

	}

	@Test
	public void testDelete() {

	}

	@Test
	public void testGetPage() {

	}

	@Test
	public void testGet() {
		System.out.println(potentialCustomerService.get(1L));
	}

}
