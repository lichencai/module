package aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * 动态代理机制的实现主要由一个类和一个接口组成 ，即java.lang.reflect.InvocationHandler;
 * 和java.lang.reflect.Proxy;
 */
public class RequestCtrlInvocationHandler implements InvocationHandler{
	private static final Log logger = LogFactory.getLog(RequestCtrlInvocationHandler.class);
	
	private Object target;
	
	public RequestCtrlInvocationHandler(Object target) {
		super();
		this.target = target;
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		if(method.getName().equals("request")){
			System.out.println("横切方法织入...");
			return method.invoke(target, args);
		}
		return null;
	}

}
