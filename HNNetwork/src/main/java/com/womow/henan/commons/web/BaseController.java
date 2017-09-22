package com.womow.henan.commons.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author 蔡长盟
 * @description controller基类
 * @version 2017年7月28日
 * @eamil modules@163.com
 */
public abstract class BaseController {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	// excel模板相对路径
	@Value("${excel_opposite_location}")
	protected String excelOppositeLocation;
	// excel精益化指标所有模板
	@Value("${excel_allPrecision_location}")
	protected String excelAllPrecisionLocation;
	// excel精益化指标后缀名
	@Value("${excel_pre_preci_name}")
	protected String excelPrePreciName;
	

	@Value("${page}")
	protected int page;

	@Value("${limit}")
	protected int limit;

	/**
	 * 添加Flash消息
	 * @param message
	 */
	protected void addMessage(RedirectAttributes redirectAttributes, String messages) {
		redirectAttributes.addFlashAttribute("message", messages);
	}
}
