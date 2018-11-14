package pl.entito.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import pl.entito.demo.beans.Greeter;

@ComponentScan(basePackageClasses = Greeter.class)
@Configuration
public class ApplicationConfiguration {

}
