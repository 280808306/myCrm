package cn.wudi.crm.service;

import java.util.List;
import java.util.Map;

import cn.wudi.crm.domain.Employee;
import cn.wudi.crm.domain.Role;

public interface IEmployeeService extends IBaseService<Employee>{

	Employee getEmployeeByUsername(String username);
//
//	List<Role> getRoles(Long employeeId);
}
