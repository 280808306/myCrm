package cn.wudi.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wudi.crm.aop.LogInfo;
import cn.wudi.crm.domain.Order;
import cn.wudi.crm.mapper.OrderMapper;
import cn.wudi.crm.service.IOrderService;

@LogInfo("订单")
@Service
public class OrderServiceImpl extends BaseServiceImpl<Order> implements IOrderService {

	@Autowired
	public OrderServiceImpl(OrderMapper mapper) {
		super(mapper);
	}
	
	

}
