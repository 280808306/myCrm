package cn.wudi.crm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wudi.crm.domain.GuaranteeItem;
import cn.wudi.crm.service.IGuaranteeItemService;
import cn.wudi.crm.utils.Resource;

@Resource("保修详情管理")
@Controller
@RequestMapping("/guaranteeItem")
public class GuaranteeItemController {

	@Autowired
	private IGuaranteeItemService guaranteeItemService;

	@Resource("获取所属保修详情")
	@RequestMapping("/listByParent")
	@ResponseBody
	public List<GuaranteeItem> listByParent(Long id) {
		if (id != null) {
			return guaranteeItemService.getListByParent(id);
		}
		return null;
	}

}
