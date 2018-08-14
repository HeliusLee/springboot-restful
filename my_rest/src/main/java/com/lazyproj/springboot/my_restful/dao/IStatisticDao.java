package com.lazyproj.springboot.my_restful.dao;

import com.lazyproj.springboot.my_restful.pojo.domain.Sort;
import com.lazyproj.springboot.my_restful.pojo.entity.Statistic;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

public interface IStatisticDao extends BaseMapper<Statistic> {
	List<Statistic> selectAllWithSorted(Sort sort);
}
