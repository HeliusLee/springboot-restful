package com.lazyproj.springboot.my_restful.frame.restful;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author heliuslee@live.cn
 * @Date 2018/08/15 15:40
 * @Description
 */
public class Fields {
	private List<String> include;
	private List<String> exclude;

	public Fields() {
		include = new ArrayList<>();
		exclude = new ArrayList<>();
	}

	public Fields(String src){}


	public List<String> getInclude() {
		return include;
	}

	public void setInclude(List<String> include) {
		this.include = include;
	}

	public List<String> getExclude() {
		return exclude;
	}

	public void setExclude(List<String> exclude) {
		this.exclude = exclude;
	}
}
