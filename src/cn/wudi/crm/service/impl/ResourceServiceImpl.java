package cn.wudi.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wudi.crm.domain.PageData;
import cn.wudi.crm.domain.Resource;
import cn.wudi.crm.domain.SystemMenu;
import cn.wudi.crm.mapper.ResourceMapper;
import cn.wudi.crm.query.ResourceQuery;
import cn.wudi.crm.service.IResourceService;
import cn.wudi.crm.utils.ResourceUtils;
@Service
public class ResourceServiceImpl extends BaseServiceImpl<Resource> implements IResourceService{
	
	private static String CONTROLLER_PKG = "cn.wudi.crm.web.controller";
	
	private ResourceMapper resourceMapper;
	
	ResourceUtils resourceUtils = ResourceUtils.INSTANCE;
	
	@Autowired
	public ResourceServiceImpl(ResourceMapper resourceMapper) {
		super(resourceMapper);
		this.resourceMapper=resourceMapper;
	}

	@Override
	public List<SystemMenu> getResourceTypeNames() {
		return resourceUtils.getAllTypeName(CONTROLLER_PKG);
	}

	@Override
	public List<Resource> getTypeResources(String typeName) {
		System.out.println(typeName);
		//找到该类上的所有的资源
		List<Resource> resources = resourceUtils.getTypeResources(typeName);
		//设置状态
		for (Resource resource : resources) {
			resource.setHasResource(resourceMapper.getCountByUrl(resource.getUrl()) > 0);
		}
		System.out.println(resources);
		return resources;
	}

	@Override
	public void saveList(List<Resource> resources) {
		resourceMapper.saveList(resources);
	}

	@Override
	public void deleteList(List<Resource> resources) {
		resourceMapper.deleteList(resources);
	}


	@Override
	public PageData<Resource> findResource(ResourceQuery query) {
		PageData<Resource> pageData = new PageData<Resource>();
		pageData.setRows(resourceMapper.findResource(query));
		pageData.setTotal(resourceMapper.getCountByfindResource(query));
		return pageData;
	}
}
