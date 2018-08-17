package com.lazyproj.springboot.my_restful.enums;

import com.alibaba.druid.wall.violation.ErrorCode;
import org.springframework.http.HttpStatus;

/**
 * @Author heliuslee@live.cn
 * @Date 2018/08/16 17:00
 * @Description
 */
public interface ResultCode {
	int ERROR_CODE_FOR_UNKNOWN_ERROR = 0;
	String ERROR_MESSEGE_FOR_UNKNOWN_ERROR = "no more detail";

	int code();
	String msg();
	HttpStatus httpStatus();

	enum UnknownResultCode implements ResultCode {
		INSTANCE;

		@Override
		public int code() {
			return ERROR_CODE_FOR_UNKNOWN_ERROR;
		}

		@Override
		public String msg() {
			return ERROR_MESSEGE_FOR_UNKNOWN_ERROR;
		}

		@Override
		public HttpStatus httpStatus() {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
	}
}
