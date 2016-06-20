package cn.wudi.crm.query;

public class CustomerTraceHistoryQuery extends BaseQuery{
	private Integer traceResult;
	private String title;
	private String remark;
	private Long traceUserId;
	private Long customerId;
	public Integer getTraceResult() {
		return traceResult;
	}
	public void setTraceResult(Integer traceResult) {
		this.traceResult = traceResult;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Long getTraceUserId() {
		return traceUserId;
	}
	public void setTraceUserId(Long traceUserId) {
		this.traceUserId = traceUserId;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	@Override
	public String toString() {
		return "CustomerTraceHistoryQuery [traceResult=" + traceResult + ", title=" + title + ", remark=" + remark
				+ ", traceUserId=" + traceUserId + ", customerId=" + customerId + "]";
	}
	
}
