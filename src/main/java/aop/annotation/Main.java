package aop.annotation;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
/**
 * 第1个
 */
public class Main {
	public static void main(String[] args){
		AspectJProxyFactory weaver = new AspectJProxyFactory();
		weaver.setProxyTargetClass(true);
		weaver.setTarget(new Foo());
		weaver.addAspect(PerformanceTraceAspect.class);
		Object proxy = weaver.getProxy();
		((Foo)proxy).method1();
		((Foo)proxy).method2();
	}
}
