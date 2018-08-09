package com.lazyproj.springboot.restful.service.impl;

import com.lazyproj.springboot.restful.dao.IStatisticDao;
import com.lazyproj.springboot.restful.service.IStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticServiceImpl implements IStatisticService {
    @Autowired
    private IStatisticDao statisticDao;
}
