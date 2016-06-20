package cn.wudi.crm.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PotentialCustomer implements Serializable {

	private static final long serialVersionUID = -2928666771966424342L;

	private Long id;

	private String name;

	/**
	 * 成功几率
	 */
	private Float successRate;

	/**
	 * 客户描述
	 */
	private String remark;

	/**
	 * 联系人
	 */
	private String linkMan;

	/**
	 * 联系人电话
	 */
	private String linkManTel;

	/**
	 * 录入时间
	 */
	private Date inputTime;

	/**
	 * 客户来源
	 */
	private SystemDictionaryItem customerSource;

	/**
	 * 录入人
	 */
	private Employee inputUser;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SystemDictionaryItem getCustomerSource() {
		return customerSource;
	}

	public void setCustomerSource(SystemDictionaryItem customerSource) {
		this.customerSource = customerSource;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getSuccessRate() {
		return successRate;
	}

	public void setSuccessRate(Float successRate) {
		this.successRate = successRate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getLinkMan() {
		return linkMan;
	}

	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}

	public String getLinkManTel() {
		return linkManTel;
	}

	public void setLinkManTel(String linkManTel) {
		this.linkManTel = linkManTel;
	}

	public Employee getInputUser() {
		return inputUser;
	}

	public void setInputUser(Employee inputUser) {
		this.inputUser = inputUser;
	}

	public Date getInputTime() {
		return inputTime;
	}

	public String getInputTimeStr() {
		if (inputTime != null) {
			return new SimpleDateFormat("yyyy-MM-dd").format(inputTime);
		}else{
			return null;
		}
	}

	public void setInputTime(Date inputTime) {
		this.inputTime = inputTime;
	}

	@Override
	public String toString() {
		return "PotentialCustomer [id=" + id + ", customerSource=" + customerSource + ", name=" + name
				+ ", successRate=" + successRate + ", remark=" + remark + ", linkMan=" + linkMan + ", linkManTel="
				+ linkManTel + ", inputUser=" + inputUser + ", inputTime=" + inputTime + "]";
	}

}
