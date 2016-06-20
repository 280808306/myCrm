package cn.wudi.crm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wudi.crm.domain.AjaxResult;
import cn.wudi.crm.domain.PageData;
import cn.wudi.crm.domain.SystemMenu;
import cn.wudi.crm.query.SystemMenuQuery;
import cn.wudi.crm.service.ISystemMenuService;
import cn.wudi.crm.utils.Resource;

/**
 * 菜单管理界面控制器
 * @author zh
 */
@Controller
@RequestMapping("/systemMenu")
@Resource("菜单资源")
public class SystemMenuController {
	
	@Autowired
	private ISystemMenuService systemMenuService;
	
	/**
	 * 跳转到菜单管理界面
	 * 什么都不做 中转到 WEB-INF文件夹下的该页面 
	 * WEB-INF/views/systemMenu/systemMenu.jsp
	 */
	@RequestMapping("")
	@Resource("菜单导航")
	public String index(){
		return "systemMenu/systemMenu";
	}
	
	@RequestMapping("/list")
	@Resource("菜单列表")
	@ResponseBody
	public PageData<SystemMenu> list(SystemMenuQuery query){
		return systemMenuService.getPage(query);
	}
	
	@RequestMapping("/edit")
	@Resource("菜单编辑")
	@ResponseBody
	public AjaxResult edit(SystemMenu systemMenu){
		AjaxResult result = new AjaxResult();
		
		try {
			if(systemMenu.getId() == null) {
				systemMenuService.save(systemMenu);
				result.setMsg("添加成功");
			}else {
				systemMenuService.update(systemMenu);
				result.setMsg("修改成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setStatus(false);
			result.setMsg("出现异常:"+e.getMessage());
		}
		return result;
	}
	
	@RequestMapping("/delete")
	@Resource("菜单删除")
	@ResponseBody
	public AjaxResult delete(Long id){
		AjaxResult result = new AjaxResult();
		try {
			if(id != null){
				systemMenuService.delete(id);
				result.setMsg("删除成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setStatus(false);
			result.setMsg("出现异常"+e.getMessage());
		}
		return result;
	}
}
