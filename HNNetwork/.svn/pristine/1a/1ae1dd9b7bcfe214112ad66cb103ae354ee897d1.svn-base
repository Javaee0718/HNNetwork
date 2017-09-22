package com.womow.henan.modules.province.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.womow.henan.commons.bean.vo.ServerResponse;
import com.womow.henan.commons.utils.BaseDataUtils;
import com.womow.henan.commons.web.BaseController;
import com.womow.henan.modules.province.bean.dto.BusDataEntityDo;
import com.womow.henan.modules.province.bean.dto.BusGradeEntityDo;
import com.womow.henan.modules.province.bean.dto.BusValueEntityDo;
import com.womow.henan.modules.province.service.BusDataService;
import com.womow.henan.modules.province.service.BusGradeService;
import com.womow.henan.modules.province.service.BusSortService;
import com.womow.henan.modules.province.service.BusValueService;

/**
 * @author 蔡长盟
 * @description excel文件上传controller
 * @version 2017年7月31日
 * @eamil modules@163.com
 */
@Controller
@RequestMapping("excel")
public class ExcelUploadController extends BaseController {

	@Autowired
	private BusGradeService busGradeService;
	@Autowired
	private BusDataService busDataService;
	@Autowired
	private BusValueService busValueService;
	@Autowired
	private BusSortService busSortService;
	
	/**
	 * 国网体系对标指标数据汇总表
	 */
	@RequestMapping("/dataFileUp")
	@ResponseBody
	public Map<String, String> busDataUpload(@RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes) {
		if (file == null || file.getOriginalFilename() == null || "".equals(file.getOriginalFilename().trim())) {
			addMessage(redirectAttributes, "请上传文档");
		}
		String fileName = file.getOriginalFilename();
		String message = "";
		if (fileName.startsWith(BaseDataUtils.getValue("gradeEcl"))) {
			message = busGradeService.gradeUpload(file);
		} else if (fileName.startsWith(BaseDataUtils.getValue("dataEcl"))) {
			message = busDataService.dataFileUp(file);
		} else if (fileName.startsWith(BaseDataUtils.getValue("attributeEcl"))) {
			message = busValueService.valueFileUp(file);
		} else if (fileName.startsWith(BaseDataUtils.getValue("sortEcl"))) {
			message = busSortService.sortFileUp(file);
		} else {
			message = "文件名称不符合规则";
		}
		message = "文档 : "+fileName + " " + message;
		addMessage(redirectAttributes, message);
		// return "redirect:/dtMa";
		Map<String, String> map = new HashMap<>();
		map.put("msg", message);
		return map;
	}

}
