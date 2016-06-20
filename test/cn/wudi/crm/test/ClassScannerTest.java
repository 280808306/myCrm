package cn.wudi.crm.test;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.web.bind.annotation.RequestMapping;


public class ClassScannerTest {
	//测试使用spring提供的工具扫描所有的类
	
	String pkg = "cn.wudi.crm.web.controller";
	
	@Test
	public void testGetClass() throws Exception {
		String path = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX +
				pkg.replace(".", "/") +"/*.class";
		System.out.println(path);
		ResourcePatternResolver rpr = new PathMatchingResourcePatternResolver();
		// 使用spring的工具扫描路 径下的所有类 .class文件
		Resource[] resources = rpr.getResources(path);
		for (Resource resource : resources) {
			
			// 获取扫描包下的所有的文件名
			String name = resource.getFile().getName();
			// 拼出类的全限定名
			String className = pkg+"." + name.substring(0, name.lastIndexOf("."));
			//反射获取类
			Class<?> clzz = Class.forName(className);
			System.out.println(clzz);
			// 获取类中所有的公开的方法
			Method[] methods = clzz.getMethods();
			System.out.println("m-----------------------------");
			for (Method method : methods) {
				System.out.println(method.getName());
				//获取方法上的注解
				// 判断 注解是否我们想要的 注解  以RequestMapping为例 使用Resource注解也是一样的
				RequestMapping mapping = method.getAnnotation(RequestMapping.class);
				if(mapping != null){
					System.out.println("xxxxxxxxxxxxxxbbbb");
					System.out.println(Arrays.toString(mapping.value()));
					System.out.println("xxxxxxxxxxxxxxffffff");
					
					/*// 如果是Resource封装Resource对象   ClassName
					cn.wudi.crm.domain.Resource res = new cn.wudi.crm.domain.Resource();
					res.setName(xxx.name());
					res.setUrl(className+":"+method.getName()+"()");
					//添加到返回的list里面
					 */				
					}
			}
			System.out.println("m======================================");
		}
	}
}
