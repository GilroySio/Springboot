package org.example;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloController {

	@GetMapping("/")
	public String index() {
		return "spring boot";
	}

	@GetMapping("/greeting")
	public String greeting() {
		return "greeting";
	}

	@GetMapping("/users")
	public String users() {
		return "";
	}
}
