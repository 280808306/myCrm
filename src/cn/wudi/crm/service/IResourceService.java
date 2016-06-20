package cn.wudi.crm.service;

import java.util.List;

import cn.wudi.crm.domain.PageData;
import cn.wudi.crm.domain.Resource;
import cn.wudi.crm.domain.SystemMenu;
import cn.wudi.crm.query.ResourceQuery;


public interface IResourceService extends IBaseService<Resource> {
	
	/**
	 * 获取所有的控制器类名
	 */
	public List<SystemMenu> getResourceTypeNames();
	
	/**
	 * 获取类上的资源
	 */
	public List<Resource> getTypeResources(String typeName);
	
	/**
	 * 添加多个资源
	 */
	public void saveList(List<Resource> resources);

	/**
	 * 删除多个资源
	 */
	public void deleteList(List<Resource> resources);
	
	/**
	 * 拿到没有添加到权限的资源
	 */
	public PageData<Resource> findResource(ResourceQuery query);
	
}
