package cn.wudi.crm.query;

public class PermissionQuery extends BaseQuery {
	private String name;
	private String resource;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	@Override
	public String toString() {
		return "PermissionQuery [name=" + name + ", resource=" + resource + "]";
	}
	
	
}
