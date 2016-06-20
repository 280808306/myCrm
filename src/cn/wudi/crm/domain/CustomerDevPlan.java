package cn.wudi.crm.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomerDevPlan implements Serializable {

	private static final long serialVersionUID = 2057032739845611203L;

	private Long id;

	/**
	 * 计划时间
	 */
	private Date planTime;

	/**
	 * 计划主题
	 */
	private String planSubject;

	/**
	 * 计划详细
	 */
	private String planDetails;

	/**
	 * 计划方式
	 */
	private SystemDictionaryItem planType;

	/**
	 * 目标潜在客户
	 */
	private PotentialCustomer potentialCustomer;

	/**
	 * 录入人
	 */
	private Employee inputUser;

	/**
	 * 录入时间
	 */
	private Date inputTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getPlanTime() {
		return planTime;
	}
	
	public String getPlanTimeStr() {
		return planTime==null?null:new SimpleDateFormat("yyyy-MM-dd").format(planTime);
	}

	public void setPlanTime(Date planTime) {
		this.planTime = planTime;
	}

	public String getPlanSubject() {
		return planSubject;
	}

	public void setPlanSubject(String planSubject) {
		this.planSubject = planSubject;
	}

	public String getPlanDetails() {
		return planDetails;
	}

	public void setPlanDetails(String planDetails) {
		this.planDetails = planDetails;
	}

	public SystemDictionaryItem getPlanType() {
		return planType;
	}

	public void setPlanType(SystemDictionaryItem planType) {
		this.planType = planType;
	}

	public PotentialCustomer getPotentialCustomer() {
		return potentialCustomer;
	}

	public void setPotentialCustomer(PotentialCustomer potentialCustomer) {
		this.potentialCustomer = potentialCustomer;
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
		return inputTime==null?null:new SimpleDateFormat("yyyy-MM-dd").format(inputTime);
	}

	public void setInputTime(Date inputTime) {
		this.inputTime = inputTime;
	}

	@Override
	public String toString() {
		return "CustomerDevPlan [id=" + id + ", planTime=" + planTime + ", planSubject=" + planSubject
				+ ", planDetails=" + planDetails + ", planType=" + planType + ", potentialCustomer=" + potentialCustomer
				+ ", inputUser=" + inputUser + ", inputTime=" + inputTime + "]";
	}

}
