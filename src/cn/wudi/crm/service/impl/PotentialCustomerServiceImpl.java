package cn.wudi.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wudi.crm.aop.LogInfo;
import cn.wudi.crm.domain.PotentialCustomer;
import cn.wudi.crm.mapper.PotentialCustomerMapper;
import cn.wudi.crm.service.IPotentialCustomerService;

@LogInfo("潜在客户")
@Service
public class PotentialCustomerServiceImpl extends BaseServiceImpl<PotentialCustomer>
		implements IPotentialCustomerService {

//	private PotentialCustomerMapper potentialCustomerMapper;

	@Autowired
	public PotentialCustomerServiceImpl(PotentialCustomerMapper potentialCustomerMapper) {
		super(potentialCustomerMapper);
//		this.potentialCustomerMapper = potentialCustomerMapper;
	}

}
