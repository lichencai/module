package test;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
	
	private static ApplicationContext ctx;
	
	public static void main(String[] args){
		ctx = new ClassPathXmlApplicationContext("classpath:SpringXMLSchema.xml");
		TheTestSpringXML theTestSpringXML = (TheTestSpringXML)ctx.getBean("theTestSpringXML");
		Map<?, ?> map = theTestSpringXML.getMapValue();
		
		String str = (String)map.get("strValueKey");
		System.out.println(str);
		
		List lst = (List)map.get("lst");
		for(Object each : lst){
			System.out.println(each.toString());
		}
		
		Object testObject = map.get("obj");
		System.out.println(testObject.toString());
	}
}
