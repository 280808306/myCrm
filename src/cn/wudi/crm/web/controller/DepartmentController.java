package cn.wudi.crm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wudi.crm.domain.AjaxResult;
import cn.wudi.crm.domain.Department;
import cn.wudi.crm.domain.Employee;
import cn.wudi.crm.domain.PageData;
import cn.wudi.crm.mapper.DepartmentMapper;
import cn.wudi.crm.query.DepartmentQuery;
import cn.wudi.crm.query.EmployeeQuery;
import cn.wudi.crm.service.IDepartmentService;

@Controller
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	IDepartmentService departmentService;
	@RequestMapping("/index")
	public String index(){
		return "department/department-list";
	}
	@RequestMapping("/list")
	@ResponseBody
	public PageData<Department> list(DepartmentQuery query){
		PageData<Department> list = departmentService.getPage(query);
		return list;
	}
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult save(Department department){
		System.out.println(department);
		AjaxResult ajaxResult;
		try {
			if(department.getId()==null){
				departmentService.save(department);
				ajaxResult = new AjaxResult();
				ajaxResult.setMsg("保存成功");
			}else{
				departmentService.update(department);
				ajaxResult = new AjaxResult();
				ajaxResult.setMsg("修改成功");
			}
		} catch (Exception e) {
			ajaxResult = new AjaxResult();
			ajaxResult.setMsg("操作失败");
			e.printStackTrace();
		}
			return ajaxResult;
	}
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delete(Long id){
		AjaxResult ajaxResult;
		try {
			departmentService.delete(id);
			ajaxResult = new AjaxResult();
			ajaxResult.setMsg("删除成功");
		} catch (Exception e) {
			ajaxResult = new AjaxResult();
			ajaxResult.setMsg("操作失败");
			e.printStackTrace();
		}
		return ajaxResult;
	}
}
