package com.lazyproj.springboot.my_restful.frame.restful;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.lazyproj.springboot.my_restful.enums.BizResultCode;
import com.lazyproj.springboot.my_restful.frame.Result;

/**
 * RESTful通用返回格式
 *
 * @Author heliuslee@live.cn
 * @Date 2018/08/16 16:14
 * @Description
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestfulResult<T> implements Result {
	private static final String DEFAULT_MESSAGE = "no more details";

	private T data;// 响应数据
	private int status;// 响应状态码
	private String msg;// 响应详情
	private Page paging;// 分页信息
	private String links;// 相关链接

	public RestfulResult() {
		this.status = BizResultCode.OK.code();
		this.msg = DEFAULT_MESSAGE;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
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
