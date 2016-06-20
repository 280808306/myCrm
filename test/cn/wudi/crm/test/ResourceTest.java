package cn.wudi.crm.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.wudi.crm.domain.Resource;
import cn.wudi.crm.mapper.ResourceMapper;
import cn.wudi.crm.query.ResourceQuery;
import cn.wudi.crm.service.IResourceService;

public class ResourceTest extends BaseSpringTest {

	@Autowired
	IResourceService resourceService;
	
	@Autowired
	ResourceMapper resourceMapper;
	
	@Test
	public void testSave() {
		resourceMapper.createTable();
		for (int i = 1; i < 51; i++) {
			Resource resource = new Resource();
			resource.setName("资源"+i);
			resource.setUrl("url");
			resourceService.save(resource);
		}
	}
	
	@Test
	public void testDelete() {
			resourceService.delete(9L);
	}
	
	@Test
	public void testUpdate() {
		Resource resource = new Resource();
		resource.setId(1L);
		resource.setName("资源");
		resource.setUrl("111");
		resourceService.update(resource);
	}
	
	@Test
	public void testGet() {
		System.out.println(resourceService.get(1L));
	}
	
	@Test
	public void testGetAll() {
		ResourceQuery query = new ResourceQuery();
		
		System.out.println(resourceService.getPage(query).getRows());
	}
	
}
