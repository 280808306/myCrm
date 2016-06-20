package cn.wudi.crm.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 合同详细
 * 
 * @author lym
 *
 */
public class ContractItem implements Serializable {

	private static final long serialVersionUID = -7415380241042058283L;

	private Long id;

	/**
	 * 所属合同
	 */
	private Contract contract;

	/**
	 * 付款时间
	 */
	private Date payTime;

	/**
	 * 金额
	 */
	private BigDecimal money;

	/**
	 * 所占比例
	 */
	private BigDecimal scale;

	/**
	 * 是否付款
	 */
	private int isPayment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	
	public String getPayTimeStr() {
		return payTime == null ? null : new SimpleDateFormat("yyyy-MM-dd").format(payTime);
	}
	
	public void setPayTimeStr(String payTime) throws ParseException {
		this.payTime = new SimpleDateFormat("yyyy-MM-dd").parse(payTime);
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public BigDecimal getScale() {
		return scale;
	}

	public void setScale(BigDecimal scale) {
		this.scale = scale;
	}

	public int getIsPayment() {
		return isPayment;
	}

	public void setIsPayment(int isPayment) {
		this.isPayment = isPayment;
	}

	@Override
	public String toString() {
		return "ContractItem [id=" + id + ", contract=" + contract + ", payTime=" + payTime + ", money=" + money
				+ ", scale=" + scale + ", isPayment=" + isPayment + "]";
	}

}
