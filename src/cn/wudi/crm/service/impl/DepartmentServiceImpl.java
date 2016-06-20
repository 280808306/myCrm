package cn.wudi.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wudi.crm.domain.Department;
import cn.wudi.crm.mapper.BaseMapper;
import cn.wudi.crm.mapper.DepartmentMapper;
import cn.wudi.crm.service.IDepartmentService;
@Service
public class DepartmentServiceImpl extends BaseServiceImpl<Department> implements IDepartmentService{
	private DepartmentMapper departmentMapper;
	@Autowired
	public DepartmentServiceImpl(DepartmentMapper departmentMapper) {
		super(departmentMapper);
		this.departmentMapper = departmentMapper;
	}

}
