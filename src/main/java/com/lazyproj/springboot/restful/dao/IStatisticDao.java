package com.lazyproj.springboot.restful.dao;

import com.lazyproj.springboot.restful.pojo.entity.Statistic;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IStatisticDao extends PagingAndSortingRepository<Statistic, String> {

}
