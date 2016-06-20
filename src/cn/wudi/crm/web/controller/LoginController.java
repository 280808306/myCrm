package cn.wudi.crm.web.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wudi.crm.domain.AjaxResult;
import cn.wudi.crm.domain.Employee;
import cn.wudi.crm.service.IEmployeeService;
import cn.wudi.crm.utils.UserContext;
import cn.wudi.crm.utils.ValidateCode;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private IEmployeeService employeeService;

	@RequestMapping("/index")
	public String index() {
		return "login";
	}

	@RequestMapping("/checkLogin")
	@ResponseBody
	public AjaxResult checkLogin(String captcha, String username, String password, HttpSession session) {
		AjaxResult result = new AjaxResult();
		System.out.println(UserContext.getValidateCode());
		if(!UserContext.getValidateCode().equalsIgnoreCase(captcha)){
			result.setStatus(false);
			result.setMsg("验证码错误");
			return result;
		}
		Employee employee = employeeService.getEmployeeByUsername(username);
		System.out.println(employee);
		if (employee == null) {
			result.setStatus(false);
			result.setMsg("用户不存在");
		} else if (password.equals(employee.getPassword())) {
			UserContext.setUser(employee);
		} else {
			result.setStatus(false);
			result.setMsg("密码错误");
		}
		return result;
	}
	
	@RequestMapping("/validateCode")
	@ResponseBody
	public void validateCode(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ValidateCode.addDefaultCode(request, response);
	}
}