package com.lazyproj.springboot.my_restful.dao;

import com.lazyproj.springboot.my_restful.frame.restful.Sort;
import com.lazyproj.springboot.my_restful.pojo.entity.Statistic;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface IStatisticDao extends Mapper<Statistic> {
	List<Statistic> selectAllWithSorted(@Param("sort") Sort sort);
}
