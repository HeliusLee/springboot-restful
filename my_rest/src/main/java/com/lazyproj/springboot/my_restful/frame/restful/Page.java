package com.lazyproj.springboot.my_restful.frame.restful;

/**
 * @Author heliuslee@live.cn
 * @Date 2018/08/16 16:30
 * @Description
 */
public class Page {
	private int total;// 总页数
	private int	page;// 当前页
	private int size;// 显示条数
	private String prev;// 前一页url
	private String next;// 后一页url

	public Page(int page, int size) {
		this.page = page;
		this.size = size;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
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
