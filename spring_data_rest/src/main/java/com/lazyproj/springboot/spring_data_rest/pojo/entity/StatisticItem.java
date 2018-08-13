package com.lazyproj.springboot.spring_data_rest.pojo.entity;

import com.lazyproj.springboot.spring_data_rest.converter.JpaConverterJson;
import com.lazyproj.springboot.spring_data_rest.pojo.entity.pk.StatisticItemPk;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "statistic_item")
@IdClass(StatisticItemPk.class)
public class StatisticItem {
    @ManyToOne
    @JoinColumn(name = "statisticId")
    private Statistic statistic;
    @Id
    private String userId;
    @Convert(converter = JpaConverterJson.class)
    private List<String> data;
    @Id
    private Date createTime;

    public Statistic getStatistic() {
        return statistic;
    }

    public void setStatistic(Statistic statistic) {
        this.statistic = statistic;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
