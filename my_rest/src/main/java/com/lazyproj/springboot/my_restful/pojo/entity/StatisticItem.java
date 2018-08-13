package com.lazyproj.springboot.my_restful.pojo.entity;

import java.util.Date;

public class StatisticItem {
    private String statisticId;
    private String userId;
    private String data;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
