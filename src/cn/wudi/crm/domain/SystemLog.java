package cn.wudi.crm.domain;

import java.io.Serializable;
import java.util.Date;

public class SystemLog implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	/**
	 *  ID id 主键，系统自动生成 数据库自动生成    
	 */
	private Long id;
	
	/**
	 *  操作用户 opUser 文本
	 */
	private Employee opUser;
	
	/**
	 *  操作时间 opTime 文本
	 */
	private Date opTime;
	
	/**
	 *  登录IP opIp 菜单对象 访问的那个菜单
	 */
	private String opIp;
	
	/**
	 *  使用功能 function 文本
	 */
	private String function;
	
	public SystemLog() {
	}
	
	public SystemLog(Employee opUser, Date opTime, String opIp, String function) {
		this.opUser = opUser;
		this.opTime = opTime;
		this.opIp = opIp;
		this.function = function;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Employee getOpUser() {
		return opUser;
	}

	public void setOpUser(Employee opUser) {
		this.opUser = opUser;
	}

	public String getOpTime() {
		return opTime.toLocaleString();
	}

	public void setOpTime(Date opTime) {
		this.opTime = opTime;
	}

	public String getOpIp() {
		return opIp;
	}

	public void setOpIp(String opIp) {
		this.opIp = opIp;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	@Override
	public String toString() {
		return "SystemLog [id=" + id + ", opUser=" + opUser + ", opTime=" + opTime + ", opIp=" + opIp + ", function=" + function +"]";
	}
}
