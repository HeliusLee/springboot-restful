package com.lazyproj.springboot.my_restful.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.lazyproj.springboot.my_restful.frame.restful.Fields;
import org.mortbay.util.MultiMap;
import org.mortbay.util.UrlEncoded;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author heliuslee@live.cn
 * @Date 2018/08/15 15:26
 * @Description
 */
@Component
public class RestfulApiUtils {

	public static JsonNode getRestfulParams() {
		HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		String queryString = req.getQueryString();
		MultiMap values = new MultiMap();
		UrlEncoded.decodeTo(queryString, values, "UTF-8");
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.valueToTree(values);
		return jsonNode;
	}

	private static Fields getFields() {
		if (getRestfulParams().get("fields") == null){
			return null;
		}

		String fieldsStr = getRestfulParams().get("fields").textValue();
		Fields fields = new Fields();
		String[] fieldArr = fieldsStr.trim().split(",");
		for (String field : fieldArr) {
			if (field.startsWith("-")) {
				fields.getExclude().add(field.substring(1));
			} else if (field.startsWith("+")) {
				fields.getInclude().add(field.substring(1));
			} else {
				fields.getInclude().add(field);
			}
		}
		return fields;
	}

	public static FilterProvider getFieldsFilter() {
		SimpleFilterProvider simpleFilterProvider = new SimpleFilterProvider();
		// 获取参数中字段过滤信息
		Fields fields = getFields();

		// 判断是否存在过滤信息
		if (fields == null){// 不存在
			return simpleFilterProvider.addFilter("dynamicFilter", SimpleBeanPropertyFilter.serializeAll());
		}

		// 存在,判断包含字段是否为空
		if (fields.getInclude().size() != 0) {// 包含
			// 过滤除了包含字段的所有字段
			simpleFilterProvider.addFilter("dynamicFilter", SimpleBeanPropertyFilter.filterOutAllExcept(fields.getInclude().toArray(new String[fields.getInclude().size()])));
		} else {// 不包含
			// 之过滤指定过滤字段
			simpleFilterProvider.addFilter("dynamicFilter", SimpleBeanPropertyFilter.serializeAllExcept(fields.getExclude().toArray(new String[fields.getExclude().size()])));
		}

		return simpleFilterProvider;
	}
}
