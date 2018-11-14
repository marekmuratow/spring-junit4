package pl.entito.demo.beans;

import org.springframework.stereotype.Service;

@Service
public class Greeter {

	public String greet() {
		System.out.println("greetings");
		return "greetings";
	}
}
