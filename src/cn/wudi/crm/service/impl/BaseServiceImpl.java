package cn.wudi.crm.service.impl;

import cn.wudi.crm.aop.LogInfo;
import cn.wudi.crm.domain.PageData;
import cn.wudi.crm.mapper.BaseMapper;
import cn.wudi.crm.query.BaseQuery;
import cn.wudi.crm.service.IBaseService;

/**
 * service 操作的公共类
 * 
 * @author zh
 * 
 */
public abstract class BaseServiceImpl<T> implements IBaseService<T> {

	private BaseMapper<T> mapper;

	public BaseServiceImpl(BaseMapper<T> mapper) {
		mapper.createTable(); //先不自动建表 避免其它同学 建表语句错误

		// 可以接受mapper做一些公共的操作
		this.mapper = mapper;
	}

	@LogInfo("保存")
	@Override
	public void save(T t) {
		mapper.save(t);
	}

	@LogInfo("修改")
	@Override
	public void update(T t) {
		mapper.update(t);
	}

	@LogInfo("删除")
	@Override
	public void delete(Long id) {
		mapper.delete(id);
	}

	@LogInfo(value="分页",ignore=true)
	@Override
	public PageData<T> getPage(BaseQuery query) {
		PageData<T> pageData = new PageData<>();
		pageData.setTotal(mapper.getCount(query));
		pageData.setRows(mapper.getList(query));
		return pageData;
	}

	@LogInfo("获取")
	@Override
	public T get(Long id) {
		return mapper.get(id);
	}
}
