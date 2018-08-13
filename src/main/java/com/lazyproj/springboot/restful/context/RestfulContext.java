package com.lazyproj.springboot.restful.context;

import com.lazyproj.springboot.restful.pojo.domain.Sort;
import com.lazyproj.springboot.restful.utils.SpringUtils;

/**
 * Restful上下文
 * -
 * @Author heliuslee@live.cn
 * @Date 2018/08/10 15:46
 * @Description
 */
public class RestfulContext {
	private Sort sort;

	private static RestfulContext init(){
		return SpringUtils.getBean(RestfulContext.class);
	}

	public Sort getSort() {
		return sort;
	}

	public void setSort(Sort sort) {
		this.sort = sort;
	}
}
