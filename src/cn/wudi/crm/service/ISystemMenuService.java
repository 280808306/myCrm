package cn.wudi.crm.service;

import java.util.List;

import cn.wudi.crm.domain.Employee;
import cn.wudi.crm.domain.SystemMenu;

public interface ISystemMenuService extends IBaseService<SystemMenu> {
	
	/**
	 * 获取当前用户的所有菜单
	 * @param employee 当前用户
	 */
	List<SystemMenu> getUserMenus(Employee employee);
}
