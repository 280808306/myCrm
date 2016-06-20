package cn.wudi.crm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wudi.crm.domain.AjaxResult;
import cn.wudi.crm.domain.Customer;
import cn.wudi.crm.domain.PageData;
import cn.wudi.crm.query.CustomerQuery;
import cn.wudi.crm.service.ICustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private ICustomerService customerService;
//	把查询到的所有部门放在json中
	@RequestMapping("/list")
	@ResponseBody
	public PageData<Customer> findAll(CustomerQuery query){
		return customerService.getPage(query);
	}
	@RequestMapping("/index")
	public String index(){
		return "customer/index";
	}
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult save(Customer customer){
		AjaxResult result = new AjaxResult();
		try {
			if(customer.getId() != null) {
				customerService.update(customer);
				result.setMsg("修改成功");
			} else {
				customerService.save(customer);
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
				customerService.delete(id);
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
	
//  改变客户状态方法
	@RequestMapping("/change")
	@ResponseBody
	public	AjaxResult update(Long id) {
//		先得从前台页面上得到这个用户的id
		AjaxResult result = new AjaxResult();
		try {
				// 修改这里所有的数据都修改到了 不用放置参数丢失
			 Customer customer = customerService.get(id);
			   customer.setStatus(3);
			   customer.setSeller(null);
				customerService.update(customer);
				result.setMsg("放入资源池成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setStatus(false);
			result.setMsg("出现异常："+e.getMessage()); 
		}
		return result;
	}
	
}
