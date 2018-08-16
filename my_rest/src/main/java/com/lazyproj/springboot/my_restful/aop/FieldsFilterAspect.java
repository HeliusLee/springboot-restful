package com.lazyproj.springboot.my_restful.aop;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.lazyproj.springboot.my_restful.frame.JsonMixIn;
import com.lazyproj.springboot.my_restful.utils.RestfulApiUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @Author heliuslee@live.cn
 * @Date 2018/08/15 10:09
 * @Description
 */
@Aspect
@Component
public class FieldsFilterAspect {
	@Pointcut("execution(public * com.lazyproj.springboot.my_restful.controller.*.*(..))")
	private void controllerPointcut() {
	}

	@Around("controllerPointcut()")
	public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

		Object[] objects = proceedingJoinPoint.getArgs();// 获取目标参数
		Signature sig = proceedingJoinPoint.getSignature();// 获取目标签名

		// 判断是否方法签名
		if (!(sig instanceof MethodSignature)) {// 否
			throw new IllegalArgumentException("该注解只能用于方法");
		}

		MethodSignature msig = (MethodSignature) sig;
		Object target = proceedingJoinPoint.getTarget();// 获取目标对象
		Method currentMethod = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());// 获取注解方法对象
		Class returnType = msig.getReturnType();// 获取返回类型

		// 判断是否包含@ResponseBody注解
		if (currentMethod.getAnnotation(ResponseBody.class) == null && target.getClass().getAnnotation(RestController.class) == null) {// 否
			return proceedingJoinPoint.proceed();
		}

		Object object;
		StringBuffer stringBuffer = new StringBuffer();
		try {
			object = proceedingJoinPoint.proceed();// 执行方法
		} catch (Throwable e) {
			stringBuffer.delete(0, stringBuffer.length());
			stringBuffer.append(" The called method: ")
					.append(proceedingJoinPoint.getSignature().getName()).append("(). The Exception Message is ");
			stringBuffer.append(e.toString());
			throw e;
		}

		ObjectMapper objectMapper = new ObjectMapper().addMixIn(Object.class, JsonMixIn.class);
		objectMapper.setFilterProvider(RestfulApiUtils.getFieldsFilter());

		String src = objectMapper.writeValueAsString(object);
		Object o = objectMapper.readValue(src, returnType);
		return o;
	}
}
