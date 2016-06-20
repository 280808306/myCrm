package cn.wudi.crm.mapper;

import java.util.List;

import cn.wudi.crm.domain.Employee;
import cn.wudi.crm.domain.Role;
import cn.wudi.crm.domain.RoleEmployee;
import cn.wudi.crm.domain.RolePermission;

public interface EmployeeMapper extends BaseMapper<Employee>{
	Employee getEmployeeByUsername(String username);


//	void saveRoleEmployee(List<RoleEmployee> list);
//
//
//	void deleteRoleEmployee(Long id);
//
//
//	List<Role> getRoles(Long employeeId);
}
