package com.lazyproj.springboot.my_restful.dao;

import com.lazyproj.springboot.my_restful.pojo.domain.Sort;
import com.lazyproj.springboot.my_restful.pojo.entity.Statistic;

import java.util.List;

public interface IStatisticDao{
	List<Statistic> selectStatisticList(Sort sort);
}
