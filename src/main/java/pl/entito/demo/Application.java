package pl.entito.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.entito.demo.config.ApplicationConfiguration;

public class Application {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
		context.close();
	}

}
