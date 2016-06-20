package cn.wudi.crm.query;

/**
 * 菜单的查询对象
 * @author zh
 */
public class SystemMenuQuery extends BaseQuery {
	
	/**
	 * 菜单名字 
	 */
	private String name;
	
	/**
	 * 菜单编号
	 */
	private String sn;
	
	/**
	 * 父菜单
	 */
	private Long parentId;
	
	/**
	 * url地址
	 */
	private String url;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public String toString() {
		return "SystemMenuQuery [name=" + name + ", sn=" + sn + ", parentId=" + parentId + ", url=" + url + "]";
	}
}
