package com.lazyproj.springboot.my_restful.frame;

import com.lazyproj.springboot.my_restful.frame.restful.RestfulResult;

import java.lang.annotation.*;

/**
 * 设定返回结果的格式类型
 * @Author heliuslee@live.cn
 * @Date 2018/08/17 18:47
 * @Description
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ResultFormat {
	// 默认格式类型为RestfulResult
	Class<? extends Result>  value() default RestfulResult.class;
}
