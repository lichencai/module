package aop.proxyFactoryBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	private static ApplicationContext ac;

	public static void main(String[] args) {  
		
        ac = new ClassPathXmlApplicationContext("proxyFactoryBean.xml");  
        IBusinessLogic ibl = (IBusinessLogic)ac.getBean("businessLogicBean");  
        ibl.foo();  
        try {  
            ibl.bar();  
        } catch (BusinessLogicException e) {  
            System.out.println("Caught BusinessLogicException");  
        }  
        ibl.time();  
        
    }  
}
