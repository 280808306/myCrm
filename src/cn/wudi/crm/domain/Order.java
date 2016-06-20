package cn.wudi.crm.domain;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 订单实体类
 * 
 * @author lym
 *
 */
public class Order {

	private Long id;

	/**
	 * 订单编号
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
	 * 订金
	 */
	private BigDecimal sum;

	/**
	 * 备注
	 */
	private String intro;

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

	public Date getSignTime() {
		return signTime;
	}
	
	public String getSignTimeStr() {
		return signTime==null?null:new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(signTime);
	}

	public void setSignTime(Date signTime) {
		this.signTime = signTime;
	}

	public Employee getSeller() {
		return seller;
	}

	public void setSeller(Employee seller) {
		this.seller = seller;
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

	@Override
	public String toString() {
		return "Order [id=" + id + ", sn=" + sn + ", customer=" + customer + ", signTime=" + signTime + ", seller="
				+ seller + ", sum=" + sum + ", intro=" + intro + "]";
	}

}
