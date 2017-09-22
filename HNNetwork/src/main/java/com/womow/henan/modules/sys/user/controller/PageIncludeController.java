package com.womow.henan.modules.sys.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.womow.henan.commons.web.BaseController;

/**
 * @Description 页面include标签处理controller
 * @author CAI modules@163.com
 * @data 2017年8月8日下午5:33:55
 * @version V1.0
 */
@Controller
@RequestMapping("incl")
public class PageIncludeController extends BaseController{

	/**
	 * 跳转至某个页面
	 * @param path
	 * @param page
	 * @return
	 */
	@RequestMapping("/{path}/{page}")
	public String toLeft(@PathVariable("path") String path, @PathVariable("page") String page,ModelMap modelMap,Model model) {
		model.addAttribute(modelMap);
		return path+"/"+page;
	}
}
