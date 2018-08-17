package com.lazyproj.springboot.my_restful.utils;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author heliuslee@live.cn
 * @Date 2018/08/17 19:47
 * @Description
 */
public class RequestContextHolderUtils {
	public static HttpServletRequest getRequest() {
		return getRequestAttributes().getRequest();
	}

	public static HttpServletResponse getResponse() {
		return getRequestAttributes().getResponse();
	}

	public static HttpSession getSession() {
		return getRequest().getSession();
	}

	public static ServletRequestAttributes getRequestAttributes() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes());
	}

	public static ServletContext getServletContext() {
		return ContextLoader.getCurrentWebApplicationContext().getServletContext();
	}
}
