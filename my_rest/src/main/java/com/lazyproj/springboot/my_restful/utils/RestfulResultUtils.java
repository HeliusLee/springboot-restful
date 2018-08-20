package com.lazyproj.springboot.my_restful.utils;

import com.lazyproj.springboot.my_restful.enums.ResultCode;
import com.lazyproj.springboot.my_restful.frame.response.Result;
import com.lazyproj.springboot.my_restful.frame.restful.RestfulResult;

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
		result.setCode(code);
		result.setMsg(msg);
		return result;
	}

	public static Result success(ResultCode code, Object obj) {
		return success(code.code(), code.msg(), obj);
	}

}
