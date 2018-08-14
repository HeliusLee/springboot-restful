package com.lazyproj.springboot.spring_data_rest.dao;


import com.lazyproj.springboot.spring_data_rest.pojo.entity.StatisticItem;
import com.lazyproj.springboot.spring_data_rest.pojo.entity.pk.StatisticItemPk;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @Author heliuslee@live.cn
 * @Date 2018/08/13 10:02
 * @Description
 */
public interface IStatisticItemDao extends PagingAndSortingRepository<StatisticItem, StatisticItemPk> {

}
