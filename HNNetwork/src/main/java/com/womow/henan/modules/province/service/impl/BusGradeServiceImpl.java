package com.womow.henan.modules.province.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;

import com.womow.henan.commons.bean.vo.ServerResponse;
import com.womow.henan.commons.utils.BaseDataUtils;
import com.womow.henan.commons.utils.CheckUtils;
import com.womow.henan.commons.utils.PoiUtils;
import com.womow.henan.commons.utils.ReflactUtils;
import com.womow.henan.modules.province.bean.dto.BusGradeEntityDo;
import com.womow.henan.modules.province.dao.BusGradeDao;
import com.womow.henan.modules.province.service.BusGradeService;
import com.womow.henan.modules.sys.security.utils.ShiroUtils;

/**
 * @author 蔡长盟
 * @description 段位业务层
 * @version 2017年7月31日
 * @eamil modules@163.com
 */
@Service
@Transactional
public class BusGradeServiceImpl implements BusGradeService {

	private Logger logger = LoggerFactory.getLogger(BusGradeService.class);

	@Autowired
	private BusGradeDao busGradeDao;

	public String gradeUpload(MultipartFile file) {
		// 文件名
		String fileName = file.getOriginalFilename();
		String message = "";
		// 文件扩展名
		String extensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
		if (!"xls".equals(extensionName) && !"xlsx".equals(extensionName)) {
			message = "请上传excel文档";
			return message;
		} else {
			InputStream io = null;
			try {
				// 文件读取流
				io = file.getInputStream();
				// poi excel读取对象
				Workbook workbook;
				if ("xls".equals(extensionName)) {
					workbook = new HSSFWorkbook(io);
				} else {
					workbook = new XSSFWorkbook(io);
				}
				int numberOfSheets = workbook.getNumberOfSheets();
				if (numberOfSheets == 0) {
					message = "请上传有内容的excel文档";
					return message;
				}
				Sheet sheet = workbook.getSheetAt(0);
				// 获取模板中第一行中的年与季度
				Row row = sheet.getRow(0);
				if (row.getCell(0) == null || row.getCell(1) == null) {
					message =  "请输入该文档的年份与季度";
					return message;
				}
				int year = (int) row.getCell(0).getNumericCellValue();
				String partYear = row.getCell(1).getStringCellValue();
				if ("".equals(partYear)) {
					message =  "请输入该文档的年份与季度";
					return message;
				}

				// 获取省份的名称数据
				List<Cell> cells = new ArrayList<>();
				// 获取当前sheet页的行数-1
				int lastRowNum = sheet.getLastRowNum();
				if (lastRowNum <= 1) {
					message =  "文档中没有数据";
					return message;
				}
				for (int i = 2; i <= lastRowNum; i++) {
					Row rowI = sheet.getRow(i);
					Cell cell = rowI.getCell(1);
					cells.add(cell);
				}

				// 存储省份与其对应的值,通过反射创建该实体类
				Map<String, Object> reflactMap = new HashMap<>();
				reflactMap.put("pojo", "com.womow.henan.modules.province.bean.dto.BusGradeEntityDo");

				// 存储省份的容器
				List<String> provinceProperty = PoiUtils.getCellAboutProvince(cells);
				reflactMap.put("provinces", provinceProperty);
				// 校验省份是否为空
				int index = provinceProperty.indexOf("");
				if (index != -1) {
					StringBuffer stringBuilder = new StringBuffer();
					stringBuilder.append("第");
					stringBuilder.append((index + 3));
					stringBuilder.append("行,第2列的数据的名称不正确");
					message =  stringBuilder.toString();
					return message;
				}

				Row row1 = sheet.getRow(1);
				// 获取row_1的长度
				int lastCellNum = sheet.getRow(1).getLastCellNum();

				List<Cell> cellss = new ArrayList<>();
				// 时间戳,用于记录操作时间
				Date date = new Date();
				// 创建province容器,.用于判断指标是否重名
				List<String> provinceList = new ArrayList<>();
				// 循环每一列,从索引2开始
				// 遍历cell
				for (int i = 2; i < lastCellNum; i++) {
					// 遍历row
					for (int j = 1; j < lastRowNum + 1; j++) {
						Row rowJ = sheet.getRow(j);
						Cell cell = rowJ.getCell(i);
						if (j != 1) {
							cellss.add(cell);
						} else {
							if (cell != null) {
								cell.setCellType(cell.CELL_TYPE_STRING);
								String cellValue = cell.getStringCellValue();
								if (!"".equals(cellValue.trim())) {
									if (provinceList.contains(cellValue)) {
										TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
										StringBuffer stringBuilder = new StringBuffer();
										stringBuilder.append("指标名称重复-");
										stringBuilder.append(cellValue);
										message =  stringBuilder.toString();
										return message;
									}
								} else {
									TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
									StringBuffer stringBuilder = new StringBuffer();
									stringBuilder.append("第2行,第");
									stringBuilder.append((i + 1));
									stringBuilder.append("行数据有误");
									message =  stringBuilder.toString();
									return message;
								}
							} else {
								TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
								StringBuffer stringBuilder = new StringBuffer();
								stringBuilder.append("第2行,第");
								stringBuilder.append((i + 1));
								stringBuilder.append("行数据有误");
								message =  stringBuilder.toString();
								return message;
							}
						}

					}
					List<String> cellValues = PoiUtils.getCellValue(sheet,cellss);
					reflactMap.put("values", cellValues);
					// 对段位进行数据校验
					String result = CheckUtils.checkGradeValue(cellValues);
					if (result.startsWith("false")) {
						TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
						int errorIndex = Integer.parseInt(result.substring(result.indexOf("=") + 1));
						StringBuffer stringBuilder = new StringBuffer();
						stringBuilder.append("第");
						stringBuilder.append(errorIndex + 3);
						stringBuilder.append("行,第");
						stringBuilder.append(i + 1);
						stringBuilder.append("列数据有问题!");
						message =  stringBuilder.toString();
						return message;
					}
					BusGradeEntityDo doo = (BusGradeEntityDo) ReflactUtils.reflactObject(reflactMap);
					doo.setYear((int) year);
					doo.setPartYear(partYear);
					Cell quotaNameCell = sheet.getRow(1).getCell(i);
					quotaNameCell.setCellType(Cell.CELL_TYPE_STRING);
					String quotaName = quotaNameCell.getStringCellValue();
					doo.setQuotaName(quotaName);
					doo.setCreateDate(date);
					doo.setCreateUserId(ShiroUtils.getUserId());
					busGradeDao.save(doo);
					// 清空集合
					cellss.clear();

					// 日志
					// 用于日志文件记录信息
					StringBuffer slog = new StringBuffer();
					slog.append(BaseDataUtils.dateToString(date));
					slog.append("用户ID-");
					slog.append(ShiroUtils.getUserId());
					slog.append("-上传年度对标段位评价文档,执行了BusDataServiceImpl.dataFileUp方法,添加了-");
					slog.append(year);
					slog.append(" ");
					slog.append(partYear);
					slog.append(" ");
					slog.append(quotaName);
					slog.append("-的数据");
					logger.info(slog.toString());
				}
				message =  "文件导入成功";
				return message;
			} catch (Exception e) {
			} finally {
				if (io != null) {
					try {
						io.close();
					} catch (IOException e) {
						io = null;
					}
				}
			}
			message =  "文件导入失败";
			return message;
		}
	}

}
