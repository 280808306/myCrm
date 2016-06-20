package cn.wudi.crm.web.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wudi.crm.domain.AjaxResult;
import cn.wudi.crm.domain.Contract;
import cn.wudi.crm.domain.PageData;
import cn.wudi.crm.query.ContractQuery;
import cn.wudi.crm.service.IContractService;
import cn.wudi.crm.utils.Resource;

@Resource("合同管理")
@Controller
@RequestMapping("/contract")
public class ContractController {

	@Autowired
	private IContractService contractService;

	@Resource("合同页面")
	@RequestMapping("/index")
	public String index() {
		return "contract/index";
	}

	@Resource("合同列表")
	@RequestMapping("/list")
	@ResponseBody
	public PageData<Contract> list(ContractQuery query) {
		return contractService.getPage(query);
	}

	@Resource("合同保存")
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult save(Contract contract) {
		AjaxResult result = new AjaxResult();
		try {
			if (contract.getSignTime() == null) {
				contract.setSignTime(new Date());
			}
			if (contract.getId() == null) {
				contractService.save(contract);
			} else {
				contractService.update(contract);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setStatus(false);
			result.setMsg(e.getMessage());
		}
		return result;
	}

	@Resource("合同删除")
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delete(Long id) {
		AjaxResult result = new AjaxResult();
		try {
			contractService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			result.setStatus(false);
			result.setMsg(e.getMessage());
		}
		return result;
	}

}
