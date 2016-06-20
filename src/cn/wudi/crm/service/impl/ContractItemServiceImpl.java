package cn.wudi.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wudi.crm.aop.LogInfo;
import cn.wudi.crm.domain.ContractItem;
import cn.wudi.crm.mapper.ContractItemMapper;
import cn.wudi.crm.service.IContractItemService;

@LogInfo("合同详细")
@Service
public class ContractItemServiceImpl extends BaseServiceImpl<ContractItem> implements IContractItemService {

	private ContractItemMapper contractItemMapper;

	@Autowired
	public ContractItemServiceImpl(ContractItemMapper mapper) {
		super(mapper);
		this.contractItemMapper = mapper;
	}

	@LogInfo("依据合同获取详细")
	@Override
	public List<ContractItem> getListByParent(Long id) {
		return contractItemMapper.getListByParent(id);
	}

}
