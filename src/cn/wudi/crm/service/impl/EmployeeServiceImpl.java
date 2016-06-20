package cn.wudi.crm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wudi.crm.domain.Employee;
import cn.wudi.crm.domain.Role;
import cn.wudi.crm.domain.RoleEmployee;
import cn.wudi.crm.mapper.EmployeeMapper;
import cn.wudi.crm.service.IEmployeeService;
@Service
public class EmployeeServiceImpl extends BaseServiceImpl<Employee> implements IEmployeeService{
	private EmployeeMapper employeeMapper;
	@Autowired
	public EmployeeServiceImpl(EmployeeMapper employeeMapper) {
		super(employeeMapper);
		this.employeeMapper = employeeMapper;
	}
	@Override
	public Employee getEmployeeByUsername(String username) {
		Employee employee = employeeMapper.getEmployeeByUsername(username);
		return employee;
	}
//	public void save(Employee employee) {
//		// TODO Auto-generated method stub
//		// 保存角色，返回新id
//		employeeMapper.save(employee);
//		// 保存中间表
//		this.saveRoleEmployee(employee);
//	}
//
//	/**
//	 * 保存角色和权限的关联（中间表）信息
//	 * @param role
//	 */
//	private void saveRoleEmployee(Employee employee) {
//		// 获取待添加的权限
//		 List<Role> rloes = employee.getRloes();
//		// 判断是否有关联权限
//		if(rloes!=null && !rloes.isEmpty()){
//			Long roleId = employee.getId();
//			// 声明集合
//			List<RoleEmployee> list = new ArrayList<>();
//			// 遍历
//			for (Role rloe : rloes) {
//				// 新建关联对象
//				RoleEmployee link = new RoleEmployee();
//				link.setEmployeeId(employee.getId());
//				link.setRoleId(rloe.getId());
//				// 把新关联信息添加到集合中
//				list.add(link);
//			}
//			// 保存关联信息
//			employeeMapper.saveRoleEmployee(list);
//		}
//		
//	}
//
//	public void update(Employee employee) {
//		// TODO Auto-generated method stub
//		employeeMapper.update(employee);
//		
//		// 清除中间表信息
//		employeeMapper.deleteRoleEmployee(employee.getId());
//		// 保存中间表
//		saveRoleEmployee(employee);
//	}
//
//	public void delete(Long id) {
//		employeeMapper.delete(id);
//		// 清除中间表
//		employeeMapper.deleteRoleEmployee(id);
//	}
//	@Override
//	public List<Role> getRoles(Long employeeId) {
//		return employeeMapper.getRoles(employeeId);
//	}
	
}
