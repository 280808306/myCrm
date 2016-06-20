package cn.wudi.crm.mapper;

import java.util.List;

import cn.wudi.crm.domain.Customer;
import cn.wudi.crm.query.CustomerQuery;

public interface CustomerMapper extends BaseMapper<Customer>{

	List<Customer> queryList(CustomerQuery query);
	
}
