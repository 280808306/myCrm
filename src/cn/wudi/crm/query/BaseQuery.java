package cn.wudi.crm.query;

import cn.wudi.crm.utils.UserContext;

public abstract class BaseQuery {

	/**
	 * 每页多少条数据
	 */
	private Integer rows = 10;

	/**
	 * 当前多少页数据
	 */
	private Integer page = 1;

	public Integer getRows() {
		return rows != null && rows < 1 ? null : rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	/**
	 * 获取分页的起始位置
	 */
	public int getBeginIndex() {
		return page != null && page > 1 ? (page - 1) * rows : 0;
	}
	
	public boolean getIsManagerRole(){
		return UserContext.isManagerRole();
	}
	
	/**
	 * 获取当前用户的id 用来过滤某些需要权限的数据
	 * @return
	 */
	public Long getCurrentUserId(){
		return UserContext.getUser().getId();
	}

}
