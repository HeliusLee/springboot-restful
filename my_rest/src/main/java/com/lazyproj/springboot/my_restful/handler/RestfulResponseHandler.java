package com.lazyproj.springboot.my_restful.handler;

import com.lazyproj.springboot.my_restful.frame.ResponseResultInterceptor;
import com.lazyproj.springboot.my_restful.frame.Result;
import com.lazyproj.springboot.my_restful.frame.ResultFormat;
import com.lazyproj.springboot.my_restful.frame.restful.RestfulResult;
import com.lazyproj.springboot.my_restful.utils.RequestContextHolderUtils;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 处理Result
 * @Author heliuslee@live.cn
 * @Date 2018/08/17 18:25
 * @Description
 */
@ControllerAdvice
public class RestfulResponseHandler implements ResponseBodyAdvice {
	@Override
	public boolean supports(MethodParameter methodParameter, Class aClass) {
		ResultFormat resultFormatAnn = (ResultFormat) RequestContextHolderUtils.getRequest().getAttribute(ResponseResultInterceptor.RESULT_FORMAT);
		// 判断是requestAttr中是否存在RESULT_FORMAT
		return resultFormatAnn != null;
	}

	@Override
	public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest req, ServerHttpResponse resp) {
		ResultFormat responseResultAnn = (ResultFormat) RequestContextHolderUtils.getRequest().getAttribute(ResponseResultInterceptor.RESULT_FORMAT);

		Class<? extends Result> resultClazz = responseResultAnn.value();

		if (resultClazz.isAssignableFrom(RestfulResult.class)) {
//			if (o instanceof DefaultErrorResult) {
//				DefaultErrorResult defaultErrorResult = (DefaultErrorResult) body;
//				return PlatformResult.builder()
//						.code(Integer.valueOf(defaultErrorResult.getCode()))
//						.msg(defaultErrorResult.getMessage())
//						.data(defaultErrorResult.getErrors())
//						.build();
//			}

			return RestfulResult.success(body);
		}

		return body;
	}
}
