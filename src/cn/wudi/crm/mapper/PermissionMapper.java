package cn.wudi.crm.mapper;

import java.util.List;

import cn.wudi.crm.domain.Permission;
import cn.wudi.crm.domain.Resource;

public interface PermissionMapper extends BaseMapper<Permission> {
//	传一个角色的id，得到这个角色下拥有的权限的集合
	List<Permission> getPermissions(Long roleId);
	/**
	 * 添加多条数据
	 * @param Permission
	 */
	public void saveList(List<Resource> permission);

	/**
	 * 删除多条数据
	 * @param Permission
	 */
	public void deleteList(List<Permission> permission);
	
	
	Permission getPermissionByResourceUrl(String resourceUrl);
	
	List<Permission> getPermissionByUser(Long id);
	
}
