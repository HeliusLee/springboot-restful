package com.lazyproj.springboot.my_restful.utils;

import com.lazyproj.springboot.my_restful.enums.ResultCode;
import com.lazyproj.springboot.my_restful.frame.Result;
import com.lazyproj.springboot.my_restful.frame.restful.RestfulResult;
import org.springframework.http.HttpStatus;

/**
 * @Author heliuslee@live.cn
 * @Date 2018/08/17 14:34
 * @Description
 */
public class RestfulResultUtils implements ResultUtils {

	public static Result success(Object obj) {
		RestfulResult result = new RestfulResult();
		result.setData(obj);
		return result;
	}

	public static Result success() {
		return success((Object) null);
	}

	public static Result success(int code, String msg, Object obj) {
		RestfulResult result = (RestfulResult) success((Object) null);
		result.setStatus(code);
		result.setMsg(msg);
		return result;
	}

	public static Result success(ResultCode code, Object obj) {
		return success(code.code(), code.msg(), obj);
	}

}
