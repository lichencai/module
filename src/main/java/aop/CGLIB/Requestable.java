package aop.CGLIB;
/**
 * 动态字节码生成
 * 这种方式实现的代理无需继承某些接口，通过扩展父类来实现方法调用的逻辑织入 
 */
public class Requestable {
	public void request(){
		System.out.println("Requestable request");
	}
}
