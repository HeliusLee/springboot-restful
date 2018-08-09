package com.lazyproj.springboot.restful.controller;

import com.lazyproj.springboot.restful.pojo.po.Statistic;
import com.lazyproj.springboot.restful.service.IStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/api/v1/statistics")
public class StatisticController {
    @Autowired
    private IStatisticService statisticService;

    @PostMapping("/api/v1/statistics")
    public List<Statistic> postStatistic(@RequestBody Statistic statistic){
        return null;
    }

    // 查询列表
    @GetMapping("/api/v1/statistics")
    public Statistic getStatisticList(){
        return null;
    }

    // 查询单个
    @GetMapping("/api/v1/statistics/{statisticId}")
    public Statistic getStatisticById(@PathVariable("statisticId") String statisticId){
        return null;
    }

    @PutMapping("/api/v1/statistics/{statisticId}")
    public Statistic putStatistic(@PathVariable("statisticId") String statisticId, @RequestBody Statistic statistic){
        return null;
    }

    @DeleteMapping("/api/v1/statistics/{statisticId}")
    public List<Statistic> deleteStatistic(@PathVariable("statisticId") String statisticId){
        return null;
    }
}
