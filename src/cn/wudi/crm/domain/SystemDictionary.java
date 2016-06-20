package cn.wudi.crm.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据字典
 * @author zh
 */
public class SystemDictionary implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//	ID	id	主键，系统自动生成	数据库自动生成
	private Long id;
	
	//	字典目录编号	sn		文本
	private String sn;
	
	//	字典目录名称	name		文本
	private String name;
	
	//	字典目录简介	intro		文本
	private String intro;
	
	//	状态	state	1正常 -1停用	文本
	private Integer state;
	
	//	字典明细	details	一对多	明细对象
	private List<SystemDictionaryItem> details = new ArrayList<>();
	
	//	空的构造方法
	public SystemDictionary() {
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

	public void setName(String name) {
		this.name = name;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public List<SystemDictionaryItem> getDetails() {
		return details;
	}

	public void setDetails(List<SystemDictionaryItem> details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "SystemDictionary [id=" + id + ", sn=" + sn + ", name=" + name + ", intro=" + intro + ", state=" + state + ", details=" + details + "]";
	}
}
