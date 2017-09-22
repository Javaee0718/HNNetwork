package com.womow.henan.commons.bean;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description 分页对象
 * @author CAI modules@163.com
 * @data 2017年8月7日下午10:53:47
 * @version V1.0
 */
public class Query extends LinkedHashMap<String, Object> {

	private int page; // 当前页
	private int limit; // 每页记录数

	public Query(Map<String, Object> params) {
		this.putAll(params);
		if (params.get("page") != null) {
			this.page = Integer.parseInt(params.get("page").toString());
		} else {
			page = 1;
		}
		if (params.get("limit") != null) {
			this.limit = Integer.parseInt(params.get("limit").toString());
		} else {
			limit = 13;
		}
		// 分页参数
		this.put("offset", (page - 1) * limit);
		this.put("page", page);
		this.put("limit", limit);
	}

	public Query() {

	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

}
