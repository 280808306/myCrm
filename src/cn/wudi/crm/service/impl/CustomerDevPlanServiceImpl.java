package cn.wudi.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wudi.crm.aop.LogInfo;
import cn.wudi.crm.domain.CustomerDevPlan;
import cn.wudi.crm.mapper.CustomerDevPlanMapper;
import cn.wudi.crm.service.ICustomerDevPlanService;

@LogInfo("潜在客户开发计划")
@Service
public class CustomerDevPlanServiceImpl extends BaseServiceImpl<CustomerDevPlan> implements ICustomerDevPlanService {

	@Autowired
	public CustomerDevPlanServiceImpl(CustomerDevPlanMapper mapper) {
		super(mapper);
	}

}
