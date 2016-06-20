package cn.wudi.crm.service;

import java.util.List;

import cn.wudi.crm.domain.Employee;
import cn.wudi.crm.domain.Permission;
import cn.wudi.crm.domain.Resource;


public interface IPermissionService extends IBaseService<Permission> {
//	传一个角色的id，得到这个角色下拥有的权限的集合
	List<Permission> getPermissions(Long roleId);
	/**
	 * 添加多个权限
	 */
	public void saveList(List<Resource> permission);
	
	/**
	 * 删除多个权限
	 */
	public void deleteList(List<Permission> permission);
	/**
	 * 根据资源查询权限
	 * @param resourceUrl
	 * @return
	 */
	Permission getPermissionByResourceUrl(String resourceUrl);
	/**
	 * 根据用户信息获取用户权限
	 * @param employee
	 * @return
	 */
	List<Permission> getPermissionByUser(Employee employee);
	
}
