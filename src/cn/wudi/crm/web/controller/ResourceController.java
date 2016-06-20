package cn.wudi.crm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wudi.crm.domain.AjaxResult;
import cn.wudi.crm.domain.PageData;
import cn.wudi.crm.domain.Resource;
import cn.wudi.crm.domain.ResourceListModel;
import cn.wudi.crm.domain.SystemMenu;
import cn.wudi.crm.query.ResourceQuery;
import cn.wudi.crm.service.IResourceService;

@Controller
@RequestMapping("/resource")
@cn.wudi.crm.utils.Resource("资源")
public class ResourceController {
	
	@Autowired
	private IResourceService resourceService;
	
	/**
	 * 跳转到权限管理界面
	 */
	@RequestMapping("index")
	@cn.wudi.crm.utils.Resource("导向")
	public String index(){
		return "resource/resource";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	@cn.wudi.crm.utils.Resource("列表")
	public  PageData<Resource> list(ResourceQuery query){
		return resourceService.getPage(query);
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	@cn.wudi.crm.utils.Resource("删除")
	public AjaxResult delete(Long id) {
		AjaxResult result = new AjaxResult();
		try {
			if(id!=null){
				resourceService.delete(id);
				result.setMsg("删除成功");
			}			
		} catch (Exception e) {
			e.printStackTrace();
			result.setStatus(false);
			result.setMsg("出现异常："+e.getMessage()); 
		}
			
		return result;
	}
	
	@RequestMapping("/savelist")
	@ResponseBody
	@cn.wudi.crm.utils.Resource("保存多个")
	public AjaxResult saveList(ResourceListModel model) {
		AjaxResult result = new AjaxResult();
		try {
			if(model.getResources() == null || model.getResources().size() == 0){
				result.setStatus(false);
				result.setMsg("请选中有效的行"); 
			} else {
				System.out.println(model.getResources());
				resourceService.saveList(model.getResources());
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setStatus(false);
			result.setMsg("出现异常："+e.getMessage()); 
		}
		return result;
	}
	
	@RequestMapping("/findlist")
	@ResponseBody
	@cn.wudi.crm.utils.Resource("查找多个")
	public PageData<Resource> findList(ResourceQuery query) {
		return resourceService.findResource(query);
	}
	
	@RequestMapping("/deletelist")
	@ResponseBody
	@cn.wudi.crm.utils.Resource("删除多个")
	public AjaxResult deleteList(ResourceListModel model) {
		AjaxResult result = new AjaxResult();
		try {
			if(model.getResources() == null ||model.getResources().size() == 0){
				result.setStatus(false);
				result.setMsg("请选中有效的行"); 
			}else {
				System.out.println(model.getResources());
				resourceService.deleteList(model.getResources());
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setStatus(false);
			result.setMsg("出现异常："+e.getMessage()); 
		}
		return result;
	}
	
	@RequestMapping("/save")
	@ResponseBody
	@cn.wudi.crm.utils.Resource("编辑")
	public AjaxResult save(Resource resource) {
		AjaxResult result = new AjaxResult();
		try {
			if(resource.getId()==null){
				resourceService.save(resource);
				result.setMsg("添加成功");
			}else {
				resourceService.update(resource);
				result.setMsg("修改成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setStatus(false);
			result.setMsg("出现异常："+e.getMessage()); 
		}
		return result;
	}
	
	@RequestMapping("/types")
	@ResponseBody
	@cn.wudi.crm.utils.Resource("获资源树")
	public List<SystemMenu> getResourceTypeNameTree(){
		return resourceService.getResourceTypeNames();
	}
	
	@RequestMapping("/typeResources")
	@ResponseBody
	@cn.wudi.crm.utils.Resource("获取方法资源")
	public Object getResources(String className){
		if(StringUtils.isEmpty(className)){
			return null;
		}
		return resourceService.getTypeResources(className);
	}
}
