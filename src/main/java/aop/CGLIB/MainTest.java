package aop.CGLIB;

import net.sf.cglib.proxy.Enhancer;


/**
 * 动态字节码生成
 * 这种方式实现的代理无需继承某些接口，通过扩展父类来实现方法调用的逻辑织入 
 * 
 * 使用Enhancer为目标对象生成一个子类
 */
public class MainTest {
	public static void main(String[] args){
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(Requestable.class);
		enhancer.setCallback(new RequestCtrlCallback());
		
		Requestable proxy = (Requestable)enhancer.create();
		proxy.request();
		
		System.out.println("end...");
	}
}
