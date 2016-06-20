package cn.wudi.crm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wudi.crm.domain.AjaxResult;
import cn.wudi.crm.domain.PageData;
import cn.wudi.crm.domain.SystemDictionaryItem;
import cn.wudi.crm.query.SystemDictionaryItemQuery;
import cn.wudi.crm.service.ISystemDictionaryItemService;
import cn.wudi.crm.utils.Resource;

/**
 * 数据字典和明细界面
 * @author zh
 */
@Controller
@RequestMapping("/systemDictionaryItem")
@Resource("数据字典明细")
public class SystemDictionaryItemController  {
	
	@Autowired
	private ISystemDictionaryItemService systemDictionaryItemService;
	
	@RequestMapping("/list")
	@ResponseBody
	@Resource("列表")
	public PageData<SystemDictionaryItem> list(SystemDictionaryItemQuery query){
		return systemDictionaryItemService.getPage(query);
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	@Resource("编辑")
	public Object edit(SystemDictionaryItem systemDictionaryItem){
		AjaxResult result = new AjaxResult();
		try {
			if(systemDictionaryItem.getId() != null) {
				// 修改这里所有的数据都修改到了 不用放置参数丢失
				systemDictionaryItemService.update(systemDictionaryItem);
				result.setMsg("修改成功");
			} else {
				systemDictionaryItemService.save(systemDictionaryItem);
				result.setMsg("添加成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setStatus(true);
			result.setMsg("出现异常："+e.getMessage()); 
		}
		return result;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	@Resource("删除")
	public Object delete(Long id){
		AjaxResult result = new AjaxResult();
		try {
			if(id != null) {
				// 修改这里所有的数据都修改到了 不用放置参数丢失
				systemDictionaryItemService.delete(id);
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
	
	
	/**
	 * 根据父类的id 查询 所有的字典明细
	 * @return
	 */
	@RequestMapping("/listByPartenId")
	@ResponseBody
	public List<SystemDictionaryItem> listByParentId(Long parentId){
		return systemDictionaryItemService.getByParentId(parentId);
	}
	
}
