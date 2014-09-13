package aop;

import java.lang.reflect.Proxy;

/**
 * 动态代理机制的实现主要由一个类和一个接口组成 ，即java.lang.reflect.InvocationHandler;
 * 和java.lang.reflect.Proxy;
 */
public class MainTest {
	
	public static void main(String[] args){
		
		ISubject subject = (ISubject)Proxy.newProxyInstance(
				ISubject.class.getClassLoader(), 
				new Class[]{ISubject.class}, 
				new RequestCtrlInvocationHandler(new SubjectImpl()));
		
		String s = subject.request();
		
		System.out.println(s);
		System.out.println("end...");
	}
	
	
	
}
