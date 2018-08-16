package com.lazyproj.springboot.my_restful.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lazyproj.springboot.my_restful.dao.IStatisticDao;
import com.lazyproj.springboot.my_restful.frame.restful.Page;
import com.lazyproj.springboot.my_restful.pojo.domain.Sort;
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

    @Override
	public PageInfo<Statistic> getStatisticList(Page page, Sort sort) {
		PageHelper.startPage(page.getPage(), page.getSize());
		List<Statistic> statistics = statisticDao.selectAllWithSorted(sort);
		PageInfo<Statistic> statisticPageInfo = new PageInfo<>(statistics);
		return statisticPageInfo;
	}


}
