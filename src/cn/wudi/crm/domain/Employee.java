package cn.wudi.crm.domain;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Employee {
	private Long id;
	private String username;
	private String realName;
	private String password;
	private String tel;
	private String email;
	private Department dept;
	private Date inputTime;
	private Integer state;
	private Role role;
	private Date inputTimeFormat;
	private List<Role> rloes= new ArrayList<>();
	
	public List<Role> getRloes() {
		return rloes;
	}
	public void setRloes(List<Role> rloes) {
		this.rloes = rloes;
	}
	
	private List<Permission> permissions;
	private List<Role> roles;
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", username=" + username + ", realName=" + realName + ", password=" + password
				+ ", tel=" + tel + ", email=" + email + ", dept=" + dept + ", inputTime=" + inputTime + ", state="
				+ state + ", role=" + role + "]";
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
	public String getInputTimeFormat() {
		if (inputTime != null) {
			return new SimpleDateFormat("yyyy-MM-dd").format(inputTime);
		}else{
			return "你猜是多少号";
		}
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
	public List<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}
