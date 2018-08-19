package com.lazyproj.springboot.my_restful.enums;

import org.springframework.http.HttpStatus;

/**
 * @Author heliuslee@live.cn
 * @Date 2018/08/16 19:18
 * @Description
 */
public enum BizResultCode implements ResultCode {
	OK(1,"OK"),
	SIGN_WRONG(1000, "签名错误"),;

	private final int code;
	private final String msg;
	private final HttpStatus httpStatus;

	BizResultCode(int code, String msg) {
		this.code = code;
		this.msg = msg;
		this.httpStatus = HttpStatus.BAD_REQUEST;
	}

	BizResultCode(int code, String msg, HttpStatus httpStatus) {
		this.code = code;
		this.msg = msg;
		this.httpStatus = httpStatus;
	}

	@Override
	public int code() {
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
