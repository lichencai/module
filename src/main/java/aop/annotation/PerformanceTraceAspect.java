package aop.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.util.StopWatch;

/**
 * 第1个
 */
@Aspect
public class PerformanceTraceAspect {
	
	@Pointcut("execution(public void *.method1()) || execution(public void *.method2())")
	public void pointcutName(){
		
	}
	
	@Around("pointcutName()")
	public Object performanceTrace(ProceedingJoinPoint joinpoint) throws Throwable{
		StopWatch watch = new StopWatch();
		try{
			watch.start();
			return joinpoint.proceed();
		}finally{
			watch.stop();
			System.out.println("PT in method [" + joinpoint.getSignature().getName() 
					+ " ]>>>>" + watch.toString());
		}
	}
}
