package com.lazyproj.springboot.my_restful.controller;


import com.github.pagehelper.PageInfo;
import com.lazyproj.springboot.my_restful.enums.ResultCode;
import com.lazyproj.springboot.my_restful.exception.BizException;
import com.lazyproj.springboot.my_restful.frame.restful.Page;
import com.lazyproj.springboot.my_restful.pojo.domain.Sort;
import com.lazyproj.springboot.my_restful.pojo.entity.Statistic;
import com.lazyproj.springboot.my_restful.service.IStatisticService;
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
	public Statistic postStatistic(@RequestBody Statistic statistic) {
		return statistic;
	}

	// 查询列表
	@GetMapping("/api/v1/statistics")
	public List<Statistic> getStatisticList() {
		String sortStr = req.getParameter("sort");
		Sort sort = new Sort(sortStr);
		return statisticService.getStatisticList(sort);
	}

	// 查询列表
	@GetMapping("/api/v1/statistics")
	public PageInfo<Statistic> getStatisticList(@RequestParam(name = "page") Integer pageNum, @RequestParam(name = "size") Integer pageSize) {
		Page page = new Page(pageNum, pageSize);

		String sortStr = req.getParameter("sort");
		Sort sort = new Sort(sortStr);

		PageInfo<Statistic> statisticPageInfo = statisticService.getStatisticList(page, sort);
		return statisticPageInfo;
	}

	// 查询单个
	@GetMapping("/api/v1/statistics/{statisticId}")
	public Statistic getStatisticById(@PathVariable("statisticId") String statisticId) {
		throw new BizException(ResultCode.UnknownResultCode.INSTANCE);
//		return null;
	}

	@PutMapping("/api/v1/statistics/{statisticId}")
	public Statistic putStatistic(@PathVariable("statisticId") String statisticId, @RequestBody Statistic statistic) {
		throw new BizException("6666", "6666666666666");
//        return null;
	}

	@DeleteMapping("/api/v1/statistics/{statisticId}")
	public List<Statistic> deleteStatistic(@PathVariable("statisticId") String statisticId) {
		return null;
	}
}
