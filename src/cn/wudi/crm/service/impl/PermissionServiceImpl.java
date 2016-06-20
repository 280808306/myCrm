package cn.wudi.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wudi.crm.domain.Employee;
import cn.wudi.crm.domain.Permission;
import cn.wudi.crm.domain.Resource;
import cn.wudi.crm.mapper.PermissionMapper;
import cn.wudi.crm.service.IPermissionService;
@Service
public class PermissionServiceImpl extends BaseServiceImpl<Permission> implements IPermissionService{
	private PermissionMapper permissionMapper;
	
	@Autowired
	public PermissionServiceImpl(PermissionMapper permissionMapper) {
		super(permissionMapper);
		this.permissionMapper=permissionMapper;
	}

	@Override
	public void saveList(List<Resource> permission) {
		permissionMapper.saveList(permission);
	}

	@Override
	public void deleteList(List<Permission> permission) {
		permissionMapper.deleteList(permission);
	}

	@Override
	public List<Permission> getPermissions(Long roleId) {
		return permissionMapper.getPermissions(roleId);
	}

	@Override
	public Permission getPermissionByResourceUrl(String resourceUrl) {
		return permissionMapper.getPermissionByResourceUrl(resourceUrl);
	}

	@Override
	public List<Permission> getPermissionByUser(Employee employee) {
		return permissionMapper.getPermissionByUser(employee.getId());
	}

}
