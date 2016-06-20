package cn.wudi.crm.query;

public class CustomerDevPlanQuery extends BaseQuery {
	
	private String planSubject;
	
	private Long planTypeId;
	
	private Long potentialCustomerId;
	
	private Long inputUserId;

	public String getPlanSubject() {
		return planSubject;
	}

	public void setPlanSubject(String planSubject) {
		this.planSubject = planSubject;
	}

	public Long getPlanTypeId() {
		return planTypeId;
	}

	public void setPlanTypeId(Long planTypeId) {
		this.planTypeId = planTypeId;
	}

	public Long getPotentialCustomerId() {
		return potentialCustomerId;
	}

	public void setPotentialCustomerId(Long potentialCustomerId) {
		this.potentialCustomerId = potentialCustomerId;
	}

	public Long getInputUserId() {
		return inputUserId;
	}

	public void setInputUserId(Long inputUserId) {
		this.inputUserId = inputUserId;
	}

}
