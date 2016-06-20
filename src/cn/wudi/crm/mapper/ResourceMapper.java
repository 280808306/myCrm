package cn.wudi.crm.mapper;

import java.util.List;

import cn.wudi.crm.domain.PageData;
import cn.wudi.crm.domain.Resource;
import cn.wudi.crm.query.ResourceQuery;

public interface ResourceMapper extends BaseMapper<Resource> {
	
	/**
	 * 获取含有url的资源的数量
	 */
	public Integer getCountByUrl(String url);
	
	/**
	 * 添加多条数据
	 * @param resources
	 */
	public void saveList(List<Resource> resources);

	public void deleteList(List<Resource> resources);
	/**
	 * 查询出没有添加到权限的资源
	 */
	public List<Resource> findResource(ResourceQuery query);
	
	public Integer getCountByfindResource(ResourceQuery query);
	
}
