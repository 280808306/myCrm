package cn.wudi.crm.service;

import java.util.List;

import cn.wudi.crm.domain.SystemDictionaryItem;

public interface ISystemDictionaryItemService extends IBaseService<SystemDictionaryItem> {

	List<SystemDictionaryItem> getByParentId(Long parentId);
	
}
