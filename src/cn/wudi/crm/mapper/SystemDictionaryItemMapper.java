package cn.wudi.crm.mapper;

import java.util.List;

import cn.wudi.crm.domain.SystemDictionaryItem;

/**
 * 
 * 数据字典
 * @author zh
 */
public interface SystemDictionaryItemMapper extends BaseMapper<SystemDictionaryItem> {
	
	/**
	 * 根据父类的id来删除 所有字典详细 确定该字典删除后执行   
	 * @param id
	 */
	void deleteByParentId(Long id);

	/**
	 * 根据字典明细的父 类查询 字典详细
	 * @param parentId
	 * @return
	 */
	List<SystemDictionaryItem> getByParentId(Long parentId);
}
