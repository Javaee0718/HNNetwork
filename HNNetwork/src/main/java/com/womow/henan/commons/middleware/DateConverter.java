package com.womow.henan.commons.middleware;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Controller;

@Controller
public class DateConverter implements Converter<String, Date>{

	private static final Logger logger = LoggerFactory.getLogger(DateConverter.class);
	/**
	 * 参数类型转换器
	 */
	public Date convert(String date) {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dt;
		try {
			dt = dateFormat.parse(date);
		} catch (ParseException e) {
			logger.warn(e.getMessage());
			dt = null;
		}
		return dt;
	}
}
