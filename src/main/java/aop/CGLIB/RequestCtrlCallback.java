package aop.CGLIB;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;



/**
 * 动态字节码生成
 * 这种方式实现的代理无需继承某些接口，通过扩展父类来实现方法调用的逻辑织入 
 * 
 * 使用CGLIB进行扩展
 */
public class RequestCtrlCallback implements MethodInterceptor{

	public Object intercept(Object object, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		if(method.getName().equals("request")){
			System.out.println("方法织入...");
			return proxy.invokeSuper(object, args);
		}
		return null;
	}

}
