package cn.wudi.crm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wudi.crm.domain.AjaxResult;
import cn.wudi.crm.domain.Guarantee;
import cn.wudi.crm.domain.PageData;
import cn.wudi.crm.query.GuaranteeQuery;
import cn.wudi.crm.service.IGuaranteeService;
import cn.wudi.crm.utils.Resource;

@Resource("保修管理")
@Controller
@RequestMapping("/guarantee")
public class GuaranteeController {

	@Autowired
	private IGuaranteeService guaranteeService;

	@Resource("保修页面")
	@RequestMapping("/index")
	public String index() {
		return "/guarantee/index";
	}

	@Resource("保修列表")
	@RequestMapping("/list")
	@ResponseBody
	public PageData<Guarantee> list(GuaranteeQuery query) {
		return guaranteeService.getPage(query);
	}

	@Resource("保修保存")
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult save(Guarantee guarantee) {
		AjaxResult ajaxResult = new AjaxResult();
		try {
			if (guarantee.getId() == null) {
				guaranteeService.save(guarantee);
			} else {
				guaranteeService.update(guarantee);
			}
		} catch (Exception e) {
			e.printStackTrace();
			ajaxResult.setStatus(false);
			ajaxResult.setMsg(e.getMessage());
		}
		return ajaxResult;
	}

	@Resource("保修删除")
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delete(Long id) {
		AjaxResult result = new AjaxResult();
		try {
			guaranteeService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			result.setStatus(false);
			result.setMsg(e.getMessage());
		}
		return result;
	}

}
