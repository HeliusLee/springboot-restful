package com.lazyproj.springboot.my_restful.frame;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.databind.ser.BeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.FilterProvider;

/**
 * @Author heliuslee@live.cn
 * @Date 2018/08/15 14:19
 * @Description
 */
@JsonFilter("dynamicFilter")
public class JsonMixIn {
}
