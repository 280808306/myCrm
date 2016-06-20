package cn.wudi.crm.mapper;

import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.wudi.crm.domain.Employee;
import cn.wudi.crm.domain.SystemLog;
import cn.wudi.crm.query.SystemLogQuery;
import cn.wudi.crm.test.BaseSpringTest;

public class SystemLogMapperTest extends BaseSpringTest {
	
	@Autowired
	SystemLogMapper systemLogMapper;

	@Test
	public void testCreateTable() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testSave() {
		SystemLog log = new SystemLog();
		log.setOpIp("xxxx");
		Employee opUser = new Employee();
		opUser.setId(1L);
		log.setOpUser(opUser);
		log.setOpTime(new Date());
		log.setFunction("xxxxx:xxxx");
		systemLogMapper.save(log);
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testGet() {
		System.out.println(systemLogMapper.get(1L));
	}

	@Test
	public void testGetList() {
		System.out.println(systemLogMapper.getList(new SystemLogQuery()));
	}

	@Test
	public void testGetCount() {
		System.out.println(systemLogMapper.getCount(new SystemLogQuery()));
	}

}
