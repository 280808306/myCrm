package cn.wudi.crm.mapper;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.wudi.crm.domain.SystemDictionary;
import cn.wudi.crm.domain.SystemDictionaryItem;
import cn.wudi.crm.query.SystemDictionaryItemQuery;
import cn.wudi.crm.test.BaseSpringTest;

public class SystemDictionaryItemMapperTest extends BaseSpringTest {

	@Autowired
	SystemDictionaryItemMapper systemDictionaryItemMapper;
	
	@Test
	public void testCreateTable() {
		systemDictionaryItemMapper.createTable();
	}
	
	@Test
	public void testSave() {
		SystemDictionaryItem item = new SystemDictionaryItem();
		for (int i = 1; i < 51; i++) {
			item.setSn(2222);
			item.setName("xxxxxx");
			SystemDictionary parent = new SystemDictionary();
			parent.setId(i % 5L);
			item.setParent(parent);
			systemDictionaryItemMapper.save(item);
		}
	}

	@Test
	public void testDelete() {
		systemDictionaryItemMapper.delete(50L);
	}
	
	@Test
	public void testDeleteByParentID() {
		systemDictionaryItemMapper.deleteByParentId(50L);
	}


	@Test
	public void testUpdate() {
		SystemDictionaryItem item = new SystemDictionaryItem();
		item.setSn(2222);
		item.setName("xxxxxx");
		SystemDictionary parent = new SystemDictionary();
		parent.setId(0L);
		item.setParent(parent);
		item.setId(49L);
		systemDictionaryItemMapper.update(item);
	}

	@Test
	public void testGet() {
		System.out.println("ssss" + systemDictionaryItemMapper.get(46L));
	}

	@Test
	public void testGetList() {
		List<SystemDictionaryItem> list = systemDictionaryItemMapper.getList(new SystemDictionaryItemQuery());
		for (SystemDictionaryItem systemDictionaryItem : list) {
			System.out.println(systemDictionaryItem);
		}
	}

	@Test
	public void testGetCount() {
		System.out.println(systemDictionaryItemMapper.getCount(new SystemDictionaryItemQuery()));
	}
	
	@Test
	public void testGetByParentId() {
		List<SystemDictionaryItem> list = systemDictionaryItemMapper.getByParentId(1L);
		for (SystemDictionaryItem systemDictionaryItem : list) {
			System.out.println(systemDictionaryItem);
		}
	}

}
