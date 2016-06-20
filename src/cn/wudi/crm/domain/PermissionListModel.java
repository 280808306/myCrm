package cn.wudi.crm.domain;

import java.util.List;

/**
 * 
 * 接收list resource来添加权限用
 * @author zh
 *
 */
public class PermissionListModel {
	
	private List<Permission> permissions;

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	
}
