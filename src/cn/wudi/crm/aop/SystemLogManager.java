package cn.wudi.crm.aop;

import java.lang.reflect.Method;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.wudi.crm.domain.Employee;
import cn.wudi.crm.domain.SystemLog;
import cn.wudi.crm.service.ISystemLogService;
import cn.wudi.crm.utils.UserContext;

@Component
@Aspect
public class SystemLogManager {
	
	@Autowired
	private ISystemLogService systemLogService;
	
	/**
	 * 配置日志的切点方法
	 */
	@Pointcut("execution(* cn.wudi.crm.service..*.*(..))")
	public void pointCut(){
		
	}
	
	/**
	 * 日志的核心方法
	 * @param joinPoint 当前加入的点 执行的方法
	 */
	@After("pointCut()")
	public void log(JoinPoint joinPoint) throws Exception{
		
		//如果是日志服务不记录
		if(joinPoint.getTarget() instanceof ISystemLogService && joinPoint.getSignature().getName().equals("save")) {
			return;
		}
		
		//获取当前访问的类
		Class<? extends Object> clzz = joinPoint.getTarget().getClass();
		
		//获取方法的签名
		MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
		String methodName = methodSignature.getName();
		LogInfo classLogInfo = clzz.getAnnotation(LogInfo.class);
		
		//获取当前访问的方法
		Method method = clzz.getMethod(methodName, methodSignature.getParameterTypes());
		LogInfo methodLogInfo = method.getAnnotation(LogInfo.class);
		
		//如果不需要记录则直接 返回
		if(methodLogInfo != null && methodLogInfo.ignore()){
			return;
		}
		
		// 日志对象
		SystemLog systemLog = new SystemLog();
		
		//	设置访问时间
		systemLog.setOpTime(new Date());
		
		//获取已经登录的用户
		Employee user  = new Employee();
		user.setId(1L);
		systemLog.setOpUser(user);
		
		//设置用户登录的ip
		systemLog.setOpIp(UserContext.getRequest().getRemoteAddr());
		
		
		// 访问的地址  className
		String className = clzz.getName();
		
		if(methodLogInfo != null){
			methodName = methodLogInfo.value();
		}
	
		if(classLogInfo != null){
			className = classLogInfo.value();
		}
		
		String function = className +":"+ methodName;
		
		systemLog.setFunction(function);
		
		systemLogService.save(systemLog);
		
	}
}
