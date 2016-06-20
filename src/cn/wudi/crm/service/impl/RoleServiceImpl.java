package cn.wudi.crm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wudi.crm.domain.Employee;
import cn.wudi.crm.domain.Permission;
import cn.wudi.crm.domain.Role;
import cn.wudi.crm.domain.RolePermission;
import cn.wudi.crm.mapper.RoleMapper;
import cn.wudi.crm.service.IRoleService;
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements IRoleService{
	private RoleMapper mapper;
	@Autowired
	public RoleServiceImpl(RoleMapper mapper) {
		super(mapper);
		this.mapper=mapper;
		// TODO Auto-generated constructor stub
	}
	public void save(Role role) {
		// TODO Auto-generated method stub
		// 保存角色，返回新id
		mapper.save(role);
		// 保存中间表
		saveRolePermission(role);
	}

	/**
	 * 保存角色和权限的关联（中间表）信息
	 * @param role
	 */
	private void saveRolePermission(Role role) {
		// 获取待添加的权限
		List<Permission> permissions = role.getPermissions();
		// 判断是否有关联权限
		if(permissions!=null && !permissions.isEmpty()){
			Long roleId = role.getId();
			// 声明集合
			List<RolePermission> list = new ArrayList<>();
			// 遍历
			for (Permission permission : permissions) {
				// 新建关联对象
				RolePermission link = new RolePermission();
				link.setRoleId(roleId);
				link.setPermissionId(permission.getId());
				// 把新关联信息添加到集合中
				list.add(link);
			}
			// 保存关联信息
			mapper.saveRolePermission(list);
		}
		
	}

	public void update(Role role) {
		// TODO Auto-generated method stub
		mapper.update(role);
		
		// 清除中间表信息
		mapper.deleteRolePermission(role.getId());
		// 保存中间表
		saveRolePermission(role);
	}

	public void delete(Long id) {
		mapper.delete(id);
		
		// 清除中间表
		mapper.deleteRolePermission(id);
	}
	@Override
	public List<Role> getRolesByUser(Employee employee) {
		return mapper.getRolesByUser(employee.getId());
	}
}
