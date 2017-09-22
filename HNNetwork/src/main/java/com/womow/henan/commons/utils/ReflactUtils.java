package com.womow.henan.commons.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * @author 蔡长盟
 * @description 反射工具类
 * @version 2017年8月4日
 * @eamil modules@163.com
 */
public class ReflactUtils {

	/**
	 * 传入省份,与数据,全限定类名,通过反射创建对象
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public static Object reflactObject(Map<String, Object> map) throws Exception {
		String pojoName = (String) map.get("pojo");
		List<String> provinceNames = (List<String>) map.get("provinces");
		List<String> cellValues = (List<String>) map.get("values");

		Class clazz = Class.forName(pojoName);
		Object obj = clazz.newInstance();
		for (int i = 0; i < provinceNames.size(); i++) {
			String methodParam = provinceNames.get(i);
			String param = cellValues.get(i);
			// TODO 源头处去掉">="符号.
			// 也可以在每次操作均去掉">=",但是太影响性能
			param = param.replace(">=", "");
			String reg = "[-]?\\d*\\.?\\d*";
			if (!param.matches(reg)) {
				param = "";
			}
			Method method = clazz.getMethod("set" + methodParam, String.class);
			method.invoke(obj, param);
		}
		return obj;
	}
}
