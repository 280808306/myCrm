package cn.wudi.crm.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 保修单
 * 
 * @author lym
 *
 */
public class Guarantee {

	private Long id;

	/**
	 * 编号
	 */
	private String sn;

	/**
	 * 客户
	 */
	private Customer customer;

	/**
	 * 到期时间
	 */
	private Date endTime;

	/**
	 * 详细
	 */
	private List<GuaranteeItem> items;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getEndTimeStr() {
		return endTime == null ? null : new SimpleDateFormat("yyyy-MM-dd").format(endTime);
	}

	public void setEndTimeStr(String endTimeStr) throws ParseException {
		this.endTime = new SimpleDateFormat("yyyy-MM-dd").parse(endTimeStr);
	}

	public List<GuaranteeItem> getItems() {
		return items;
	}

	public void setItems(List<GuaranteeItem> items) {
		this.items = items;
	}

}
