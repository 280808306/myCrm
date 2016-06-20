package cn.wudi.crm.mapper;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.wudi.crm.domain.CustomerDevPlan;
import cn.wudi.crm.domain.Employee;
import cn.wudi.crm.domain.SystemDictionaryItem;
import cn.wudi.crm.test.BaseSpringTest;

public class CustomerDevPlanMapperTest extends BaseSpringTest {
	
	@Autowired
	private CustomerDevPlanMapper customerDevPlanMapper;
	
	@Test
	public void testSave() throws Exception {
		customerDevPlanMapper.createTable();
		for (int i = 1; i < 51; i++) {
			
		CustomerDevPlan devPlan = new CustomerDevPlan();
		devPlan.setPlanSubject("aaaaa"+i);
		devPlan.setPlanDetails("bbbb"+i);
		
		SystemDictionaryItem item = new SystemDictionaryItem();
		item.setId(1L);
		devPlan.setPlanType(item);
		
		Employee inputUser = new Employee();
		inputUser.setId(1L);
		devPlan.setInputUser(inputUser);
		devPlan.setInputTime(new Date());
		customerDevPlanMapper.save(devPlan);
		System.out.println(devPlan);
	}
	}
	@Test
	public void testGet() {
		System.out.println(customerDevPlanMapper.get(2L));
	}
	
	@Test
	public void testUpdate() throws Exception {
		CustomerDevPlan devPlan = customerDevPlanMapper.get(2L);
		devPlan.setPlanDetails("dfdsafdf");
		customerDevPlanMapper.update(devPlan);
	}

}
