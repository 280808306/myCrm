package cn.wudi.crm.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wudi.crm.domain.AjaxResult;
import cn.wudi.crm.domain.CustomerTraceHistory;
import cn.wudi.crm.domain.PageData;
import cn.wudi.crm.query.CustomerTraceHistoryQuery;
import cn.wudi.crm.service.ICustomerTraceHistoryService;

@Controller
@RequestMapping("/customerTraceHistory")
public class CustomerTraceHistoryController {
	
	@Autowired
	private ICustomerTraceHistoryService customerTraceHistoryService;
//	把查询到的所有部门放在json中
	@RequestMapping("/list")
	@ResponseBody
	public PageData<CustomerTraceHistory> findAll(CustomerTraceHistoryQuery query){
		System.err.println(query);
//		System.err.println(customerTraceHistoryService.queryList(query));
		return customerTraceHistoryService.getPage(query);

	}
	@RequestMapping("/index")
	public String index(){
		return "customerTraceHistory/index";
	}
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult save(CustomerTraceHistory customerTraceHistory){
		AjaxResult result = new AjaxResult();
		try {
			if(customerTraceHistory.getId() != null) {
//				System.err.println(customerTraceHistory);
				customerTraceHistoryService.update(customerTraceHistory);
				result.setMsg("修改成功");
			} else {
				customerTraceHistoryService.save(customerTraceHistory);
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
				customerTraceHistoryService.delete(id);
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
