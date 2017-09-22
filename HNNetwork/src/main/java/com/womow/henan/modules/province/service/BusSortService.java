package com.womow.henan.modules.province.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * 河南省年度排名service
 * @DescriptionTODO
 * @author CAI modules@163.com
 * @data 2017年9月5日下午4:33:28
 * @version V1.0
 */
public interface BusSortService {

	/**
	 * 河南省年度排名文档上传的方法
	 * @return
	 */
	String sortFileUp(MultipartFile file);

}
