package com.umbrella.worker.util;

import java.util.List;
/**
 * <p>Description: 分页类</p>
 * @date 2013年9月23日
 * @author reagan
 * @version 1.0
 * <p>Company:reagan</p>
 * <p>Copyright:Copyright(c)2013</p>
 */
public class PageBeanUtil {
	

	/**
	 * 当前页
	 */
	private int currentPage;

	/**
	 * 每页显示的结果数
	 */
	private int pageSize;

	/**
	 * 总页数
	 */
	private long pageCount;
	
	private int[] pages;
	

	/**
	 * 分页容器
	 */
	private List<Object> dataList;
	
	/**
	 * 总记录数
	 */
	private long recordCount;
	
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

	public long getPageCount() {
		return pageCount;
	}

	public void setPageCount(long recordCount) {
		if(pageSize==0)return;
		if (recordCount % pageSize == 0) {
			this.pageCount = recordCount / pageSize;
		} else {
			this.pageCount = recordCount / pageSize + 1;
		}
	}

	public List<Object> getDataList() {
		return dataList;
	}

	public void setDataList(List<Object> dataList) {
		this.dataList = dataList;
	}

	public long getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(long recordCount) {
		this.recordCount = recordCount;
	}

	public int[] getPages() {
		return pages;
	}

	public void setPages(int currentPage) {
		if(pageCount > 1) { 
			int maxPage = 10;
			if(pageCount < 10) {
				pages = new int[(int) this.pageCount];
				maxPage = (int) this.pageCount;
			} else {
				pages = new int[10];
			}
			
			for(int i = 0; currentPage <= maxPage; i++, currentPage++) {
				pages[i] = currentPage;
			}
		}
	}

    

}
