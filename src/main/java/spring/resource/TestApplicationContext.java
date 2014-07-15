package spring.resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试ApplicationContext的使用，用于在容器中加载生成的bean
 */
public class TestApplicationContext {
	private static ApplicationContext ctx;

	public static void main(String[] args){
		ctx = new ClassPathXmlApplicationContext("classpath:XMLResource.xml");
		Object obj = ctx.getBean("djNewsListener");
		System.out.println(obj);
	}
}
