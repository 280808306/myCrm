package cn.wudi.crm.query;

public class SystemDictionaryItemQuery extends BaseQuery {
	/**
	 * 数据字典名字查询
	 */
	private String name;
	
	/**
	 * 数据字典编号查询
	 */
	private String sn;
	
	/**
	 * 目录名
	 */
	private Long parentId;

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

	@Override
	public String toString() {
		return "SystemDictionaryItemQuery [name=" + name + ", sn=" + sn + ", parentId=" + parentId + "]";
	}
}
