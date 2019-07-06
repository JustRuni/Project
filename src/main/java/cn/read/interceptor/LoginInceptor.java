package cn.read.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInceptor implements HandlerInterceptor{

	//进入方法前被执行
	//登录拦截，权限验证等等
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//返回true时放行，false时被拦截
		Object object = request.getSession().getAttribute("username");
		Object object2 = request.getSession().getAttribute("password");
		if(object!=null&&object2!=null) {
			return true;
		}else
		{
			request.getRequestDispatcher("/user/noAuth").forward(request, response);//请求重定向
		}
		return false;
	}

	//方法执行之后，返回ModelAndView之前被执行
	//设置页面的共用参数等等
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	//方法执行后被执行
	//处理异常，清资源，记录日志等等
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	
	}

}
