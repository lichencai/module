package aop.proxyFactoryBean;

public class BusinessLogic implements IBusinessLogic{

	public void foo() {
		System.out.println("Inside BusinessLogic.foo()");  
	}

	public void bar() throws BusinessLogicException {
		System.out.println("Inside BusinessLogic.bar()");  
        throw new BusinessLogicException();  
	}

	public long time() {
		System.out.println("Inside BusinessLogic.time()");  
        long startTime = System.currentTimeMillis();  
        for(int i = 0; i < 100000000; i++);  
        long endTime = System.currentTimeMillis();  
        return (endTime - startTime);  
	}
	  
}
