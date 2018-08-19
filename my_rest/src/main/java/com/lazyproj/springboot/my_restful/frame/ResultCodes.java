package com.lazyproj.springboot.my_restful.frame;

import com.lazyproj.springboot.my_restful.enums.ResultCode;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class ResultCodes {
	private final ApplicationContext context;

	ResultCodes(ApplicationContext context) {
		this.context = context;
	}

	ResultCode of(Exception e) {
		return implementations()
				.filter(impl -> impl.canHandle(e))
				.findFirst()
				.map(impl -> impl.toErrorCode(e))
				.orElse(ResultCode.UnknownResultCode.INSTANCE);
	}

	/**
	 * Query the {@linkplain #context} to find all available implementations of
	 * {@linkplain ExceptionToErrorCode}.
	 */
	private Stream<ExceptionToErrorCode> implementations() {
		return context.getBeansOfType(ExceptionToErrorCode.class).values().stream();
	}
}
