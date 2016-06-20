package cn.wudi.crm.service;

import java.util.List;

import cn.wudi.crm.domain.Employee;
import cn.wudi.crm.domain.Role;

public interface IRoleService extends IBaseService<Role>{


////	在角色表中，保存角色和角色下的权限，需要写保存角色权限的中间表
//	void saveRolePermission(List<RolePermission> list);  // 需要传一个集合--》对象里面有角色和权限
////	在删除角色时，还得要要删除角色和角色权限的中间表的数据
//	void deleteRolePermission(Long roleId);
	//获取用户的所有权限
	List<Role> getRolesByUser(Employee employee);
}
