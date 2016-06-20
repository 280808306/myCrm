package cn.wudi.crm.mapper;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.wudi.crm.domain.Customer;
import cn.wudi.crm.domain.Order;
import cn.wudi.crm.test.BaseSpringTest;

public class OrderMapperTest extends BaseSpringTest {
	
	@Autowired
	private OrderMapper orderMapper;
	
	@Test
	public void testSave() throws Exception {
		Order order = new Order();
		order.setSn("005");
		order.setIntro("fgsdfgdslj");
		order.setSignTime(new Date());
		order.setSum(new BigDecimal(50000000));
		order.setCustomer(new Customer());
		order.getCustomer().setId(2L);
		
		orderMapper.save(order);
	}
	
	@Test
	public void testGet() throws Exception {
		System.out.println(orderMapper.get(1L));
	}

}
