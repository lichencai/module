package spring.beanfactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * 通过编码方式使用BeanFactory实现FX新闻相关类的注册及绑定
 */
public class TestBeacFactoryCode {
	public static void main(String[] args){
		DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();
		BeanFactory container = bindViaCode(beanRegistry);
		FXNewsProvider newsProvider = (FXNewsProvider)container.getBean("djNewsProvider");
		newsProvider.printSuc();
		System.out.println(newsProvider.toString());
	}
	
	public static BeanFactory bindViaCode(BeanDefinitionRegistry registry){
		AbstractBeanDefinition newsProvider = new RootBeanDefinition(FXNewsProvider.class);
		AbstractBeanDefinition newsListener = new RootBeanDefinition(DowJonesNewsListener.class);
		AbstractBeanDefinition newsPersister = new RootBeanDefinition(DowJonesNewsPersister.class);
		
		// 将bean定义注册到容器中
		registry.registerBeanDefinition("djNewsProvider", newsProvider);
		registry.registerBeanDefinition("djListener", newsListener);
		registry.registerBeanDefinition("djPersister", newsPersister);
		
		// 指定依赖关系
		// 1. 可以通过构造方法注入方式
		ConstructorArgumentValues argValues = new ConstructorArgumentValues();
		argValues.addIndexedArgumentValue(0, newsListener);
		argValues.addIndexedArgumentValue(1, newsPersister);
		newsProvider.setConstructorArgumentValues(argValues);
		
		
		return (BeanFactory)registry;
	}
}
