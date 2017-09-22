package com.womow.henan.modules.province.service;

import org.springframework.web.multipart.MultipartFile;

import com.womow.henan.commons.bean.vo.ServerResponse;
import com.womow.henan.modules.province.bean.dto.BusGradeEntityDo;

public interface BusGradeService {

	/**
	 * 国网体系段位汇总表文档上传的方法
	 * @param file
	 * @return
	 */
	public String gradeUpload(MultipartFile file);
}
