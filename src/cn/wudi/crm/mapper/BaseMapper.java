package cn.wudi.crm.mapper;

import java.util.List;

import cn.wudi.crm.query.BaseQuery;

/**
 * 通用的操作放在这里面
 * @author zh
 */
public interface BaseMapper<T> {
	
	/**
	 * 建表
	 */
	void createTable();
	
	/**
	 * 删除一条记录
	 */
	void delete(Long id);
	
	/**
	 * 保存一条记录
	 */
	void save(T t);
	
	/**
	 * 修改一条记录
	 */
	void update(T t);
	
	/**
	 * 查询一条记录
	 */
	T get(Long id);
	
	/**
	 * 获取查询的数据
	 */
	List<T> getList(BaseQuery query);
	
	/**
	 * 查询总的条数
	 */
	Integer getCount(BaseQuery query);

}
