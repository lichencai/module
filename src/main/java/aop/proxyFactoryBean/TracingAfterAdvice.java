package aop.proxyFactoryBean;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

/* 
 * 表示一个在方法返回时进行拦截的Advice 
*/  
public class TracingAfterAdvice implements AfterReturningAdvice {  
	
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
    	
        System.out.println(method.getDeclaringClass().getName() + 
        		"." + method.getName() + " spend time: " + returnValue); 
        
        System.out.println("execute after (by " + 
        		method.getDeclaringClass().getName() + "." + method.getName() + ")");
        
    }  
    
} 