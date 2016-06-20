package cn.wudi.crm.mapper;

import java.util.List;

import cn.wudi.crm.domain.GuaranteeItem;

public interface GuaranteeItemMapper extends BaseMapper<GuaranteeItem> {

	List<GuaranteeItem> getListByParent(Long id);

}
