package cn.wudi.crm.domain;

public class Resource {
	
	private Long id;
	
	//资源名称
	private String name;
	
	//资源地址
	private String url;
	
	//是否有加入了资源
	private boolean hasResource;
	
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
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	

	public boolean isHasResource() {
		return hasResource;
	}

	public void setHasResource(boolean hasResource) {
		this.hasResource = hasResource;
	}

	@Override
	public String toString() {
		return "Resource [id=" + id + ", name=" + name + ", url=" + url + ", hasResource=" + hasResource  + "]";
	}
	
}
