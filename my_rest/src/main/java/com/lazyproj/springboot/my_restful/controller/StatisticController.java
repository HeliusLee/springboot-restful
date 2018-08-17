package com.lazyproj.springboot.my_restful.controller;


import com.github.pagehelper.PageInfo;
import com.lazyproj.springboot.my_restful.enums.ResultCode;
import com.lazyproj.springboot.my_restful.exception.BizException;
import com.lazyproj.springboot.my_restful.frame.Result;
import com.lazyproj.springboot.my_restful.frame.restful.Page;
import com.lazyproj.springboot.my_restful.pojo.domain.Sort;
import com.lazyproj.springboot.my_restful.pojo.entity.Statistic;
import com.lazyproj.springboot.my_restful.service.IStatisticService;
import com.lazyproj.springboot.my_restful.utils.RestfulResultUtils;
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
	public PageInfo<Statistic> getStatisticList(@RequestParam(name = "page", required = false) Integer pageNum,
								   @RequestParam(name = "size", required = false) Integer pageSize) {
		String sortStr = req.getParameter("sort");
		Sort sort = new Sort(sortStr);

		Page page;
		if (pageNum == null && pageSize == null) {
			page = new Page(0,0);
		}else if(pageNum != null && pageSize != null){
			page = new Page(pageNum, pageSize);
		}else {
			throw new BizException(ResultCode.UnknownResultCode.INSTANCE);
		}

		PageInfo<Statistic> statisticPageInfo = statisticService.getStatisticList(page, sort);
		System.out.println(statisticPageInfo.getPageNum());
//		return RestfulResultUtils.success(statisticPageInfo);
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
		throw new BizException(666, "6666666666666");
//        return null;
	}

	@DeleteMapping("/api/v1/statistics/{statisticId}")
	public List<Statistic> deleteStatistic(@PathVariable("statisticId") String statisticId) {
		return null;
	}
}
