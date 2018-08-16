package com.lazyproj.springboot.my_restful.frame.restful;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RESTful通用返回格式
 *
 * @Author heliuslee@live.cn
 * @Date 2018/08/16 16:14
 * @Description
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestfulResult {
	private Object data;// 响应数据
	private String status;// 响应状态码
	private String msg;// 响应详情
	private Page paging;// 分页信息
	private String links;// 相关链接

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Page getPaging() {
		return paging;
	}

	public void setPaging(Page paging) {
		this.paging = paging;
	}

	public String getLinks() {
		return links;
	}

	public void setLinks(String links) {
		this.links = links;
	}
}
