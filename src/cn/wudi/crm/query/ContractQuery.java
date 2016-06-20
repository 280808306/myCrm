package cn.wudi.crm.query;

public class ContractQuery extends BaseQuery {
	
	/**
	 * 目标客户
	 */
	private Long customerId;
	
	/**
	 * 负责员工
	 */
	private Long sellerId;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

}
