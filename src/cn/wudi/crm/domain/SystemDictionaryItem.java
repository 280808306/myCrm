package cn.wudi.crm.domain;

import java.io.Serializable;

/**
 * 
 * 数据字典
 * @author zh
 */
public class SystemDictionaryItem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//	ID	id	主键，系统自动生成	数据库自动生成	
	private Long id;
	
	//	字典目录	parent	多对一	字典目录对象	是
	private SystemDictionary parent;
	
	//	字典明细名称	name		文本	是
	private String name;
	
	//	字典明细序号	sn		数字	
	private Integer sn;
	
	//	字典明细简介	intro		文本	
	private String intro;

	public SystemDictionaryItem() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SystemDictionary getParent() {
		return parent;
	}

	public void setParent(SystemDictionary parent) {
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSn() {
		return sn;
	}

	public void setSn(Integer sn) {
		this.sn = sn;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	@Override
	public String toString() {
		return "SystemDictionaryItem [id=" + id + ", parent=" + parent + ", name=" + name + ", sn=" + sn + ", intro=" + intro + "]";
	}
}
