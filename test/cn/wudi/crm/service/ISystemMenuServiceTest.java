package cn.wudi.crm.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.wudi.crm.domain.PageData;
import cn.wudi.crm.domain.SystemMenu;
import cn.wudi.crm.query.SystemMenuQuery;
import cn.wudi.crm.test.BaseSpringTest;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ISystemMenuServiceTest extends BaseSpringTest {

	@Autowired
	ISystemMenuService systemMenuService;
	
	@Test
	public void testSave() {
		for (int i = 1; i < 51; i++) {
			SystemMenu menu = new SystemMenu();
			menu.setName("菜单"+i);
			menu.setSn("sn----"+i);
			menu.setIcon("/upload/menu.png");
			menu.setUrl("/xxx/xxx");
			menu.setIntro("菜单描述"+i);
			systemMenuService.save(menu);
			System.out.println(menu);
		}
	}
	
	@Test
	public void testGetByQuery() throws Exception {
		PageData<SystemMenu> pageData = systemMenuService.getPage(new SystemMenuQuery());
		for (SystemMenu menu : pageData.getRows()) {
			System.out.println(menu.getParent());
		}
		ObjectMapper mapper = new ObjectMapper();
		System.out.println("json " + mapper.writeValueAsString(pageData.getRows()));
	}
}
