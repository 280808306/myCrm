package cn.wudi.crm.service;

import java.util.List;

import cn.wudi.crm.domain.ContractItem;

public interface IContractItemService extends IBaseService<ContractItem> {

	List<ContractItem> getListByParent(Long id);

}
