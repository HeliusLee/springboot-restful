package com.lazyproj.springboot.my_restful.frame;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 响应数据拦截器
 *
 * @Author heliuslee@live.cn
 * @Date 2018/08/17 18:54
 * @Description
 */
@Component
public class ResultFormatInterceptor implements HandlerInterceptor {
	public static final String RESULT_FORMAT = "RESULT_FORMAT";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		// 判断 handler 是否是方法级
		if (handler instanceof HandlerMethod) {// 是
			final HandlerMethod handlerMethod = (HandlerMethod) handler;
			final Class<?> clazz = handlerMethod.getBeanType();// 拦截方法所属类
			final Method method = handlerMethod.getMethod();// 拦截方法
			// 判断类或方法是否被ResultFormat注解
			if (clazz.isAnnotationPresent(ResultFormat.class) || method.isAnnotationPresent(ResultFormat.class)) {// 是
				// request中设置字段说明接口返回需要被格式化,这是因为ResponseBodyAdvice不能获取到注解信息
				request.setAttribute(RESULT_FORMAT, clazz.getAnnotation(ResultFormat.class));
			}
		}
		// 继续执行
		return true;
	}
}
