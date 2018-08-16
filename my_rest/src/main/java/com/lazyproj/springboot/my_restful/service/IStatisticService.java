package com.lazyproj.springboot.my_restful.service;

import com.github.pagehelper.PageInfo;
import com.lazyproj.springboot.my_restful.frame.restful.Page;
import com.lazyproj.springboot.my_restful.pojo.domain.Sort;
import com.lazyproj.springboot.my_restful.pojo.entity.Statistic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IStatisticService {
	List<Statistic> getStatisticList(Sort sort);
	PageInfo<Statistic> getStatisticList(Page page, Sort sort);
}
