package cn.wudi.crm.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *   客户移交记录
 * */
public class CutomerTransfer {
	private Long id;
//	客户
	private Customer customer;
//	移交人员
	private Employee transUser;
//	移交时间
	private Date transTime;
//	老市场专员
	private Employee oldSeller;
//	新市场专员
	private Employee newSeller;
//	移交原因
	private String transReason;
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
	public Employee getTransUser() {
		return transUser;
	}
	public void setTransUser(Employee transUser) {
		this.transUser = transUser;
	}
	public String getTransTimeFormat() {
		if (transTime != null) {
			return new SimpleDateFormat("yyyy-MM-dd").format(transTime);
		}else{
			return "你猜是多少号";
		}
	}
	public Date getTransTime() {
		return transTime;
	}
	public void setTransTime(Date transTime) {
		this.transTime = transTime;
	}
	public Employee getOldSeller() {
		return oldSeller;
	}
	public void setOldSeller(Employee oldSeller) {
		this.oldSeller = oldSeller;
	}
	public Employee getNewSeller() {
		return newSeller;
	}
	public void setNewSeller(Employee newSeller) {
		this.newSeller = newSeller;
	}
	public String getTransReason() {
		return transReason;
	}
	public void setTransReason(String transReason) {
		this.transReason = transReason;
	}
	@Override
	public String toString() {
		return "CutomerTransfer [id=" + id + ", customer=" + customer + ", transUser=" + transUser + ", transTime="
				+ transTime + ", oldSeller=" + oldSeller + ", newSeller=" + newSeller + ", transReason=" + transReason
				+ "]";
	}
	
}
