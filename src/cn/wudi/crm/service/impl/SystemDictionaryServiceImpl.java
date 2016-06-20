package cn.wudi.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wudi.crm.aop.LogInfo;
import cn.wudi.crm.domain.SystemDictionary;
import cn.wudi.crm.domain.SystemDictionaryItem;
import cn.wudi.crm.mapper.SystemDictionaryItemMapper;
import cn.wudi.crm.mapper.SystemDictionaryMapper;
import cn.wudi.crm.service.ISystemDictionaryService;


@Service
@LogInfo("数据字典")
public class SystemDictionaryServiceImpl extends BaseServiceImpl<SystemDictionary> implements ISystemDictionaryService {

	private SystemDictionaryMapper systemDictionaryMapper;
	
	@Autowired
	private SystemDictionaryItemMapper systemDictionaryItemMapper;
	
	@Autowired
	public SystemDictionaryServiceImpl(SystemDictionaryMapper systemDictionaryMapper) {
		super(systemDictionaryMapper);
		this.systemDictionaryMapper = systemDictionaryMapper;
	}
	
	@Override
	@LogInfo("数据字典删除")
	public void delete(Long id) {
		//删除字典
		super.delete(id);
		//删除字典详细
		systemDictionaryItemMapper.deleteByParentId(id);
	}

}
