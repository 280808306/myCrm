package cn.wudi.crm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wudi.crm.domain.AjaxResult;
import cn.wudi.crm.domain.PageData;
import cn.wudi.crm.domain.SystemLog;
import cn.wudi.crm.query.SystemLogQuery;
import cn.wudi.crm.service.ISystemLogService;
import cn.wudi.crm.utils.Resource;

@Controller
@RequestMapping("/systemlog")
@Resource("系统日志")
public class SystemLogController {
	
	@Autowired
	private ISystemLogService systemLogService;
	
	@RequestMapping("/index")
	@Resource("导向")
	public String index(){
		return "systemlog/systemlog";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	@Resource("列表")
	public PageData<SystemLog> list(SystemLogQuery query){
		return systemLogService.getPage(query);
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	@Resource("删除")
	public AjaxResult delete(Long id){
		AjaxResult ajaxResult = new AjaxResult();
		try {
			if(id != null){
				systemLogService.delete(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
			ajaxResult.setStatus(false);
			ajaxResult.setMsg("发生异常:"+e.getMessage());
		}
		return ajaxResult;
	}
}
