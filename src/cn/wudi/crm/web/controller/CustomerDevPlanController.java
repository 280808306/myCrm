package cn.wudi.crm.web.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wudi.crm.domain.AjaxResult;
import cn.wudi.crm.domain.CustomerDevPlan;
import cn.wudi.crm.domain.Employee;
import cn.wudi.crm.domain.PageData;
import cn.wudi.crm.domain.SystemDictionaryItem;
import cn.wudi.crm.query.CustomerDevPlanQuery;
import cn.wudi.crm.service.ICustomerDevPlanService;
import cn.wudi.crm.utils.Resource;

/**
 * 潜在客户开发计划管理控制器
 * 
 * @author lym
 *
 */
@Resource("潜在客户开发计划管理")
@Controller
@RequestMapping("/customerDevPlan")
public class CustomerDevPlanController {

	@Autowired
	private ICustomerDevPlanService customerDevPlanService;

	@Resource("潜在客户开发计划页面")
	@RequestMapping("/index")
	public String index() {
		return "customerDevPlan/index";
	}

	@Resource("潜在客户开发计划列表")
	@RequestMapping("/list")
	@ResponseBody
	public PageData<CustomerDevPlan> list(CustomerDevPlanQuery query) {
		PageData<CustomerDevPlan> page = customerDevPlanService.getPage(query);
		System.out.println(page.getRows());
		return page;
	}

	@Resource("潜在客户开发计划保存")
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult save(CustomerDevPlan devPlan) {
		AjaxResult result = new AjaxResult();
		try {
			devPlan.setInputTime(new Date());

			Employee employee = new Employee();
			employee.setId(1L);
			devPlan.setInputUser(employee);

			SystemDictionaryItem item = new SystemDictionaryItem();
			item.setId(1L);
			devPlan.setPlanType(item);

			if (devPlan.getId() == null) {
				customerDevPlanService.save(devPlan);
			} else {
				customerDevPlanService.update(devPlan);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setStatus(false);
			result.setMsg(e.getMessage());
		}
		return result;
	}

	@Resource("潜在客户开发计划删除")
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delete(Long id) {
		AjaxResult result = new AjaxResult();
		try {
			customerDevPlanService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			result.setStatus(false);
			result.setMsg(e.getMessage());
		}
		return result;
	}

}
