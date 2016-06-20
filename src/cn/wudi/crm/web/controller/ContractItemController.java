package cn.wudi.crm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wudi.crm.domain.ContractItem;
import cn.wudi.crm.service.IContractItemService;
import cn.wudi.crm.utils.Resource;

@Resource("合同详情管理")
@Controller
@RequestMapping("/contractItem")
public class ContractItemController {

	@Autowired
	private IContractItemService contractItemService;

	@Resource("获取所属合同详情")
	@RequestMapping("/listByParent")
	@ResponseBody
	public List<ContractItem> listByParent(Long id) {
		if (id != null) {
			return contractItemService.getListByParent(id);
		}
		return null;
	}

}
