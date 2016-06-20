package cn.wudi.crm.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 合同
 * 
 * @author lym
 *
 */
public class Contract implements Serializable {

	private static final long serialVersionUID = -2868046179570994600L;

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
	 * 签约时间
	 */
	private Date signTime;

	/**
	 * 营销人员
	 */
	private Employee seller;

	/**
	 * 金额
	 */
	private BigDecimal sum;

	/**
	 * 简介
	 */
	private String intro;

	/**
	 * 合同详细
	 */
	private List<ContractItem> details;

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

	public Date getSignTime() {
		return signTime;
	}

	public String getSignTimeStr() {
		return signTime == null ? null : new SimpleDateFormat("yyyy-MM-dd").format(signTime);
	}
	
	public void setSignTimeStr(String timeStr) throws ParseException{
		signTime = new SimpleDateFormat("yyyy-MM-dd").parse(timeStr);
	}

	public void setSignTime(Date signTime) {
		this.signTime = signTime;
	}

	public BigDecimal getSum() {
		return sum;
	}

	public void setSum(BigDecimal sum) {
		this.sum = sum;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public List<ContractItem> getDetails() {
		return details;
	}

	public void setDetails(List<ContractItem> details) {
		this.details = details;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Employee getSeller() {
		return seller;
	}

	public void setSeller(Employee seller) {
		this.seller = seller;
	}

	@Override
	public String toString() {
		return "Contract [id=" + id + ", sn=" + sn + ", customer=" + customer + ", signTime=" + signTime + ", seller="
				+ seller + ", sum=" + sum + ", intro=" + intro + "]";
	}
	
}
