package cn.wudi.crm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wudi.crm.domain.AjaxResult;
import cn.wudi.crm.domain.PageData;
import cn.wudi.crm.domain.SystemDictionary;
import cn.wudi.crm.query.SystemDictionaryQuery;
import cn.wudi.crm.service.ISystemDictionaryService;
import cn.wudi.crm.utils.Resource;

/**
 * 数据字典和明细界面
 * @author zh
 */
@Controller
@RequestMapping("/systemDictionary")
@Resource("数据字典")
public class SystemDictionaryController  {
	
	@Autowired
	private ISystemDictionaryService systemDictionaryService;
	
	@RequestMapping("")
	@Resource("导向")
	public String index(){
		return "systemDictionary/systemDictionary";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	@Resource("列表")
	public PageData<SystemDictionary> list(SystemDictionaryQuery query){
		return systemDictionaryService.getPage(query);
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	@Resource("修改")
	public Object edit(SystemDictionary systemDictionary){
		AjaxResult result = new AjaxResult();
		try {
			if(systemDictionary.getId() != null) {
				// 修改这里所有的数据都修改到了 不用放置参数丢失
				systemDictionaryService.update(systemDictionary);
				result.setMsg("修改成功");
			} else {
				systemDictionaryService.save(systemDictionary);
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
				systemDictionaryService.delete(id);
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
