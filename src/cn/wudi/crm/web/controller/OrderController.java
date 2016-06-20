package cn.wudi.crm.web.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wudi.crm.domain.AjaxResult;
import cn.wudi.crm.domain.Order;
import cn.wudi.crm.domain.PageData;
import cn.wudi.crm.query.OrderQuery;
import cn.wudi.crm.service.IOrderService;
import cn.wudi.crm.utils.Resource;

/**
 * 订单管理控制器
 * 
 * @author lym
 *
 */

@Resource("订单管理")
@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private IOrderService orderService;

	@Resource("订单页面")
	@RequestMapping("/index")
	public String index() {
		return "order/index";
	}

	@Resource("订单列表")
	@RequestMapping("/list")
	@ResponseBody
	public PageData<Order> list(OrderQuery query) {
		return orderService.getPage(query);
	}

	@Resource("订单保存")
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult save(Order order) {
		AjaxResult result = new AjaxResult();
		try {
			if (order.getSignTime() == null) {
				order.setSignTime(new Date());
			}
			if (order.getId() == null) {
				orderService.save(order);
			} else {
				orderService.update(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setStatus(false);
			result.setMsg(e.getMessage());
		}
		return result;
	}

	@Resource("订单删除")
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delete(Long id) {
		AjaxResult result = new AjaxResult();
		try {
			orderService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			result.setStatus(false);
			result.setMsg(e.getMessage());
		}
		return result;
	}

}
