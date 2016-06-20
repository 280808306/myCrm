package cn.wudi.crm.domain;

import java.util.ArrayList;
import java.util.List;


public class Role {
	private Long id;
	private String name;
	private String sn;
	// 单向多对多： 当前角色拥有权限列表
	private List<Permission> permissions = new ArrayList<Permission>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", sn=" + sn + ", permissions=" + permissions + "]";
	}
	
	
	
}
