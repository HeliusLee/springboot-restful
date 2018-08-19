package com.lazyproj.springboot.my_restful.handler;

import com.lazyproj.springboot.my_restful.exception.BizException;
import com.lazyproj.springboot.my_restful.frame.restful.RestfulResult;
import com.lazyproj.springboot.my_restful.utils.RequestContextHolderUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * 全局异常处理
 *
 * @Author heliuslee@live.cn
 * @Date 2018/08/16 16:47
 * @Description
 */
@RestController
@ControllerAdvice
public class GlobalExceptionHandler extends BaseExceptionHandler {
	private static final String DEFAULT_MESSAGE = "No message available";// 没有错误信息时默认返回
	/**
	 * 处理业务异常
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value = BizException.class)
	public ResponseEntity<RestfulResult> bizExceptionHandler(BizException e) {
		e.printStackTrace();
		RestfulResult restfulResult = new RestfulResult();
		restfulResult.setStatus(e.getBizCode());
		restfulResult.setMsg(e.getMessage());
		return ResponseEntity.status(e.getHttpStatus()).body(restfulResult);
	}

	/**
	 * 默认异常处理
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value = Exception.class)
	public Object defaultExceptionHandler(Exception e) {
		e.printStackTrace();
		RestfulResult restfulResult = new RestfulResult();
		restfulResult.setMsg(e.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(restfulResult);
	}
}
