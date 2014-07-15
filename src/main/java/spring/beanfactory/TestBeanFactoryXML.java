package spring.beanfactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class TestBeanFactoryXML {
	public static void main(String[] args){
		DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();
		BeanFactory container = bindViaXMLFile(beanRegistry);
		FXNewsProvider newsProvider = (FXNewsProvider)container.getBean("djNewsProvider");
		newsProvider.printSuc();
		System.out.println(newsProvider.toString());
	}
	
	public static BeanFactory bindViaXMLFile(BeanDefinitionRegistry registry) {
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);
		reader.loadBeanDefinitions("classpath:bean.xml");
		return (BeanFactory)registry;
		// 或者直接
		//return new XmlBeanFactory(new ClassPathResource("../news-config.xml"));
	}
}
