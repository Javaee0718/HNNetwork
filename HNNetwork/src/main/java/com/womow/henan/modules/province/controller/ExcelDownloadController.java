package com.womow.henan.modules.province.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.womow.henan.commons.web.BaseController;
import com.womow.henan.modules.sys.security.utils.ShiroUtils;
import com.womow.henan.modules.sys.user.dao.BusUserDao;

/**
 * @author 蔡长盟
 * @description excel文档导出controller
 * @version 2017年8月7日
 * @eamil modules@163.com
 */
@Controller
@RequestMapping("model")
public class ExcelDownloadController extends BaseController {

	@Autowired
	private BusUserDao busUserDao;

	/**
	 * excel模板下载的方法
	 */
	@RequestMapping("/down")
	public void fileDownLoad(HttpServletRequest request, HttpServletResponse response) {
		// 获得模板的本地磁盘路径
		String modelLocation = request.getServletContext().getRealPath("/") + excelOppositeLocation;
		String fileName = FilenameUtils.getName(modelLocation);
		String showName = "";
		InputStream io = null;
		File file = new File(modelLocation);
		try {
			if (file.exists()) {
				if (request.getHeader("User-Agent").toUpperCase().indexOf("MSIE") > 0) {
					try {
						showName = URLEncoder.encode(fileName, "UTF-8");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				} else {
					try {
						showName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}
				response.addHeader("Content-Disposition", "attachment;filename=" + showName);
				response.setContentType(request.getServletContext().getMimeType(fileName));
				io = new BufferedInputStream(new FileInputStream(modelLocation));
				response.setContentLength(io.available());
				byte[] buffer = new byte[1204];
				int length;
				while ((length = io.read(buffer)) != -1) {
					response.getOutputStream().write(buffer, 0, length);
				}
			}
		} catch (Exception e) {
			logger.warn(e.getMessage());
		} finally {
			if (io != null) {
				try {
					io.close();
				} catch (IOException e) {
					io = null;
				}
			}
		}
	}

	/**
	 * 精益化指标模板下载
	 */
	@RequestMapping("preciFD")
	public void precisionModelDownLoad(HttpServletRequest request, HttpServletResponse response) {
		String[] fileLocations;
		Subject subject = ShiroUtils.getSubject();
		if (subject.hasRole("admin")) {
			// 是管理员
			fileLocations = new String[] { excelAllPrecisionLocation };
		} else {
			List<String> allPerms = busUserDao.findAllPerms(ShiroUtils.getUserId());
			fileLocations = (String[]) allPerms.toArray();
		}
		if (fileLocations != null) {
			// 项目本地磁盘地址
			String prevLo = request.getServletContext().getRealPath("/");
			for (String dept : fileLocations) {
				String realPath = "";
				if (dept.equals("role")) {
					realPath = prevLo + "/excelModel/role" + excelPrePreciName + ".zip";
				} else {
					realPath = prevLo + "/excelModel/" + dept + excelPrePreciName + ".xlsx";
				}
				// 获得模板的本地磁盘路径
				String fileName = FilenameUtils.getName(realPath);
				String showName = "";
				InputStream io = null;
				File file = new File(realPath);
				try {
					if (file.exists()) {
						if (request.getHeader("User-Agent").toUpperCase().indexOf("MSIE") > 0) {
							try {
								showName = URLEncoder.encode(fileName, "UTF-8");
							} catch (UnsupportedEncodingException e) {
								e.printStackTrace();
							}
						} else {
							try {
								showName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");
							} catch (UnsupportedEncodingException e) {
								e.printStackTrace();
							}
						}
						response.addHeader("Content-Disposition", "attachment;filename=" + showName);
						response.setContentType(request.getServletContext().getMimeType(fileName));
						io = new BufferedInputStream(new FileInputStream(realPath));
						response.setContentLength(io.available());
						byte[] buffer = new byte[1204];
						int length;
						while ((length = io.read(buffer)) != -1) {
							response.getOutputStream().write(buffer, 0, length);
						}
					}
				} catch (Exception e) {
					logger.warn(e.getMessage());
				} finally {
					if (io != null) {
						try {
							io.close();
						} catch (IOException e) {
							io = null;
						}
					}
				}
			}
		}

	}
}
