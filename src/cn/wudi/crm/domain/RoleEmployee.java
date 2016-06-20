package cn.wudi.crm.domain;

public class RoleEmployee {
	private Long roleId;
	private Long employeeId;
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	@Override
	public String toString() {
		return "RoleEmployee [roleId=" + roleId + ", employeeId=" + employeeId + "]";
	}
	
}
