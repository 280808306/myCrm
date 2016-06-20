package cn.wudi.crm.query;


/**
 * 数据字典查询对象
 * @author zh
 */
public class SystemDictionaryQuery extends BaseQuery {
	
	/**
	 * 数据字典名字查询
	 */
	private String name;
	
	/**
	 * 数据字典编号查询
	 */
	private String sn;
	
	/**
	 * 数据字典状态查询
	 */
	private Integer state;

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

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "SystemDictionaryQuery [name=" + name + ", sn=" + sn + ", state=" + state + "]";
	}
}
