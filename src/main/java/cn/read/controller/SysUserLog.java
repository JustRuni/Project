package cn.read.controller;

import java.lang.reflect.Method;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.read.dao.SysLog;
import cn.read.service.ISysLogService;

@Component
@Aspect
public class SysUserLog {
	private Date visiTime;
	private Class clazz;
	private Method method;
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private ISysLogService sysLogService;
	//前置通知 获取开始时间 ，执行的是哪一个类 ， 执行的是哪一个状态
	@Before("execution(* cn.read.controller.*.*(..))*")
	public void doBefore(JoinPoint jp) throws NoSuchMethodException, SecurityException {
		//时间
		visiTime = new Date();
		//具体要的访问的类
		clazz = jp.getTarget().getClass();
		String methodName = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		if(args==null||args.length==0)	{
			method = clazz.getMethod(methodName);//获取无参方法
		}else {
			 //获取有参方法
			Class[] classArgs = new Class[args.length];
			for(int i = 0 ; i < args.length;i++) {
				classArgs[i] = args[i].getClass();
			}
			clazz.getMethod(methodName,classArgs);
		}
	}
	
	//后置通知
	@After("execution(* cn.read.controller.*.*(..))*")
	public void doAfter() {
		long time = new Date().getTime()-visiTime.getTime();
		String url ="";
		//访问的controller类不为空 ，方法不为空，当然也不是我们这个控制增强类
		if(clazz!=null&&method!=null&&clazz!=SysUserLog.class) {
			//1.获取类上的requestMapping上的value("")
			RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
			if(classAnnotation!=null) {
				String[] classValue = classAnnotation.value();
			//2.获取方法上的@requestMapping  value
			RequestMapping methodAnnoation = method.getAnnotation(RequestMapping.class);
				if(methodAnnoation !=null) {
					String[] methodValue = methodAnnoation.value();
					url = classValue[0]+methodValue[0];
				}
			}
		}
		
		//获取访问者的IP地址，request获取(需要在web.xml中配置)
		String ip = request.getRemoteAddr();
		
		//获取操作者
		SecurityContext context = SecurityContextHolder.getContext();
		User user = (User) context.getAuthentication().getPrincipal();
		String username = user.getUsername();
		request.getSession().setAttribute("username", username);
		//request.getSession().getAttribute("Spring_Security_Context")
		//将日志信息封装到类里面去
		SysLog sysLog = new SysLog();
		sysLog.setExecuteTime(time);
		sysLog.setIp(ip);
		sysLog.setUrl(url);
		sysLog.setVisitTime(visiTime);
		sysLog.setUsername(username);
		sysLog.setMethod("[类名]"+clazz.getName()+"[方法名]"+method.getName());
		//调用service
		sysLogService.save(sysLog);
	}
	
}
