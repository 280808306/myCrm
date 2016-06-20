package cn.wudi.crm.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wudi.crm.domain.Employee;
import cn.wudi.crm.domain.SystemMenu;
import cn.wudi.crm.service.ISystemMenuService;


@Controller
@RequestMapping("/index")
public class IndexController {
	
	@Autowired
	private ISystemMenuService systemMenuService;
	
	// 主界面的控制器
	/**
	 * 跳转到主界面
	 */
	@RequestMapping("")
	public void index(){}
	
	@RequestMapping("/welcome")
	public String welcome(){
		return "welcome";
	}
	
	/**
	 * 获取当前用户的菜单
	 */
	@RequestMapping("/menus")
	@ResponseBody
	public List<SystemMenu> menus(HttpSession session){
		return systemMenuService.getUserMenus(new Employee());
	}
	
}
