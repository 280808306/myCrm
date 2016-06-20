package cn.wudi.crm.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.wudi.crm.domain.SystemDictionary;
import cn.wudi.crm.query.SystemDictionaryQuery;
import cn.wudi.crm.test.BaseSpringTest;

public class SystemDictionaryMapperTest  extends BaseSpringTest {
	
	@Autowired
	SystemDictionaryMapper systemDictionaryMapper;
	
	@Test
	public void testCreateTable() {
		systemDictionaryMapper.createTable();
	}
	
	@Test
	public void testSave() {
		SystemDictionary sd = new SystemDictionary();
		for (int i = 1; i < 51; i++) {
			sd.setSn("1111"+i);
			sd.setName("xxxxxx"+i);
			sd.setState(1);
			sd.setIntro("字典描述"+i);
			systemDictionaryMapper.save(sd);
		}
	}

	@Test
	public void testDelete() {
		systemDictionaryMapper.delete(50L);
	}


	@Test
	public void testUpdate() {
		SystemDictionary sd = new SystemDictionary();
		sd.setSn("1111bbbb");
		sd.setName("xxxxxxbbb");
		sd.setState(0);
		sd.setId(49L);
		systemDictionaryMapper.update(sd);
	}

	@Test
	public void testGet() {
		System.out.println(systemDictionaryMapper.get(1L));
	}

	@Test
	public void testGetList() {
		SystemDictionaryQuery query = new SystemDictionaryQuery();
		List<SystemDictionary> list = systemDictionaryMapper.getList(query);
		for (SystemDictionary systemDictionary : list) {
			System.out.println(systemDictionary);
		}
	}

	@Test
	public void testGetCount() {
		fail("Not yet implemented");
	}

}
