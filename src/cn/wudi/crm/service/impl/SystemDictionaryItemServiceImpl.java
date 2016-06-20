package cn.wudi.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wudi.crm.aop.LogInfo;
import cn.wudi.crm.domain.SystemDictionaryItem;
import cn.wudi.crm.mapper.SystemDictionaryItemMapper;
import cn.wudi.crm.service.ISystemDictionaryItemService;


@Service
@LogInfo("数据字典详细")
public class SystemDictionaryItemServiceImpl extends BaseServiceImpl<SystemDictionaryItem> implements ISystemDictionaryItemService {

	private SystemDictionaryItemMapper systemDictionaryItemMapper;
	
	@Autowired
	public SystemDictionaryItemServiceImpl(SystemDictionaryItemMapper systemDictionaryItemMapper) {
		super(systemDictionaryItemMapper);
		this.systemDictionaryItemMapper = systemDictionaryItemMapper;
	}

	@Override
	@LogInfo("通过字典获取详细")
	public List<SystemDictionaryItem> getByParentId(Long parentId) {
		return systemDictionaryItemMapper.getByParentId(parentId);
	}

}
