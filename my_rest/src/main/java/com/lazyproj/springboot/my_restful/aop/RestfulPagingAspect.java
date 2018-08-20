package com.lazyproj.springboot.my_restful.aop;

import com.github.pagehelper.PageInfo;
import com.lazyproj.springboot.my_restful.frame.restful.Page;
import com.lazyproj.springboot.my_restful.frame.restful.RestfulResult;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;

/**
 * @Author heliuslee@live.cn
 * @Date 2018/08/17 10:33
 * @Description
 */
//@Aspect
//@Order(1)
//@Component
public class RestfulPagingAspect {
	@Pointcut("execution(public * com.lazyproj.springboot.my_restful.controller.*.*(..))")
	private void controllerPointcut() {
	}

	@AfterReturning("controllerPointcut()")
	public void afterReturning (JoinPoint joinPoint) {
		Object target = joinPoint.getTarget();
		System.out.println(target);
	}
//	@Around("controllerPointcut()")
//	public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//		Object[] objects = proceedingJoinPoint.getArgs();// 获取目标参数
//		Signature sig = proceedingJoinPoint.getSignature();// 获取目标签名
//
//		// 判断是否方法签名
//		if (!(sig instanceof MethodSignature)) {// 否
//			throw new IllegalArgumentException("该注解只能用于方法");
//		}
//
//		MethodSignature msig = (MethodSignature) sig;
//		Object target = proceedingJoinPoint.getTarget();// 获取目标对象
//		Method currentMethod = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());// 获取注解方法对象
//		Class returnType = msig.getReturnType();// 获取返回类型
//
//		// 判断是否包含@ResponseBody注解
//		if (currentMethod.getAnnotation(ResponseBody.class) == null && target.getClass().getAnnotation(RestController.class) == null) {// 否
//			return proceedingJoinPoint.proceed();
//		}
//
//		RestfulResult restfulResult = new RestfulResult();
//
//		Object response;
//		StringBuffer stringBuffer = new StringBuffer();
//
//		try {
//			response = proceedingJoinPoint.proceed();// 执行方法
//		} catch (Throwable e) {
//			throw e;
//		}
//
//		System.out.println(response.getClass());
//		if (!(response instanceof PageInfo)) {
//			restfulResult.setData(response);
//			return restfulResult;
//		}
//
//		PageInfo pageInfo = ((PageInfo) response);
//		if (pageInfo.getPageNum() == 0) {
//			restfulResult.setData(pageInfo.getList());
//		}else {
//			restfulResult.setData(pageInfo.getList());
//			restfulResult.setPaging(new Page(pageInfo.getTotal(), pageInfo.getPageNum(), pageInfo.getPageSize()));
//		}
//		return restfulResult;
//	}
}
