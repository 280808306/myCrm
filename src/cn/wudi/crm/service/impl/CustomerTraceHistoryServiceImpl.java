package cn.wudi.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wudi.crm.domain.CustomerTraceHistory;
import cn.wudi.crm.mapper.CustomerMapper;
import cn.wudi.crm.mapper.CustomerTraceHistoryMapper;
import cn.wudi.crm.query.CustomerTraceHistoryQuery;
import cn.wudi.crm.service.ICustomerTraceHistoryService;
@Service
public class CustomerTraceHistoryServiceImpl extends BaseServiceImpl<CustomerTraceHistory> implements ICustomerTraceHistoryService{
	private CustomerTraceHistoryMapper customerTraceHistoryMapper;
	@Autowired
	public CustomerTraceHistoryServiceImpl(CustomerTraceHistoryMapper customerTraceHistoryMapper) {
		super(customerTraceHistoryMapper);
		this.customerTraceHistoryMapper=customerTraceHistoryMapper;
	}
}
