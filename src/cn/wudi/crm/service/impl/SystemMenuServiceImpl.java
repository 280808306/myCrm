package cn.wudi.crm.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wudi.crm.aop.LogInfo;
import cn.wudi.crm.domain.Employee;
import cn.wudi.crm.domain.Permission;
import cn.wudi.crm.domain.SystemMenu;
import cn.wudi.crm.mapper.SystemMenuMapper;
import cn.wudi.crm.service.ISystemMenuService;
import cn.wudi.crm.utils.UserContext;

@Service
@LogInfo("系统菜单")
public class SystemMenuServiceImpl extends BaseServiceImpl<SystemMenu> implements ISystemMenuService {

	private SystemMenuMapper systemMenuMapper;

	@Autowired
	public SystemMenuServiceImpl(SystemMenuMapper systemMenuMapper) {
		super(systemMenuMapper);
		this.systemMenuMapper = systemMenuMapper;
	}

	/**
	 * 获取当前用户的菜单
	 */
	@LogInfo("获取当前用户的菜单")
	@Override
	public List<SystemMenu> getUserMenus(Employee employee) {
		// 查询出当前用户所有菜单
		List<SystemMenu> userMenus = this.systemMenuMapper.getUserMenus(employee);
		if(UserContext.getUser().getUsername().equals("admin")){
			return userMenus;
		}
		//遍历一级菜单
		Iterator<SystemMenu> parentItera = userMenus.iterator();
		while (parentItera.hasNext()) {
			//获取父菜单
			SystemMenu parent = parentItera.next();
			//获取子菜单
			List<SystemMenu> children = parent.getChildren();
			System.out.println("P: " + parent);
			//遍历子菜单 
			Iterator<SystemMenu> childItera = children.iterator();
			while (childItera.hasNext()) {
				SystemMenu child = childItera.next();
				//判断子菜单是否拥有权限
				Permission permission = child.getPermission();
				//子菜单没有权限
				if(permission == null || !UserContext.hasPermission(permission)){
					System.out.println("移除" + child);
					System.out.println("权限" + child.getPermission());
					//移除子菜单
					childItera.remove();
				}
			}
			
			//如果没有子菜单则移除
			if(children.size() == 0){
				//父菜单移除
				parentItera.remove();
			}
		}
		
		return userMenus;
	}

}
