package cn.wudi.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wudi.crm.domain.Customer;
import cn.wudi.crm.mapper.CustomerMapper;
import cn.wudi.crm.mapper.CustomerTraceHistoryMapper;
import cn.wudi.crm.mapper.CutomerTransferMapper;
import cn.wudi.crm.service.ICustomerService;
@Service
public class CustomerServiceImpl extends BaseServiceImpl<Customer> implements ICustomerService{
	private CustomerMapper customerMapper;
	private CustomerTraceHistoryMapper customerTraceHistoryMapper;
	private CutomerTransferMapper cutomerTransferMapper;
	@Autowired
	public CustomerServiceImpl(CustomerMapper customerMapper) {
		super(customerMapper);
		this.customerMapper=customerMapper;
	}
	@Override
	public void delete(Long id){
		super.delete(id);
//		customerTraceHistoryMapper.deleteCustomerTraceHistory(id);
//		cutomerTransferMapper.deleteCutomerTransfer(id);
	}
//	@Override
//	public void update(Customer customer){
//		super.update(customer);
//	}
}
