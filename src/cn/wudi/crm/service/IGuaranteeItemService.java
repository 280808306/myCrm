package cn.wudi.crm.service;

import java.util.List;

import cn.wudi.crm.domain.GuaranteeItem;

public interface IGuaranteeItemService extends IBaseService<GuaranteeItem> {

	List<GuaranteeItem> getListByParent(Long id);

}
