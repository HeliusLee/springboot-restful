package com.lazyproj.springboot.my_restful.enums;

import org.springframework.http.HttpStatus;

/**
 * @Author heliuslee@live.cn
 * @Date 2018/08/16 19:18
 * @Description
 */
public enum BizResultCode implements ResultCode {
	SIGN_WRONG("1000", "签名错误"),;
	private final String code;
	private final String msg;
	private final HttpStatus httpStatus;

	BizResultCode(String code, String msg) {
		this.code = code;
		this.msg = msg;
		this.httpStatus = HttpStatus.BAD_REQUEST;
	}

	BizResultCode(String code, String msg, HttpStatus httpStatus) {
		this.code = code;
		this.msg = msg;
		this.httpStatus = httpStatus;
	}

	@Override
	public String code() {
		return code;
	}

	@Override
	public String msg() {
		return msg;
	}

	@Override
	public HttpStatus httpStatus() {
		return httpStatus;
	}
}
