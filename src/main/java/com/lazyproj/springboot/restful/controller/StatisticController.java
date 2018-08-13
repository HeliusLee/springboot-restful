package com.lazyproj.springboot.restful.controller;

import com.lazyproj.springboot.restful.context.RestfulContext;
import com.lazyproj.springboot.restful.pojo.domain.Sort;
import com.lazyproj.springboot.restful.pojo.entity.Statistic;
import com.lazyproj.springboot.restful.service.IStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
//@RequestMapping("/api/v1/statistics")
public class StatisticController {
    @Autowired
    private IStatisticService statisticService;
    @Autowired
	private HttpServletRequest req;

    @PostMapping("/api/v1/statistics")
    public Statistic postStatistic(@RequestBody Statistic statistic){
		return statistic;
    }

    // 查询列表
    @GetMapping("/api/v1/statistics")
    public List<Statistic> getStatisticList(){
        return null;
    }

    // 查询单个
    @GetMapping("/api/v1/statistics/{statisticId}")
    public Statistic getStatisticById(@PathVariable("statisticId") String statisticId){
		String sortStr = req.getQueryString();
		Sort sort = new Sort(sortStr);
		System.out.println(sortStr);
		boolean read = Boolean.parseBoolean(req.getParameter("read"));
		System.out.println(read);
		Statistic statistic = new Statistic();
		statistic.setStatisticId(statisticId);
		return statistic;
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
