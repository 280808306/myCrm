package cn.wudi.crm.query;

public class CustomerQuery extends BaseQuery{
	private String name;
	private Integer age;
	private Long sellerId;
	private Long inputUserId;
	private Integer status;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Long getSellerId() {
		return sellerId;
	}
	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}
	public Long getInputUserId() {
		return inputUserId;
	}
	public void setInputUserId(Long inputUserId) {
		this.inputUserId = inputUserId;
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "CustomerQuery [name=" + name + ", age=" + age + ", sellerId=" + sellerId + ", inputUserId="
				+ inputUserId + "]";
	}
	
}
