package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class UserController {

	UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = new UserService();
	}

	@GetMapping("/")
	public String index() {
		return "spring boot";
	}

	@GetMapping("/greeting")
	public String greeting() {
		return "greeting";
	}

	@GetMapping("/users")
	public User users() {
		return userService.getUsers().get(0);
	}
}
