package com.sfac.common.vo;

import org.apache.commons.lang3.StringUtils;

/**
 * @Description Search
 * @Author JiangHu
 * @Date 2023/7/10 10:46
 */
public class Search {
	private int currentPage;
	private int pageSize;
	private String sort;
	private String direction;
	private String keyword;

	public void init() {
		this.currentPage = this.currentPage == 0 ? 1 : this.currentPage;
		this.pageSize = this.pageSize == 0 ? 5 : this.pageSize;
		this.sort = StringUtils.isBlank(this.sort) ? "id" : this.sort;
		this.direction = StringUtils.isBlank(this.direction) ? "desc" : this.direction;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
