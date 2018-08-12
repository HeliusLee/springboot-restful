package com.lazyproj.springboot.spring_data_rest.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import java.io.IOException;

public class JpaConverterJson implements AttributeConverter<Object, String> {

	private final static ObjectMapper objectmapper = new ObjectMapper();
	@Override
	public String convertToDatabaseColumn(Object o) {
		try {
			return objectmapper.writeValueAsString(o);
		} catch (JsonProcessingException e) {
			return null;
		}
	}

	@Override
	public Object convertToEntityAttribute(String s) {
		try {
			return objectmapper.readValue(s, Object.class);
		} catch (IOException e) {
			return null;
		}
	}
}
