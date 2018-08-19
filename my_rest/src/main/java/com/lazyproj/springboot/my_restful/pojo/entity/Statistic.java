package com.lazyproj.springboot.my_restful.pojo.entity;

import java.util.Date;
import java.util.List;

public class Statistic {
	private String statisticId;
	private String userId;
	private String title;
	private List<String> fields;
	private Date createTime;

	public String getStatisticId() {
		return statisticId;
	}

	public void setStatisticId(String statisticId) {
		this.statisticId = statisticId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getFields() {
		return fields;
	}

	public void setFields(List<String> fields) {
		this.fields = fields;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
