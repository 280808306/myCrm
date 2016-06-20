package cn.wudi.crm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wudi.crm.domain.AjaxResult;
import cn.wudi.crm.domain.Employee;
import cn.wudi.crm.domain.PageData;
import cn.wudi.crm.domain.Role;
import cn.wudi.crm.query.EmployeeQuery;
import cn.wudi.crm.service.IEmployeeService;

@Controller
@RequestMapping("employee")
public class EmployeeController {
	@Autowired
	private IEmployeeService employeeService;
	@RequestMapping("/index")
	public String index(){
		return "employee/employee-list";
	}
	@RequestMapping("/list")
	@ResponseBody
	public PageData<Employee> list(EmployeeQuery employeeQuery){
		PageData<Employee> list = employeeService.getPage(employeeQuery);
		return list;
	}
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult save(Employee employee){
		AjaxResult ajaxResult;
		try {
			if(employee.getId()==null){
				employeeService.save(employee);
				ajaxResult = new AjaxResult();
				ajaxResult.setMsg("保存成功");
			}else{
				employeeService.update(employee);
				ajaxResult = new AjaxResult();
				ajaxResult.setMsg("修改成功");
			}
		} catch (Exception e) {
			System.out.println("---------------------------------------------"+e.getMessage());
			ajaxResult = new AjaxResult();
			ajaxResult.setMsg("操作失败"+e.getMessage());
			ajaxResult.setStatus(false);
		}
			return ajaxResult;
	}
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delete(Long id){
		AjaxResult ajaxResult;
		try {
			employeeService.delete(id);
			ajaxResult = new AjaxResult();
			ajaxResult.setMsg("删除成功");
		} catch (Exception e) {
			ajaxResult = new AjaxResult();
			ajaxResult.setMsg("操作失败");
		}
		return ajaxResult;
	}
//	查询员工下面所有的角色
//	@RequestMapping("/getRoles")
//	@ResponseBody
//	public List<Role> getRoles(Long id){
//		return employeeService.getRoles(id);
//	}
}
