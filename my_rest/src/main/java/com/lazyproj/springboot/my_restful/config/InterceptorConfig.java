package com.lazyproj.springboot.my_restful.config;

import com.lazyproj.springboot.my_restful.frame.HttpMethodInterceptor;
import com.lazyproj.springboot.my_restful.frame.response.ResultFormatInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
	@Autowired
	private ResultFormatInterceptor resultFormatInterceptor;
	@Autowired
	private HttpMethodInterceptor httpMethodInterceptor;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		String apiUri = "/**";
		registry.addInterceptor(resultFormatInterceptor).addPathPatterns(apiUri);
		registry.addInterceptor(httpMethodInterceptor).addPathPatterns(apiUri);
	}
}
