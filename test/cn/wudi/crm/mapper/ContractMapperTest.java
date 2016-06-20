package cn.wudi.crm.mapper;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.wudi.crm.domain. Contract;
import cn.wudi.crm.domain.Customer;
import cn.wudi.crm.test.BaseSpringTest;

public class ContractMapperTest extends BaseSpringTest {
	
	@Autowired
	private  ContractMapper contractMapper;
	
	@Test
	public void testSave() throws Exception {
		Contract contract = new  Contract();
		contract.setSn("005");
		contract.setIntro("fgsdfgdslj");
		contract.setSignTime(new Date());
		contract.setSum(new BigDecimal(50000000));
		contract.setCustomer(new Customer());
		contract.getCustomer().setId(2L);
		
		contractMapper.save(contract);
	}
	
	@Test
	public void testGet() throws Exception {
		System.out.println(contractMapper.get(1L));
	}

}
