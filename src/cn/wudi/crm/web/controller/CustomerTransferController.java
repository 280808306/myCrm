package cn.wudi.crm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wudi.crm.domain.AjaxResult;
import cn.wudi.crm.domain.CutomerTransfer;
import cn.wudi.crm.domain.PageData;
import cn.wudi.crm.query.CutomerTransferQuery;
import cn.wudi.crm.service.ICutomerTransferService;

@Controller
@RequestMapping("/cutomerTransfer")
public class CustomerTransferController {
	
	@Autowired
	private ICutomerTransferService cutomerTransferService;
//	把查询到的所有部门放在json中
	@RequestMapping("/list")
	@ResponseBody
	public PageData<CutomerTransfer> findAll(CutomerTransferQuery query){
		System.err.println(query);
//		System.err.println(customerTraceHistoryService.queryList(query));
		return cutomerTransferService.getPage(query);

	}
	@RequestMapping("/index")
	public String index(){
		return "cutomerTransfer/index";
	}
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult save(CutomerTransfer cutomerTransfer){
		AjaxResult result = new AjaxResult();
		try {
			if(cutomerTransfer.getId() != null) {
//				System.err.println(customerTraceHistory);
				cutomerTransferService.update(cutomerTransfer);
				result.setMsg("修改成功");
			} else {
				cutomerTransferService.save(cutomerTransfer);
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
	@RequestMapping("/delete")
	@ResponseBody
	public	AjaxResult delete(Long id) {
//		先得从前台页面上得到这个用户的id
		AjaxResult result = new AjaxResult();
		try {
			if(id != null) {
				// 修改这里所有的数据都修改到了 不用放置参数丢失
				cutomerTransferService.delete(id);
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
