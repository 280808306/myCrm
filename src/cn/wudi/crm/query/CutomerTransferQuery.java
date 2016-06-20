package cn.wudi.crm.query;

public class CutomerTransferQuery extends BaseQuery{
	private Long customerId;
	private Long transUserId;
	private Long oldSellerId;
	private Long newSellerId;
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Long getTransUserId() {
		return transUserId;
	}
	public void setTransUserId(Long transUserId) {
		this.transUserId = transUserId;
	}
	public Long getOldSellerId() {
		return oldSellerId;
	}
	public void setOldSellerId(Long oldSellerId) {
		this.oldSellerId = oldSellerId;
	}
	public Long getNewSellerId() {
		return newSellerId;
	}
	public void setNewSellerId(Long newSellerId) {
		this.newSellerId = newSellerId;
	}
	@Override
	public String toString() {
		return "CutomerTransferQuery [customerId=" + customerId + ", transUserId=" + transUserId + ", oldSellerId="
				+ oldSellerId + ", newSellerId=" + newSellerId + "]";
	}
	
}
