package com.lazyproj.springboot.my_restful.frame;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Component
public class HttpMethodInterceptor implements HandlerInterceptor {
	public static final String HTTP_METHOD = "HTTP_METHOD";
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// 判断 handler 是否是方法级
		if (handler instanceof HandlerMethod) {// 是
			final HandlerMethod handlerMethod = (HandlerMethod) handler;
			final Class<?> clazz = handlerMethod.getBeanType();// 拦截方法所属类
			final Method method = handlerMethod.getMethod();// 拦截方法
			// 判断类或方法是否被ResultFormat注解
			if (method.isAnnotationPresent(PostMapping.class)) {// 是
				// request中设置字段说明接口返回需要被格式化,这是因为ResponseBodyAdvice不能获取到注解信息
				request.setAttribute(HTTP_METHOD, HttpMethod.POST);
			}
		}
		// 继续执行
		return true;
	}
}
