package cn.wudi.crm.mapper;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.wudi.crm.domain.Employee;
import cn.wudi.crm.domain.SystemMenu;
import cn.wudi.crm.test.BaseSpringTest;

public class SystemMenuMapperTest extends BaseSpringTest {
	
	@Autowired
	SystemMenuMapper systemMenuMapper;

	@Test
	public void testGetUserMenus() {
		List<SystemMenu> userMenus = systemMenuMapper.getUserMenus(new Employee());
		for (SystemMenu systemMenu : userMenus) {
			System.out.println("一级菜单："+systemMenu);
			System.out.println(systemMenu.getChildren().size());
			for (SystemMenu m : systemMenu.getChildren()) {
				System.out.println("	二级菜单："+m);
			}
		}
	}

}
