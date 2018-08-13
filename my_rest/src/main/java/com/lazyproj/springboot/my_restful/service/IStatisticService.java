package com.lazyproj.springboot.my_restful.service;

import com.lazyproj.springboot.my_restful.pojo.domain.Sort;
import com.lazyproj.springboot.my_restful.pojo.entity.Statistic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IStatisticService {
	List<Statistic> getStatisticList(@Param("sort") Sort sort);
}
