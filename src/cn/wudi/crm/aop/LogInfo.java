package cn.wudi.crm.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 贴在 类上 表示类的 模块名字 
 * 贴在方法上 表示方法的功能
 * @author zh
 *
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited //该注解可以继承使用
public @interface LogInfo {
	String value();
	boolean ignore() default false;
}
