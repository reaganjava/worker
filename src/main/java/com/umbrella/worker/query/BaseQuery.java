package com.umbrella.worker.query;



public class BaseQuery {
	
	// 判断是否分页
    private boolean isPage;

    // 当前页数
    private int pageNO;
    
    // 每页显示数量
    private int pageRows;
    
    // 排序字段
 	private String orderByClause;
 	
 	// 排序方向
 	private String sort;
 	
 	private int status;
 	
 	private int datalevel;
 	
 	//1.最新 2.最热
    private int topType;
 	
 	// 最新货最热需要显示的记录数
    private int top = -1;
    
    //是否查询满足条件的记录数
    private boolean isNeedQueryTotal;

	public boolean isNeedQueryTotal() {
		return isNeedQueryTotal;
	}

	public void setNeedQueryTotal(boolean isNeedQueryTotal) {
		this.isNeedQueryTotal = isNeedQueryTotal;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public int getPageNO() {
        return pageNO;
    }

	public int getPageRows() {
        return pageRows;
    }

	public String getSort() {
		return "asc".equals(sort) ? "asc" : "desc";
	}
    
    /**
 	 * 用于数据库分页查询时,计算起始位置
 	 * @return
 	 */
 	public int getStart() {
 		if (pageNO < 1) pageNO = 1;
 		return (pageNO - 1) * pageRows  ;
 	}
    
    public int getTop() {
        return top;
    }

    public int getTopType() {
        return topType;
    }

    /**
     * 初始化数据
     * @param pageNO
     * @param pageRows
     * @param order
     * @param sort
     */
    public void initpage(Integer pageNO, int pageRows, String order, String sort) {
    	this.isPage = true;
    	if (pageNO == null) pageNO = 1;
 		this.pageNO = pageNO;
 		this.pageRows = pageRows;
 		this.orderByClause = order;
 		this.sort = sort;
 	}

    public boolean isPage() {
        return isPage;
    }

    /**
     * 指定属性排序
     * @param orderByClause 排序
     * <ol>
     * <li>createDate 创建时间</li>
     * <li>default 修改时间</li>
     * </ol>
     */
    public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

    public void setPage(boolean isPage) {
        this.isPage = isPage;
    }

    public void setPageNO(int pageNO) {
        this.pageNO = pageNO;
    }

    public void setPageRows(int pageRows) {
        this.pageRows = pageRows;
    }

    public void setSort(String sort) {
		this.sort = sort;
	}

    public void setTop(int top) {
        this.top = top;
    }

    public void setTopType(int topType) {
        this.topType = topType;
    }

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getDatalevel() {
		return datalevel;
	}

	public void setDatalevel(int datalevel) {
		this.datalevel = datalevel;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("QueryDO [isPage=");
		builder.append(isPage);
		builder.append(", pageNO=");
		builder.append(pageNO);
		builder.append(", pageRows=");
		builder.append(pageRows);
		builder.append(", orderByClause=");
		builder.append(orderByClause);
		builder.append(", sort=");
		builder.append(sort);
		builder.append(", topType=");
		builder.append(topType);
		builder.append(", top=");
		builder.append(top);
		builder.append(", isNeedQueryTotal=");
		builder.append(isNeedQueryTotal);
		builder.append(", getSort()=");
		builder.append(getSort());
		builder.append(", getStart()=");
		builder.append(getStart());
		builder.append("]");
		return builder.toString();
	}

}
