package com.womow.henan.commons.bean.json;

import java.util.List;

public class ReportDataBean {
	private List<String> categories;  
    private List<Integer> data;
    private List<String> yearCategories;
    private List<String> sortCategories;
	public List<String> getCategories() {
		return categories;
	}
	public void setCategories(List<String> categories) {
		this.categories = categories;
	}
	public List<Integer> getData() {
		return data;
	}
	public void setData(List<Integer> data) {
		this.data = data;
	}
	public List<String> getYearCategories() {
		return yearCategories;
	}
	public void setYearCategories(List<String> yearCategories) {
		this.yearCategories = yearCategories;
	}
	public List<String> getSortCategories() {
		return sortCategories;
	}
	public void setSortCategories(List<String> sortCategories) {
		this.sortCategories = sortCategories;
	}
}
