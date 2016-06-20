package cn.wudi.crm.web.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wudi.crm.domain.AjaxResult;
import cn.wudi.crm.domain.Employee;
import cn.wudi.crm.domain.PageData;
import cn.wudi.crm.domain.PotentialCustomer;
import cn.wudi.crm.query.PotentialCustomerQuery;
import cn.wudi.crm.service.IPotentialCustomerService;
import cn.wudi.crm.utils.Resource;

/**
 * 潜在客户信息管理控制器
 * 
 * @author lym
 *
 */
@Resource("潜在客户管理")
@Controller
@RequestMapping("/potentialCustomer")
public class PotentialCustomerController {

	@Autowired
	private IPotentialCustomerService potentialCustomerService;

	@Resource("潜在客户信息页面")
	@RequestMapping("/index")
	public String index() {
		return "potentialCustomer/index";
	}

	@Resource("潜在客户信息列表")
	@RequestMapping("/list")
	@ResponseBody
	public PageData<PotentialCustomer> list(PotentialCustomerQuery query) {
		return potentialCustomerService.getPage(query);
	}

	@Resource("潜在客户信息保存")
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult save(PotentialCustomer customer) {
		AjaxResult result = new AjaxResult();
		try {
			customer.setInputTime(new Date());
			Employee employee = new Employee();
			employee.setId(1L);
			customer.setInputUser(employee);
			if (customer.getId() == null) {
				potentialCustomerService.save(customer);
			} else {
				potentialCustomerService.update(customer);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setStatus(false);
			result.setMsg(e.getMessage());
		}
		return result;
	}

	@Resource("潜在客户信息删除")
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delete(Long id) {
		AjaxResult result = new AjaxResult();
		try {
			potentialCustomerService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			result.setStatus(false);
			result.setMsg(e.getMessage());
		}
		return result;
	}

}
