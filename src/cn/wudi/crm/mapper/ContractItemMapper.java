package cn.wudi.crm.mapper;

import java.util.List;

import cn.wudi.crm.domain.ContractItem;

public interface ContractItemMapper extends BaseMapper<ContractItem> {

	List<ContractItem> getListByParent(Long id);

}
