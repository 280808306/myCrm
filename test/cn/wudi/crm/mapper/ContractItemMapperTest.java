package cn.wudi.crm.mapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.wudi.crm.query.ContractItemQuery;
import cn.wudi.crm.test.BaseSpringTest;

public class ContractItemMapperTest extends BaseSpringTest {
	
	@Autowired
	private ContractItemMapper mapper;
	
	@Test
	public void testGetList() throws Exception {
		ContractItemQuery query = new ContractItemQuery();
		query.setContractId(1L);
		System.out.println(mapper.getList(query));
	}

}
