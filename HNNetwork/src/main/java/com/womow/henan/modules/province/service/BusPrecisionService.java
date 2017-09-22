package com.womow.henan.modules.province.service;

import org.springframework.web.multipart.MultipartFile;

import com.womow.henan.modules.sys.user.bean.dto.BusUserEntityDo;

/**
 * @Description 导入精益化指标文档service
 * @author CAI modules@163.com
 * @data 2017年9月17日下午9:17:36
 * @version V1.0
 */
public interface BusPrecisionService {
	
	/**
	 * 精益化指标导入
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public String precisionFileUpload(MultipartFile file) throws Exception;

	/**
	 * 删除精益化指标
	 * @param year
	 * @param month
	 * @param depts
	 */
	public void delteDat(int year, int month, String[] depts) throws Exception ;
}
