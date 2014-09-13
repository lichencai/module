package aop.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 与aopTest1的配置文件相结合
 */
public class Main1 {
	
	private static ApplicationContext ctx;

	public static void main(String[] args){
		ctx = new ClassPathXmlApplicationContext("aopTest1.xml");
		Object proxy = ctx.getBean("foo");
		((Foo)proxy).method1();
		((Foo)proxy).method2();
	}

}
