package cn.wudi.crm.service;

import cn.wudi.crm.domain.PageData;
import cn.wudi.crm.query.BaseQuery;

public interface IBaseService<T> {
	
	void save(T t);
	
	void update(T t);
	
	void delete(Long id);
	
	PageData<T> getPage(BaseQuery query);
	
	T get(Long id);
}
