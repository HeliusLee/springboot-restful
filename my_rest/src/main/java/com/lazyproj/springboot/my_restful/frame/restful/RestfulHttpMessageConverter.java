package com.lazyproj.springboot.my_restful.frame.restful;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xerces.internal.parsers.SecurityConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author heliuslee@live.cn
 * @Date 2018/08/17 12:27
 * @Description
 */
//@Configuration
public class RestfulHttpMessageConverter {
//	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter() {
			@Override
			protected void writeInternal(Object object, Type type, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
				RestfulResult restfulResult = new RestfulResult();
				if (!(object instanceof PageInfo)) {
					restfulResult.setData(object);
					super.writeInternal(restfulResult, type, outputMessage);
					return;
				}
				PageInfo pageInfo = ((PageInfo) object);
				if (pageInfo.getPageNum() == 0) {
					restfulResult.setData(pageInfo.getList());
				}else {
					restfulResult.setData(pageInfo.getList());
					restfulResult.setPaging(new Page(pageInfo.getTotal(), pageInfo.getPageNum(), pageInfo.getPageSize()));
				}
				super.writeInternal(restfulResult, type, outputMessage);
			}
		};
		// 自定义converter

		return converter;
	}
}
