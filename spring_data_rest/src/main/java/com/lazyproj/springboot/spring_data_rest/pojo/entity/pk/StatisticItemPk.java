package com.lazyproj.springboot.spring_data_rest.pojo.entity.pk;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author heliuslee@live.cn
 * @Date 2018/08/13 9:56
 * @Description
 */
public class StatisticItemPk implements Serializable {
	private String userId;
	private Date createTime;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
