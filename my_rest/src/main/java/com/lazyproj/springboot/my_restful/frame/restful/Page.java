package com.lazyproj.springboot.my_restful.frame.restful;

/**
 * @Author heliuslee@live.cn
 * @Date 2018/08/16 16:30
 * @Description
 */
public class Page {
	private Integer total;// 总页数
	private Integer	page;// 当前页
	private Integer size;// 显示条数
	private String prev;// 前一页url
	private String next;// 后一页url

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getPrev() {
		return prev;
	}

	public void setPrev(String prev) {
		this.prev = prev;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}
}
