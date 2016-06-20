package cn.wudi.crm.mapper;

import java.util.List;

import cn.wudi.crm.domain.Employee;
import cn.wudi.crm.domain.SystemMenu;

public interface SystemMenuMapper extends BaseMapper<SystemMenu> {
	/**
	 * 获取当前用户的菜单
	 */
	List<SystemMenu> getUserMenus(Employee employee);
}	
