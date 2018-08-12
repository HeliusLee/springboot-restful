package com.lazyproj.springboot.spring_data_rest.pojo.entity;

import com.lazyproj.springboot.spring_data_rest.converter.JpaConverterJson;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Entity
public class Statistic {
	@Id
//	@Column(name = "statisticid")
	private String statisticId;
//	@Column(name = "userid")
	private String userId;
	private String title;
	@Convert(converter = JpaConverterJson.class)
	private List<String> fields;
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
