package com.tricon.demoSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoSpringApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(DemoSpringApplication.class, args);
		
		String[] beans=ctx.getBeanDefinitionNames();
		
		for(String bean : beans) {
			System.out.println(bean);
		}
	}

}
