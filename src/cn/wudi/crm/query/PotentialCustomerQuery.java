package cn.wudi.crm.query;

public class PotentialCustomerQuery extends BaseQuery {

	private String name;

	private Float minSuccessRate;

	private Float maxSuccessRate;

	private Long inputUserId;

	private Long customerSourceId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSuccessRate(String successRate) {
		String[] strings = successRate.split(",");
		if(strings.length==2){
			minSuccessRate = Float.valueOf(strings[0]);
			maxSuccessRate = Float.valueOf(strings[1]);
		}
	}

	public Float getMinSuccessRate() {
		return minSuccessRate;
	}

	public void setMinSuccessRate(Float minSuccessRate) {
		this.minSuccessRate = minSuccessRate;
	}

	public Float getMaxSuccessRate() {
		return maxSuccessRate;
	}

	public void setMaxSuccessRate(Float maxSuccessRate) {
		this.maxSuccessRate = maxSuccessRate;
	}

	public Long getInputUserId() {
		return inputUserId;
	}

	public void setInputUserId(Long inputUserId) {
		this.inputUserId = inputUserId;
	}

	public Long getCustomerSourceId() {
		return customerSourceId;
	}

	public void setCustomerSourceId(Long customerSourceId) {
		this.customerSourceId = customerSourceId;
	}
}
