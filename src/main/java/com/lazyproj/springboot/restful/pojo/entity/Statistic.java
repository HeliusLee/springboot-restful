package com.lazyproj.springboot.restful.pojo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Statistic {
	@Id
//	@Column(name = "statisticid")
	private String statisticId;
//	@Column(name = "userid")
	private String userId;
	private String title;
	private String fields;
//	@Column(name = "createtime")
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

	public String getFields() {
		return fields;
	}

	public void setFields(String fields) {
		this.fields = fields;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
