package cn.wudi.crm.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 保修详细
 * 
 * @author lym
 *
 */
public class GuaranteeItem {

	private Long id;

	/**
	 * 保修时间
	 */
	private Date guaranteeTime;

	/**
	 * 内容
	 */
	private String content;

	/**
	 * 是否解决
	 */
	private Integer isSolve;

	/**
	 * 所属保修单
	 */
	private Guarantee guarantee;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getGuaranteeTime() {
		return guaranteeTime;
	}

	public void setGuaranteeTime(Date guaranteeTime) {
		this.guaranteeTime = guaranteeTime;
	}
	
	public String getGuaranteeTimeStr() {
		return guaranteeTime == null ? null : new SimpleDateFormat("yyyy-MM-dd").format(guaranteeTime);
	}
	
	public void setGuaranteeTimeStr(String guaranteeTimeStr) throws ParseException {
		this.guaranteeTime = new SimpleDateFormat("yyyy-MM-dd").parse(guaranteeTimeStr);
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getIsSolve() {
		return isSolve;
	}

	public void setIsSolve(Integer isSolve) {
		this.isSolve = isSolve;
	}

	public Guarantee getGuarantee() {
		return guarantee;
	}

	public void setGuarantee(Guarantee guarantee) {
		this.guarantee = guarantee;
	}

}
