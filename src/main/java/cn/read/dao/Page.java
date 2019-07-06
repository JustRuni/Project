package cn.read.dao;

import java.util.List;

public class Page {
	
	// 总条数
	private long tatal;
	//每页显示条数
	private List<?> rows;
	// 当前页数
	private int currentPage;
	// 总页数
	private int totalPage;
	// 每页显示条数
	private int pageNumber;

	/*
	 * Page(){ pageNumber = 10; currentPage = 1; }
	 */
	public long getTatal() {
		return tatal;
	}
	public void setTatal(long tatal) {
		this.tatal = tatal;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	
}
