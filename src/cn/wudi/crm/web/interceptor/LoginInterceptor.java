package cn.wudi.crm.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;

import cn.wudi.crm.domain.Employee;
import cn.wudi.crm.utils.UserContext;

public class LoginInterceptor extends AbstractInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Employee user = UserContext.getUser();
		System.out.println(user);
		//检查用户是否存在
		if(user!=null){
			//URL资源访问权限
			//获取请求信息
			if(user.getUsername().equals("admin")){
				return true;
			}
			if(handler instanceof HandlerMethod){
				HandlerMethod hm =(HandlerMethod) handler;
				String controllerName  = hm.getBeanType().getName();
				String methodName = hm.getMethod().getName();
				String resourceUrl = controllerName+":"+methodName;
				//System.err.println("resourceUrl:" + resourceUrl);
				//判断用户是否有权限
				if(!UserContext.checkUserPermission(resourceUrl)){
					//没有就提示
					response.sendRedirect("/noPermission.json");
					return false;
				}
			}
			//放行
			System.out.println(user.getPermissions());
			System.out.println(UserContext.isManagerRole());
			return true;
		}
		response.sendRedirect("/login/index");
		return false;
	}
}
