package com.lazyproj.springboot.spring_data_rest.dao;

import com.lazyproj.springboot.spring_data_rest.pojo.entity.Statistic;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IStatisticDao extends PagingAndSortingRepository<Statistic, String> {
}
