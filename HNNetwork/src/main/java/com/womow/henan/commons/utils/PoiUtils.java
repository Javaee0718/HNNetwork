package com.womow.henan.commons.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

import com.mysql.fabric.xmlrpc.base.Value;

/**
 * @author 蔡长盟
 * @description POI工具类
 * @version 2017年7月31日
 * @eamil modules@163.com
 */
public class PoiUtils {

	private static NumberFormat numberFormat = NumberFormat.getInstance();
	static {
		numberFormat.setGroupingUsed(false);
	}

	/**
	 * 读取excel数据
	 * 
	 * @param path
	 */
	private void readExcelToObj(String path) {

		Workbook wb = null;
		try {
			InputStream io = new FileInputStream(path);
			wb = new HSSFWorkbook(io);
			readExcel(wb, 0, 0, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 读取excel文件
	 * 
	 * @param wb
	 * @param sheetIndex
	 *            sheet页下标：从0开始
	 * @param startReadLine
	 *            开始读取的行:从0开始
	 * @param tailLine
	 *            去除最后读取的行
	 */
	private void readExcel(Workbook wb, int sheetIndex, int startReadLine, int tailLine) {
		Sheet sheet = wb.getSheetAt(sheetIndex);
		Row row = null;

		for (int i = startReadLine; i < sheet.getLastRowNum() - tailLine + 1; i++) {
			row = sheet.getRow(i);
			for (Cell c : row) {
				boolean isMerge = isMergedRegion(sheet, i, c.getColumnIndex());
				// 判断是否具有合并单元格
				if (isMerge) {
					String rs = getMergedRegionValue(sheet, row.getRowNum(), c.getColumnIndex());
					System.out.print(rs + "  ");
				} else {
					// System.out.println(getCellValue(c));
					/**
					 * c.getRichStringCellValue() 与getStringCellValue()的区别是
					 * :第一种可以获取到该cell内的数据的格式
					 */
					// System.out.print(c.getRichStringCellValue() + " ");
				}
			}
			System.out.println();

		}

	}

	/**
	 * 获取合并单元格的值
	 * 
	 * @param sheet
	 * @param row
	 * @param column
	 * @return
	 */
	public static String getMergedRegionValue(Sheet sheet, int row, int column) {
		int sheetMergeCount = sheet.getNumMergedRegions();
		Cell fCell = null;
		for (int i = 0; i < sheetMergeCount; i++) {
			CellRangeAddress ca = sheet.getMergedRegion(i);
			int firstColumn = ca.getFirstColumn();
			int lastColumn = ca.getLastColumn();
			int firstRow = ca.getFirstRow();
			int lastRow = ca.getLastRow();

			if (row >= firstRow && row <= lastRow) {
				if (column >= firstColumn && column <= lastColumn) {
					Row fRow = sheet.getRow(firstRow);
					fCell = fRow.getCell(firstColumn);
					if (fCell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						// 小数尾部保留5位
						numberFormat.setMaximumFractionDigits(5);
						String value = numberFormat.format(fCell.getNumericCellValue());
						return value;
					} else {
						fCell.setCellType(Cell.CELL_TYPE_STRING);
						String value = fCell.getStringCellValue();
						return value;
					}
				}
			}
		}
		fCell = sheet.getRow(row).getCell(column);
		if (fCell == null)
			return "";
		fCell.setCellType(Cell.CELL_TYPE_STRING);
		return fCell.getStringCellValue();
	}

	/**
	 * 判断合并了行
	 * 
	 * @param sheet
	 * @param row
	 * @param column
	 * @return
	 */
	private boolean isMergedRow(Sheet sheet, int row, int column) {
		int sheetMergeCount = sheet.getNumMergedRegions();
		for (int i = 0; i < sheetMergeCount; i++) {
			CellRangeAddress range = sheet.getMergedRegion(i);
			int firstColumn = range.getFirstColumn();
			int lastColumn = range.getLastColumn();
			int firstRow = range.getFirstRow();
			int lastRow = range.getLastRow();
			if (row == firstRow && row == lastRow) {
				if (column >= firstColumn && column <= lastColumn) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 判断指定的单元格是否是合并单元格
	 * 
	 * @param sheet
	 * @param row
	 *            行下标
	 * @param column
	 *            列下标
	 * @return
	 */
	private static boolean isMergedRegion(Sheet sheet, int row, int column) {
		int sheetMergeCount = sheet.getNumMergedRegions();
		for (int i = 0; i < sheetMergeCount; i++) {
			CellRangeAddress range = sheet.getMergedRegion(i);
			int firstColumn = range.getFirstColumn();
			int lastColumn = range.getLastColumn();
			int firstRow = range.getFirstRow();
			int lastRow = range.getLastRow();
			if (row >= firstRow && row <= lastRow) {
				if (column >= firstColumn && column <= lastColumn) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 判断sheet页中是否含有合并单元格
	 * 
	 * @param sheet
	 * @return
	 */
	private boolean hasMerged(Sheet sheet) {
		return sheet.getNumMergedRegions() > 0 ? true : false;
	}

	/**
	 * 合并单元格
	 * 
	 * @param sheet
	 * @param firstRow
	 *            开始行
	 * @param lastRow
	 *            结束行
	 * @param firstCol
	 *            开始列
	 * @param lastCol
	 *            结束列
	 */
	private void mergeRegion(Sheet sheet, int firstRow, int lastRow, int firstCol, int lastCol) {
		sheet.addMergedRegion(new CellRangeAddress(firstRow, lastRow, firstCol, lastCol));
	}

	/**
	 * 根据文档中的省份名称获取其对饮的对象属性名
	 * 
	 * @param cells
	 *            cell集合
	 * @return
	 */
	public static List<String> getCellAboutProvince(List<Cell> cells) {

		List<String> valueList = new ArrayList<>();

		if (cells == null)
			return null;
		for (int i = 0; i < cells.size(); i++) {
			Cell cell = cells.get(i);
			if (cell == null) {
				valueList.add("");
			} else {
				cell.setCellType(Cell.CELL_TYPE_STRING);
				String key = cell.getStringCellValue();
				String value = BaseDataUtils.getValue(key);
				valueList.add(value);
			}
		}
		return valueList;
	}

	/**
	 * 获取单元格的值
	 * 
	 * @param cells
	 *            cell集合
	 * @return
	 */
	public static List<String> getCellValue(Sheet sheet, List<Cell> cells) {
		List<String> valueList = new ArrayList<>();

		if (cells == null)
			return null;
		for (int i = 0; i < cells.size(); i++) {
			Cell cell = cells.get(i);
			if (cell == null) {
				valueList.add("");
			} else {
				int rowIndex = cell.getRowIndex();
				int columnIndex = cell.getColumnIndex();
				if (isMergedRegion(sheet, rowIndex, columnIndex)) {
					String value = getMergedRegionValue(sheet, rowIndex, columnIndex);
					valueList.add(value);
				} else {
					if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						// 小数尾部保留5位
						numberFormat.setMaximumFractionDigits(5);
						String value = numberFormat.format(cell.getNumericCellValue());
						valueList.add(value);
					} else {
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String key = cell.getStringCellValue();
						valueList.add(key);
					}
				}
			}
		}
		return valueList;
	}
}
