package cn.wudi.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wudi.crm.aop.LogInfo;
import cn.wudi.crm.domain.Contract;
import cn.wudi.crm.domain.ContractItem;
import cn.wudi.crm.mapper.ContractItemMapper;
import cn.wudi.crm.mapper.ContractMapper;
import cn.wudi.crm.service.IContractService;

@LogInfo("合同")
@Service
public class ContractServiceImpl extends BaseServiceImpl<Contract> implements IContractService {

	@Autowired
	private ContractItemMapper contractItemMapper;
	
	private ContractMapper contractMapper;
	
	@Autowired
	public ContractServiceImpl(ContractMapper mapper) {
		super(mapper);
		this.contractMapper = mapper;
	}
	
	@LogInfo("合同保存")
	@Override
	public void save(Contract contract) {
		contractMapper.save(contract);
		for (ContractItem item : contract.getDetails()) {
			item.setContract(contract);
			contractItemMapper.save(item);
		}
	}
	
	@LogInfo("合同修改")
	@Override
	public void update(Contract contract) {
		contractMapper.update(contract);
		for (ContractItem item : contractItemMapper.getListByParent(contract.getId())) {
			contractItemMapper.delete(item.getId());
		}
		for (ContractItem item : contract.getDetails()) {
			item.setContract(contract);
			contractItemMapper.save(item);
		}
	}
	
	@LogInfo("合同删除")
	@Override
	public void delete(Long id) {
		contractMapper.delete(id);
		for (ContractItem item : contractItemMapper.getListByParent(id)) {
			contractItemMapper.delete(item.getId());
		}
	}

}
