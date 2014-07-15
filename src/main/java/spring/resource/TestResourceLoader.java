package spring.resource;

import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

public class TestResourceLoader {
	public static void main(String[] args){
		ResourceLoader resourceLoader = new FileSystemResourceLoader();
		Resource fileResource = resourceLoader.getResource("classpath:XMLResource.xml");
		System.out.println(fileResource.getFilename());
	}
}
