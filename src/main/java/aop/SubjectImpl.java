package aop;

/**
 * 动态代理机制的实现主要由一个类和一个接口组成 ，即java.lang.reflect.InvocationHandler;
 * 和java.lang.reflect.Proxy;
 */
public class SubjectImpl implements ISubject{

	public String request() {
		return "hello";
	}

}
