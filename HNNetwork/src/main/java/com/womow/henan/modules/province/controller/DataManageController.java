package com.womow.henan.modules.province.controller;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.womow.henan.commons.bean.BaseDataEntity;
import com.womow.henan.commons.bean.PageUtils;
import com.womow.henan.commons.bean.Query;
import com.womow.henan.commons.service.BusBaseDataService;
import com.womow.henan.commons.utils.BaseDataUtils;
import com.womow.henan.commons.web.BaseController;
import com.womow.henan.modules.province.bean.dto.BusDataManageEntityDo;
import com.womow.henan.modules.province.service.BusDataManageService;

/**
 * @Description 数据管理controller
 * @author CAI modules@163.com
 * @data 2017年8月11日下午5:56:13
 * @version V1.0
 */
@Controller
@RequestMapping("/dtMa")
public class DataManageController extends BaseController {

	@Autowired
	private BusDataManageService busDataManageService;
	@Autowired
	private BusBaseDataService busBaseDataService;

	/**
	 * 查询所有的模块下的指标数据(dataView视图)
	 */
	@RequestMapping
	public String dataManage(@RequestParam Map<String, Object> map, Model model, ModelMap modelMap) throws Exception {

		// 封装查询条件,返回页面用于分页查询
		String condition = "&";
		if (map != null) {
			for (String key : map.keySet()) {
				Object value = map.get(key);
				condition += key + "=" + value + "&";
			}
		}
		if (condition.endsWith("&")) {
			condition = condition.substring(0, condition.lastIndexOf("&"));
		}
		model.addAttribute("condition", condition);

		Query query = new Query(map);
		// 查询条件 <!-- 字段名称 start --> nian
		String year = (String) map.get("year");
		// 季度
		String partYear = (String) map.get("partYear");
		// 从数据库中获取到年与季度,获取最新的年和季度
		try {
			if (year == null && partYear == null) {
				// 获取当年年月以及季度
				String newYear = busDataManageService.findNewYear();
				query.put("year", newYear.substring(0, newYear.indexOf("=")));
				query.put("partYear", newYear.substring(newYear.indexOf("=") + 1));
			}
		} catch (Exception e) {
			logger.warn("DataManageController.dataManage" + e);
		}

		// 分页查询视图中的所有quotaName的名称
		//// 根据用户输入条件筛选出的总指标名称
		List<String> quotaNames = busDataManageService.findAllQuotaName(query);
		// 查询数据总量
		int count = busDataManageService.findCont(query);
		// 通过quotaName查询出需要的数据
		List<List<BusDataManageEntityDo>> list = busDataManageService.queryAllData(quotaNames, query);

		PageUtils pageUtils = new PageUtils(list, count, query.getLimit(), query.getPage());
		model.addAttribute("page", pageUtils);

		// 添加空格,用于页面展示数据时与下拉框数据对齐.
		if (year != null && !"".equals(year)) {
			map.put("year", year);
		}
		if (partYear != null && !"".equals(partYear)) {
			map.put("partYear", partYear);
		}

		model.addAttribute("query", map);

		// 消息提示
		model.addAttribute(modelMap);
		// 部门
		List<BaseDataEntity> depts = busBaseDataService.findByType("dept");
		model.addAttribute("depts", depts);
		// 模块
		List<BaseDataEntity> modules = busBaseDataService.findByType("module");
		model.addAttribute("modules", modules);
		// 属性
		List<BaseDataEntity> attributes = busBaseDataService.findByType("attribute");
		model.addAttribute("attributes", attributes);
		// 发布周期
		List<BaseDataEntity> publishCycles = busBaseDataService.findByType("publishCycle");
		model.addAttribute("publishCycles", publishCycles);
		// 评价方式
		List<BaseDataEntity> appraiseMethods = busBaseDataService.findByType("appraiseMethod");
		model.addAttribute("appraiseMethods", appraiseMethods);
		// 年份
		List<Integer> years = busDataManageService.findYears();
		if (years != null && years.size() > 5) {
			years = years.subList(0, 5);
			model.addAttribute("yeras", years);
		}
		return "guoWang/Fangan_mb";
	}

	/**
	 * 河南省数据管理预警的查询
	 */
	@RequestMapping("/earlyWarning")
	public String earlyWarning(@RequestParam Map<String, Object> map, Model model) throws Exception {

		// 封装查询条件,返回页面用于分页查询
		String condition = "&";
		if (map != null) {
			for (String key : map.keySet()) {
				Object value = map.get(key);
				condition += key + "=" + value + "&";
			}
		}
		if (condition.endsWith("&")) {
			condition = condition.substring(0, condition.lastIndexOf("&"));
		}
		model.addAttribute("condition", condition);

		Query query = new Query(map);
		// 查询条件 <!-- 字段名称 start --> nian
		Object year = map.get("year");
		// 季度
		Object partYear = map.get("partYear");
		// 从数据库中获取到年与季度,获取最新的年和季度
		String newYear = busDataManageService.findNewYear();
		try {
			if (year == null && partYear == null) {
				// 获取当年年月以及季度
				newYear = busDataManageService.findNewYear();
				query.put("year", newYear.substring(0, newYear.indexOf("=")));
				query.put("partYear", newYear.substring(newYear.indexOf("=") + 1));
			}
		} catch (Exception e) {
			logger.warn("数据库中没有数据 DataManageController.dataManage" + e);
		}

		List<String> modules = busDataManageService.findAllModules(query);
		List<String> removeEmp = BaseDataUtils.removeEmp(modules);
		List<List<BusDataManageEntityDo>> list = busDataManageService.earlyWarning(query, removeEmp);
		// 截取集合中的数据,进行分页显示
		int pageNum = query.getPage();
		int pageLimit = query.getLimit();
		int fromIndex = (pageNum - 1) * pageLimit; // 闭区间
		int toIndex = fromIndex + pageLimit; // 开区间
		List<List<BusDataManageEntityDo>> subList = null;
		if (list != null && list.size() > 0) {
			if (fromIndex < list.size() && toIndex <= list.size()) {
				subList = list.subList(fromIndex, toIndex);
			} else if (fromIndex < list.size() && toIndex > list.size()) {
				subList = list.subList(fromIndex, list.size());
			}
		}
		PageUtils pageUtils = new PageUtils(subList, list.size(), query.getLimit(), query.getPage());
		model.addAttribute("page", pageUtils);
		// 页面回显查询条件
		model.addAttribute("query", map);
		// 年份
		List<Integer> years = busDataManageService.findYears();
		if (years != null && years.size() > 5) {
			years = years.subList(0, 5);
			model.addAttribute("yeras", years);
		}
		return "guoWang/Fangan_gl";
	}
}
