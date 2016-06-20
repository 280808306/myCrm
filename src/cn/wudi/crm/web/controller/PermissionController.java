package cn.wudi.crm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wudi.crm.domain.AjaxResult;
import cn.wudi.crm.domain.PageData;
import cn.wudi.crm.domain.Permission;
import cn.wudi.crm.domain.PermissionListModel;
import cn.wudi.crm.domain.ResourceListModel;
import cn.wudi.crm.query.PermissionQuery;
import cn.wudi.crm.service.IPermissionService;
import cn.wudi.crm.utils.Resource;
/**
 * 权限界面
 * @author sr
 *
 */
@Controller
@RequestMapping("/permission")
@Resource("权限模块")
public class PermissionController {
	
	@Autowired
	private IPermissionService permissionService;
	
	/**
	 * 跳转到权限管理界面
	 */
	@RequestMapping("/index")
	public String index(){
		return "permission/permission";
	}
	
	@Resource("权限列表")
	@RequestMapping("/list")
	@ResponseBody
	public PageData<Permission> list(PermissionQuery query){
		return permissionService.getPage(query);
	}
	
	@Resource("权限删除")
	@RequestMapping("/deletelist")
	@ResponseBody
	public AjaxResult deleteList(PermissionListModel model) {
		AjaxResult result = new AjaxResult();
		try {
			if(model.getPermissions() == null ||model.getPermissions().size() == 0){
				result.setStatus(false);
				result.setMsg("请选中有效的行"); 
			}else {
				System.out.println(model.getPermissions());
				permissionService.deleteList(model.getPermissions());
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setStatus(false);
			result.setMsg("出现异常："+e.getMessage()); 
		}
		return result;
	}
	
//	@Resource("权限编辑")
//	@RequestMapping("/save")
//	@ResponseBody
//	public AjaxResult save(Permission permission) {
//		AjaxResult result = new AjaxResult();
//		try {
//			if(permission.getId()==null){
////				permissionService.save(permission);
//				result.setMsg("添加成功");
//			}else {
////				permissionService.update(permission);
//				result.setMsg("修改成功");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			result.setStatus(false);
//			result.setMsg("出现异常："+e.getMessage()); 
//		}
//		return result;
//	}
	
	@Resource("权限编辑")
	@RequestMapping("/savelist")
	@ResponseBody
	public AjaxResult saveList(ResourceListModel model) {
		AjaxResult result = new AjaxResult();
		try {
			if(model.getResources() == null || model.getResources().size() == 0){
				result.setStatus(false);
				result.setMsg("请选中有效的行"); 
			} else {
				System.out.println(model.getResources());
				permissionService.saveList(model.getResources());
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setStatus(false);
			result.setMsg("出现异常："+e.getMessage()); 
		}
		return result;
	}
	
//	得到角色下的所有权限
	@RequestMapping("/getPermissions")
	@ResponseBody
	public List<Permission> getPermissions(Long roleId){
		return permissionService.getPermissions(roleId);	
	}
}
