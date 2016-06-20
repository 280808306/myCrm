package cn.wudi.crm.query;

import java.util.Date;

import org.springframework.util.StringUtils;

import cn.wudi.crm.domain.Department;
import cn.wudi.crm.domain.Role;

public class EmployeeQuery extends BaseQuery{
	private Long id;
	private String username;
	private String realName;
	private String password;
	private String tel;
	private String email;
	private Department dept;
	private Date inputTime = new Date();
	private Integer state;
	private Role role;
	private String searchKey;
	public String getSearchKey() {
		if(StringUtils.hasLength(searchKey)){
			return "%"+searchKey+"%";
		}
		return searchKey;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	public Date getInputTime() {
		return inputTime;
	}
	public void setInputTime(Date inputTime) {
		this.inputTime = inputTime;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
}
