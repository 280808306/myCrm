package cn.wudi.crm.utils;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import cn.wudi.crm.domain.Employee;
import cn.wudi.crm.domain.Permission;
import cn.wudi.crm.domain.Role;
import cn.wudi.crm.service.IPermissionService;
import cn.wudi.crm.service.IRoleService;

@Component
public class UserContext {

	private static IPermissionService permissionService;

	private static IRoleService roleService;
	
	/**
	 * 用户存在session中的key
	 */
	public static final String USER_IN_SESSION = "userInSession";
	
	public static final String VALIDATE_CODE_IN_SESSION = "validateCode";
	
	public static final String[] MANAGER_ROLE_NAMES = {
		"超级管理员","系统管理员"
	};

	@Autowired
	public void setPermissionService(IPermissionService permissionService) {
		UserContext.permissionService = permissionService;
	}

	@Autowired
	public void setRoleService(IRoleService roleService) {
		UserContext.roleService = roleService;
	}
	
	/*
	 * 获取请求
	 * 
	 * @return
	 */
	public static HttpServletRequest getRequest() {
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		return requestAttributes.getRequest();
	}

	/**
	 * 获取session
	 * 
	 * @return
	 */
	public static HttpSession getSession() {
		return getRequest().getSession();
	}

	/**
	 * 将用户放入session
	 * 
	 * @param employee
	 */
	public static void setUser(Employee employee) {
		// 登录成功 查找用户的所有的权限
		employee.setPermissions(permissionService.getPermissionByUser(employee));
		employee.setRoles(roleService.getRolesByUser(employee));
		getSession().setAttribute(USER_IN_SESSION, employee);
	}

	/**
	 * 获取当前用户权限
	 * 
	 * @param employee
	 * @return
	 */
	public static List<Permission> getUserPermissons() {
		return getUser().getPermissions();
	}

	/**
	 * 获取当前用户角色
	 * 
	 * @param employee
	 * @return
	 */
	public static List<Role> getUserRoles() {
		return getUser().getRoles();
	}

	/**
	 * 判断某个权限是否在当前用户的权限列表中
	 */
	public static boolean hasPermission(Permission permission) {
		return hasPermissionByUrl(permission.getResource());
	}

	/**
	 * 判断某个权限url就是资源地址是否在当前用户的权限列表中
	 */
	public static boolean hasPermissionByUrl(String permissionUrl) {
		String resource = permissionUrl;
		String resourceALL = resource.split(":")[0] + ":ALL";
		for (Permission p : getUserPermissons()) {
			if (p.getResource().equals(resource) || p.getResource().equals(resourceALL)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 判断某个权限名字是否在当前用户的权限列表中
	 */
	public static boolean hasPermissionByName(String name) {
		for (Permission p : getUserPermissons()) {
			if (p.getName().equals(name)) {
				return true;
			}
		}
		if(getUser().getUsername().equals("admin")){
			return true;
		}
		return false;
	}

	/**
	 * 将用户放入session
	 * 
	 * @param employee
	 */
	public static Employee getUser() {
		return (Employee) getSession().getAttribute(USER_IN_SESSION);
	}

	/**
	 * 根据资源地址获取用户权限
	 * 
	 * @param resourceUrl
	 * @return true 有权限 false 没有
	 */
	public static boolean checkUserPermission(String resourceUrl) {
		System.out.println(permissionService);
		// 判断要访问的资源，是否有对应的权限
		Permission dbPermission = permissionService.getPermissionByResourceUrl(resourceUrl);
		if (dbPermission == null) {
			return true;// 直接放行
		}
		// 如果有权限（锁），判断钥匙：
		// 获取用户权限
		List<Permission> userPermissions = UserContext.getUserPermissons();
		// 先判断是否有具体权限，对应的钥匙

		for (Permission userPermission : userPermissions) {
			if (userPermission.getId() == dbPermission.getId()) {
				return true;// 有权限，放行
			}
		}
		// 再判断是否有万能钥匙
		// 获取ALL权限的资源地址
		String allResourceName = resourceUrl.split(":")[0] + ":ALL";
		for (Permission userPermission : userPermissions) {
			if (allResourceName.equals(userPermission.getResource())) {// 判断是否有all权限
				return true;// 放行
			}
		}
		return false;
	}

	public static boolean isManagerRole() {
		for (Role role : getUserRoles()) {
			// 角色属于管理员组
			if (Arrays.asList(MANAGER_ROLE_NAMES).contains(role.getName())) {
				return true;
			}
		}
		return false;
	}
	
	public static String getValidateCode() {
		return (String) getSession().getAttribute(VALIDATE_CODE_IN_SESSION);
	}
}
