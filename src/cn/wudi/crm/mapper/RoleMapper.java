package cn.wudi.crm.mapper;

import java.util.List;

import cn.wudi.crm.domain.Role;
import cn.wudi.crm.domain.RolePermission;

public interface RoleMapper extends BaseMapper<Role>{
//	在角色表中，保存角色和角色下的权限，需要写保存角色权限的中间表
	void saveRolePermission(List<RolePermission> list);  // 需要传一个集合--》对象里面有角色和权限
//	在删除角色时，还得要要删除角色和角色权限的中间表的数据
	void deleteRolePermission(Long roleId);
	//根据用户获取用户的所有角色
	List<Role> getRolesByUser(Long id);
}
