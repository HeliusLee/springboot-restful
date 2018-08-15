package com.lazyproj.springboot.my_restful.service.impl;

import com.lazyproj.springboot.my_restful.dao.IStatisticDao;
import com.lazyproj.springboot.my_restful.pojo.entity.Statistic;
import com.lazyproj.springboot.my_restful.service.IStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticServiceImpl implements IStatisticService {
    @Autowired
    private IStatisticDao statisticDao;

	@Override
	public List<Statistic> getStatisticList(Sort sort) {
		return statisticDao.selectAllWithSorted(sort);
	}
}
