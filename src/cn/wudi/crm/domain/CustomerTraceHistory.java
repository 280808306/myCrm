package cn.wudi.crm.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 客户跟进历史
 * 
 * */
public class CustomerTraceHistory {
	private Long id;
//	跟进人
	private Employee traceUser;
//	跟进时间
	private Date traceTime;
//	跟进方式
	private SystemDictionaryItem traceType;
//	跟进效果
	private Integer traceResult;
//	跟进主题
	private String title;
//	remark
	private String remark;
	private Customer customer;
	public Employee getTraceUser() {
		return traceUser;
	}
	public void setTraceUser(Employee traceUser) {
		this.traceUser = traceUser;
	}
	public String getTraceTimeFormat() {
		if (traceTime != null) {
			return new SimpleDateFormat("yyyy-MM-dd").format(traceTime);
		}else{
			return "你猜是多少号";
		}
	}
	public Date getTraceTime() {
		return traceTime;
	}
	public void setTraceTime(Date traceTime) {
		this.traceTime = traceTime;
	}
	
	public SystemDictionaryItem getTraceType() {
		return traceType;
	}
	public void setTraceType(SystemDictionaryItem traceType) {
		this.traceType = traceType;
	}
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
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "CustomerTraceHistory [id=" + id + ", traceUser=" + traceUser + ", traceTime=" + traceTime
				+ ", traceType=" + traceType + ", traceResult=" + traceResult + ", title=" + title + ", remark="
				+ remark + ", customer=" + customer + "]";
	}
	
}
