package cn.wudi.crm.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页数据
 * @author zh
 */
public class PageData<T> {
	
	/**
	 * 总共多少条数据
	 */
	private Integer total;
	
	/**
	 * 当前页的数据
	 */
	private List<T> rows = new ArrayList<>();

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}
}
