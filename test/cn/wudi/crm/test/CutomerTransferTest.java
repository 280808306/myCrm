package cn.wudi.crm.test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.wudi.crm.domain.Customer;
import cn.wudi.crm.domain.CutomerTransfer;
import cn.wudi.crm.domain.Employee;
import cn.wudi.crm.service.ICutomerTransferService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CutomerTransferTest {
	@Autowired
	private ICutomerTransferService cutomerTransferService;
	@Test
	public void testName() throws Exception {
		CutomerTransfer ct = new CutomerTransfer();
		Customer cus =new Customer();
		Employee emp = new Employee();
		Employee emp1 = new Employee();
		for (int i = 0; i < 10; i++) {
			cus.setId(43L);
			ct.setCustomer(cus);
			emp.setId(1L);
			emp1.setId(2L);
			ct.setTransUser(emp1);
			ct.setNewSeller(emp);
			ct.setOldSeller(emp);
			ct.setTransReason("就是干"+i);
			ct.setTransTime(new Date());
			cutomerTransferService.save(ct);
		}
	}
	@Test
	public void testupdate() throws Exception {
		CutomerTransfer ct = new CutomerTransfer();
		ct.setTransReason("修改后的就是我！~~~~~~~~~");
		ct.setTransTime(new Date());
		ct.setId(2L);
			cutomerTransferService.update(ct);
	}
	@Test
	public void testDelete() throws Exception {
		cutomerTransferService.delete(3L);
	}
	@Test
	public void testGet() throws Exception {
		CutomerTransfer customerTraceHistory = cutomerTransferService.get(1L);
		System.out.println(customerTraceHistory);
	}
}
