package com.womow.henan.modules.province.service.impl;

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
import com.womow.henan.commons.utils.PoiUtils;
import com.womow.henan.commons.utils.ReflactUtils;
import com.womow.henan.modules.province.bean.dto.BusDataEntityDo;
import com.womow.henan.modules.province.dao.BusDataDao;
import com.womow.henan.modules.province.service.BusDataService;
import com.womow.henan.modules.sys.security.utils.ShiroUtils;

@Service
@Transactional
public class BusDataServiceImpl implements BusDataService {

	private Logger logger = LoggerFactory.getLogger(BusDataService.class);
	@Autowired
	private BusDataDao busDataDao;

	public String dataFileUp(MultipartFile file) {
		String fileName = file.getOriginalFilename();
		String extensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
		String message = "";
		if (!"xls".equals(extensionName) && !"xlsx".equals(extensionName)) {
			message = "请上传excel文档";
			return message;
		}
		InputStream io = null;
		Integer rowIndex = 0;
		Integer cellIndex = 0;
		
		int x = 0;
		int y = 0;
		int z = 0;
		
		// 记录保存成功数据的个数
		int num = 0;
		// 记录文档的最后的row索引
		int lastRowNum = 0;
		Date date = new Date();
		String sheetName = "";
		try {
			io = file.getInputStream();
			// 根据excel版本创建对象
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
			// Sheet sheet = workbook.getSheetAt(0);
			for (int b = 0; b < numberOfSheets; b++) {
				Sheet sheet = workbook.getSheetAt(b);
				sheetName = sheet.getSheetName();
				if (sheetName != null && !"".equals(sheetName.trim()) && sheetName.startsWith("excel")) {
					// row -cell 模块名称 总指标 分指标 数据(省份)
					// row 的 数量
					lastRowNum = sheet.getLastRowNum();
					Row firstRow = sheet.getRow(0);
					Cell yearCell = firstRow.getCell(0);
					Cell partYearCell = firstRow.getCell(1);
					yearCell.setCellType(Cell.CELL_TYPE_STRING);
					partYearCell.setCellType(Cell.CELL_TYPE_STRING);
					String year = yearCell.getStringCellValue();
					boolean matches = year.matches("\\d+");
					String partYear = partYearCell.getStringCellValue();

					if (!matches || "".equals(partYear.trim())) {
						message = "年份或季度数据不正确";
						return message;
					}

					if (lastRowNum <= 1) {
						message = "文档中没有数据";
						return message;
					}

					// index=1时的cell长度
					int lastCellNum = sheet.getRow(1).getLastCellNum();
					// 用于校验文档中的指标名称是否重复
					// List<String> quotaNames = new ArrayList<>();

					// 通过反射创建对象. 创建该方法参数
					Map<String, Object> reflactMap = new HashMap<>();
					// 创建公司容器存储
					List<Cell> provinceCells = new ArrayList<>();
					for (int i = 5; i <= lastRowNum; i++) {
						provinceCells.add(sheet.getRow(i).getCell(1));
					}
					List<String> provinceValues = PoiUtils.getCellAboutProvince(provinceCells);
					reflactMap.put("pojo", "com.womow.henan.modules.province.bean.dto.BusDataEntityDo");
					reflactMap.put("provinces", provinceValues);
					// 校验省份是否为空
					int index = provinceValues.indexOf("");
					if (index != -1) {
						StringBuffer stringBuilder = new StringBuffer();
						stringBuilder.append("sheet ");
						stringBuilder.append(sheetName);
						stringBuilder.append(",第");
						stringBuilder.append((index + 6));
						stringBuilder.append("行,第2列的数据有误");
						message = stringBuilder.toString();
						return message;
					}
					// 集合,存储每家公司对应的每项指标的值
					List<Cell> valueList = new ArrayList<>();
					// 校验分指标是否重复
					// List<String> allNames = new ArrayList<>();
					// 遍历每一列
					cellIndex = 1;
					for (int i = 2; i < lastCellNum; i++) {
						cellIndex++;
						// 模块
						Row row1 = sheet.getRow(1);
						Cell cell1 = row1.getCell(i);
						// 总指标
						String quotaName = PoiUtils.getMergedRegionValue(sheet, 2, i);
						// 总指标/分项指标
						Row row3 = sheet.getRow(3);
						Cell cell3 = row3.getCell(i);
						if (cell3 == null || cell1 == null) {
							TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
							message = "第" + (i + 1) + "列指标名称有误";
							return message;
						}
						cell1.setCellType(Cell.CELL_TYPE_STRING);
						cell3.setCellType(Cell.CELL_TYPE_STRING);
						String row1Value = cell1.getStringCellValue();
						String row3Value = cell3.getStringCellValue();
						/*
						 * if (allNames.contains(row3Value)) { return
						 * ServerResponse.createByErrorMessage("分项模块名称:"+
						 * row3Value+"重复"); } else { allNames.add(row3Value); }
						 */
						if (row1Value.trim().equals("") || "".equals(row3Value.trim())) {
							message = "sheet " + sheetName + " ,第" + (i + 1) + "列指标名称有误";
							return message;
						}

						for (int j = 5; j <= lastRowNum; j++) {
							valueList.add(sheet.getRow(j).getCell(i));
						}
						List<String> dataList = PoiUtils.getCellValue(sheet,valueList);
						reflactMap.put("values", dataList);
						BusDataEntityDo doo = (BusDataEntityDo) ReflactUtils.reflactObject(reflactMap);
						// 设置是否是总指标
						if (row3Value.startsWith("总指标")) {
							row3Value = row3Value.replace("总指标", "");
							row3Value = row3Value.substring(1);
							doo.setIsBigQuota(1);
							x++;
						} else if (row3Value.startsWith("分项子指标")) {
							row3Value = row3Value.replace("分项子指标", "");
							row3Value = row3Value.substring(1);
							doo.setIsBigQuota(0);
							z++;
						}
						doo.setYear(Integer.parseInt(year));
						doo.setPartYear(partYear);
						doo.setModuleName(row1Value);
						doo.setQuotaName(quotaName);
						doo.setChildQuotaName(row3Value);
						doo.setCreateUserId(ShiroUtils.getUserId());
						doo.setCreateDate(date);
						busDataDao.save(doo);
						valueList.clear();
						y++;

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
						slog.append(row1Value);
						slog.append(" ");
						slog.append(quotaName);
						slog.append(" ");
						slog.append(row3Value);
						slog.append("-的数据");
						logger.info(slog.toString());
					}

				}
			}
			message = "文件导入成功";
			return message;
		} catch (Exception e) {
			logger.warn(date + " BusDataServiceImpl.dataFileUp方法 错误信息" + e);
		}
		message = "文件导入失败";
		return message;
	}

}
