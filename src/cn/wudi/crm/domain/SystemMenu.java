package cn.wudi.crm.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 管理员的菜单对象 动态获取
 * @author zh
 *
 */
public class SystemMenu implements Serializable {
	
	private static final long serialVersionUID = 1L;

	//ID Id	主键，系统自动生成 数据库自动生成	
	private Long id;
	
	// 菜单编号 sn 文本 必须	
	private String sn;
	
	// 菜单名称 name 文本 必须
	private String name;
	
	// 上级菜单 parent 菜单对象
	private SystemMenu parent;
	
	//图标	icon 文本	
	private String icon;
	
	//地址	url	文本	
	private String url;
	
	//简介	intro 文本	
	private String intro;
	
	//子菜单列表
	private List<SystemMenu> children = new ArrayList<>();
	
	private Permission permission;

	/**
	 * 构造方法显示
	 */
	public SystemMenu() {
	}

	public SystemMenu(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getName() {
		return name;
	}
	
	/**
	 * 获取text的 供菜单使用
	 */
	public String getText(){
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SystemMenu getParent() {
		return parent;
	}

	public void setParent(SystemMenu parent) {
		this.parent = parent;
	}

	public String getIcon() {
		return icon;
	}
	
	/**
	 * 获取iconCls的 供菜单使用
	 */
	public String getIconCls() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public List<SystemMenu> getChildren() {
		return children;
	}

	public void setChildren(List<SystemMenu> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", sn=" + sn + ", name=" + name + ", parent=" + parent + ", icon=" + icon + ", url=" + url + ", intro=" + intro + "]";
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}
}