package cn.wudi.crm.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.wudi.crm.domain.Permission;
import cn.wudi.crm.mapper.PermissionMapper;
import cn.wudi.crm.query.PermissionQuery;
import cn.wudi.crm.service.IPermissionService;

public class PermissionTest extends BaseSpringTest {

	@Autowired
	IPermissionService permissionService;
	
	@Autowired
	PermissionMapper permissionMapper;
	
	@Test
	public void testSave() {
		permissionMapper.createTable();
		for (int i = 1; i < 51; i++) {
			Permission permission = new Permission();
			permission.setName("权限"+i);
			permission.setResource("resource");
			permissionService.save(permission);
		}
	}
	
	@Test
	public void testDelete() {
			permissionService.delete(9L);
	}
	
	@Test
	public void testUpdate() {
		Permission permission = new Permission();
		permission.setId(1L);
		permission.setName("权限");
		permission.setResource("111");
		permissionService.update(permission);
	}
	
	@Test
	public void testGet() {
		System.out.println(permissionService.get(1L));
	}
	
	@Test
	public void testGetAll() {
		PermissionQuery query = new PermissionQuery();
		
		System.out.println(permissionService.getPage(query).getRows());
	}
	
}
