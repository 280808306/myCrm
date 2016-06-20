package cn.wudi.crm.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import cn.wudi.crm.domain.SystemMenu;

public enum ResourceUtils {
	
	INSTANCE;
	
	/**
	 * 根据包名获取包路径下的所有类的全限定类型名
	 * @param pkg
	 * @return
	 */
	public List<SystemMenu> getAllTypeName(String pkg) {
		List<SystemMenu> result = new ArrayList<SystemMenu>();
		try {
			String path = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX +
					pkg.replace(".", "/") +"/*.class";
			ResourcePatternResolver rpr = new PathMatchingResourcePatternResolver();
			// 使用spring的工具扫描路 径下的所有类 .class文件
			Resource[] resources = rpr.getResources(path);
			SystemMenu systemMenu = new SystemMenu();
			systemMenu.setName("资源包："+pkg);
			systemMenu.setId(1L);
			result.add(systemMenu);
			for (Resource resource : resources) {
				SystemMenu menu = new SystemMenu();
				// 获取扫描包下的所有的文件名
				String name = resource.getFile().getName();
				// 拼出类的全限定名
				String className = pkg+"." + name.substring(0, name.lastIndexOf("."));
				menu.setUrl(className);
				cn.wudi.crm.utils.Resource res = Class.forName(className).getAnnotation(cn.wudi.crm.utils.Resource.class);
				if(res != null) {
					menu.setName(res.value());
				}else {
					menu.setName(className);
				}
				systemMenu.getChildren().add(menu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 获取资源标签上的功能
	 * @param typeName
	 * @return
	 * @throws Exception
	 */
	public List<cn.wudi.crm.domain.Resource> getTypeResources(String typeName) {
		List<cn.wudi.crm.domain.Resource> result = new ArrayList<cn.wudi.crm.domain.Resource>();
		try {
			Class<?> clzz = Class.forName(typeName);
			Method[] methods = clzz.getMethods();
			//获取类上的标签
			cn.wudi.crm.utils.Resource typeRes = clzz.getAnnotation(cn.wudi.crm.utils.Resource.class);
			//得到类上的标签上的值
			String resTypeName = typeRes == null ? typeName : typeRes.value();
			//加一个all
			if(methods.length > 0){
				cn.wudi.crm.domain.Resource all = new cn.wudi.crm.domain.Resource();
				all.setName(resTypeName+":所有");
				all.setUrl(typeName +":ALL");
				result.add(all);
			}
			
			for (Method method : methods) {
				cn.wudi.crm.domain.Resource resource = new cn.wudi.crm.domain.Resource();
				cn.wudi.crm.utils.Resource res = method.getAnnotation(cn.wudi.crm.utils.Resource.class);
				if(res != null){
					resource.setName(resTypeName +":"+res.value());
					resource.setUrl(typeName +":" +method.getName());
					result.add(resource);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return result;
	}
}
