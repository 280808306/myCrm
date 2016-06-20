package cn.wudi.crm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wudi.crm.domain.AjaxResult;
import cn.wudi.crm.domain.PageData;
import cn.wudi.crm.domain.Role;
import cn.wudi.crm.domain.RolePermission;
import cn.wudi.crm.query.RoleQuery;
import cn.wudi.crm.service.IRoleService;
import cn.wudi.crm.utils.Resource;

@Controller
@Resource("角色")
public class RoleController {
	
	@Autowired
	private IRoleService roleService;
//	把查询到的所有部门放在json中
	@RequestMapping("/role_list")
	@ResponseBody
	@Resource("列表")
	public PageData<Role> findAll(RoleQuery query){
		return roleService.getPage(query);
	}
	@Resource("导向")
	@RequestMapping("/role")
	public String execute(){
		return "role/index";
	}
	@RequestMapping("/role_save")
	@ResponseBody
	@Resource("保存")
	public AjaxResult save(Role role){
		AjaxResult result = new AjaxResult();
		try {
			if(role.getId() != null) {
				roleService.update(role);
				result.setMsg("修改成功");
			} else {
				roleService.save(role);
				result.setMsg("添加成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setStatus(true);
			result.setMsg("出现异常："+e.getMessage()); 
		}
		return result;
	}
	
//  删除方法
	@RequestMapping("/role_delete")
	@ResponseBody
	@Resource("删除")
	public	AjaxResult delete(Long id) {
//		先得从前台页面上得到这个用户的id
		AjaxResult result = new AjaxResult();
		try {
			if(id != null) {
				// 修改这里所有的数据都修改到了 不用放置参数丢失
				roleService.delete(id);
				result.setMsg("删除成功");
			} else {
				result.setStatus(false);
				result.setMsg("id不能为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setStatus(false);
			result.setMsg("出现异常："+e.getMessage()); 
		}
		return result;
	}
}
