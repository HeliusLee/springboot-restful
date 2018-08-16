package com.lazyproj.springboot.my_restful.exception;

import com.lazyproj.springboot.my_restful.enums.BizResultCode;
import com.lazyproj.springboot.my_restful.enums.ResultCode;
import org.springframework.http.HttpStatus;

/**
 * 业务异常
 * 继承运行时异常
 * @Author heliuslee@live.cn
 * @Date 2018/08/16 16:46
 * @Description
 */
public class BizException extends RuntimeException{
	private String bizCode;// 业务状态码
	private HttpStatus httpStatus;// HTTP 状态码

	public BizException(ResultCode resultCode){
		super(resultCode.msg());
		this.bizCode = resultCode.code();
		this.httpStatus = resultCode.httpStatus();
	}

	public BizException(String code, String message) {
		super(message);
		this.bizCode = code;
		this.httpStatus = HttpStatus.BAD_REQUEST;
	}

	public String getBizCode() {
		return bizCode;
	}

	public void setBizCode(String bizCode) {
		this.bizCode = bizCode;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
}
