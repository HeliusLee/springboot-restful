package com.lazyproj.springboot.my_restful.frame.restful;

import com.github.pagehelper.PageInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import java.io.IOException;
import java.lang.reflect.Type;

/**
 * @Author heliuslee@live.cn
 * @Date 2018/08/17 12:27
 * @Description
 */
@Configuration
public class RestfulHttpMessageConverter {
	/**
	 * MappingJackson2HttpMessageConverter ContentType是json格式,将controller返回对象写入responseBody时会掉用该类完成该过程
	 * 重写writeInternal改变写入规则
	 * @return
	 */
	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter() {
			@Override
			protected void writeInternal(Object object, Type type, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
				RestfulResult restfulResult = new RestfulResult();
				// 判断返回对象是不是分页对象
				if (!(object instanceof PageInfo)) {// 不是
					// 将返回对象使用restfulResult封装好
					restfulResult.setData(object);
					super.writeInternal(restfulResult, type, outputMessage);
					return;
				}

				// 是分页对象
				PageInfo pageInfo = ((PageInfo) object);
				// 判断返回数据是不是使用分页了
				if (pageInfo.getPageNum() == 0) {// 没分页, pageNum=0 说明接口方法不分页
					// 将返回对象使用restfulResult封装好
					restfulResult.setData(pageInfo.getList());
				}else {// 分页了
					// 将返回对象使用restfulResult封装好
					restfulResult.setData(pageInfo.getList());
					// 保存page信息
					restfulResult.setPaging(new Page(pageInfo.getTotal(), pageInfo.getPageNum(), pageInfo.getPageSize()));
				}
				super.writeInternal(restfulResult, type, outputMessage);
			}
		};
		// 自定义converter
		return converter;
	}
}
