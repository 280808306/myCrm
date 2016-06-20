package cn.wudi.crm.domain;

import java.util.List;

/**
 * 
 * 接收list resource来添加权限用
 * @author zh
 *
 */
public class ResourceListModel {
	
	private List<Resource> resources;

	public List<Resource> getResources() {
		return resources;
	}

	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}
}
