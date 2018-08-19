package com.lazyproj.springboot.my_restful.frame;

import com.lazyproj.springboot.my_restful.enums.ResultCode;

public interface ExceptionToErrorCode {
	boolean canHandle(Exception exception);
	ResultCode toErrorCode(Exception exception);
}
