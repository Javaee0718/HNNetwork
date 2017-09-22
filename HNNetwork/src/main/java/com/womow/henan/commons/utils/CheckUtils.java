package com.womow.henan.commons.utils;

import java.util.List;

/**
 * @author 蔡长盟
 * @description 数据校验工具类
 * @version 2017年8月2日
 * @eamil modules@163.com
 */
public class CheckUtils {

	/**
	 * 年度省公司指标汇总表数据校验
	 * 
	 * @param values
	 * @param matchs
	 * @return
	 */
	public static String checkCellValue(List<String> values) {
		String matches = "^[>]*[<]*[=]*\\d+\\.?\\d*$";
		int index = 0;
		boolean isChe = true;
		for (int i = 3; i < values.size(); i++) {
			String value = values.get(i);
			index = i;
			if (value != null && !value.equals("")) {
				if (!value.matches(matches)) {
					isChe = false;
					break;
				}
			}
		}
		StringBuffer sb = new StringBuffer();
		sb.append(isChe);
		sb.append("=");
		sb.append(index);
		return sb.toString();
	}

	public static String checkGradeValue(List<String> cells) {
		int index = 0;
		boolean isChe = true;
		int i = 0;
		try {
			if (cells != null && cells.size() > 0) {
				for (; i < cells.size(); i++) {
					String s = cells.get(i);
					if (i != 0) {
						if (s != null && !"".equals(s.trim())) {
							Double.parseDouble(s);
						}
					}
				}
			}
		} catch (Exception e) {
			StringBuffer sb = new StringBuffer();
			isChe = false;
			sb.append(isChe);
			sb.append("=");
			sb.append(i);
			return sb.toString();
		}
		return "true=";
	}
}
