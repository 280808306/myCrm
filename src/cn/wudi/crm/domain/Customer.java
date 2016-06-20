package cn.wudi.crm.domain;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Customer {
	private Long id;
	private String name;
	private Integer age;
//	客户性别	gender		数字	是
	private Integer gender;
//	电话
	private Integer tel;
	private String email;
	private Integer qq;
//	微信
	private String wechat;
//	营销人员	seller		员工对象
	private Employee seller;
//	职业	job		数据字典
	private SystemDictionaryItem job;
//	收入水平	salaryLevel		数据字典
	private SystemDictionaryItem salaryLevel;
//	客户来源	customerSource		数据字典
	private SystemDictionaryItem customerSource;
//	创建人	inputUser	自动填入当前登录用户，用户不可更改	后台自动维护	是
	private Employee inputUser;
//	创建时间	inputTime	当前系统时间	后台自动维护	是
	private Date inputTime = new Date();
//	解析的时间
	private Date inputTimeFormat;
//	客户状态
	private Integer status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Integer getTel() {
		return tel;
	}
	public void setTel(Integer tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getQq() {
		return qq;
	}
	public void setQq(Integer qq) {
		this.qq = qq;
	}
	public String getWechat() {
		return wechat;
	}
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	public Employee getSeller() {
		return seller;
	}
	public void setSeller(Employee seller) {
		this.seller = seller;
	}
	public SystemDictionaryItem getJob() {
		return job;
	}
	public void setJob(SystemDictionaryItem job) {
		this.job = job;
	}
	public SystemDictionaryItem getSalaryLevel() {
		return salaryLevel;
	}
	public void setSalaryLevel(SystemDictionaryItem salaryLevel) {
		this.salaryLevel = salaryLevel;
	}
	public SystemDictionaryItem getCustomerSource() {
		return customerSource;
	}
	public void setCustomerSource(SystemDictionaryItem customerSource) {
		this.customerSource = customerSource;
	}
	public Employee getInputUser() {
		return inputUser;
	}
	public void setInputUser(Employee inputUser) {
		this.inputUser = inputUser;
	}
	public String getInputTimeFormat() {
		if (inputTime != null) {
			return new SimpleDateFormat("yyyy-MM-dd").format(inputTime);
		}else{
			return "你猜是多少号";
		}
	}
	public Date getInputTime() {
		return inputTime;
	}
	public void setInputTime(Date inputTime) {
		this.inputTime = inputTime;
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", tel=" + tel
				+ ", email=" + email + ", qq=" + qq + ", wechat=" + wechat + ", seller=" + seller + ", job=" + job
				+ ", salaryLevel=" + salaryLevel + ", customerSource=" + customerSource + ", inputUser=" + inputUser
				+ ", inputTime=" + inputTime + "]";
	}
	
	
}
