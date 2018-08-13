package com.lazyproj.springboot.restful.pojo.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author heliuslee@live.cn
 * @Date 2018/08/13 14:13
 * @Description
 */
public class Sort {
	private static final String DESC = "DESC";
	private static final String ASC = "ASC";

	private List<Order> orderList;

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	public Sort(String sort) {
		if (sort == null) {
			return;
		}

		String[] fieldArr = sort.split(",");
		List<Order> orderList = new ArrayList<>();
		for (String field : fieldArr) {
			Order order = new Order();
			if (field.startsWith("-")){
				order.setField(field.substring(1));
				order.setDirection(DESC);
			}else if(field.startsWith("+")){
				order.setField(field.substring(1));
				order.setDirection(ASC);
			}else {
				order.setField(field);
				order.setDirection(ASC);
			}
			orderList.add(order);
		}
		this.orderList = orderList;
	}
}
