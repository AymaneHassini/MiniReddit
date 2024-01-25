package com.MiniRedditt.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.MiniRedditt.domain.User;
import com.MiniRedditt.services.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/register")
	public String register(ModelMap model) {
		model.put("user", new User());
		return "register";
	}

	@PostMapping("/register")
	public String registerPost(User user) {
		// System.out.print(user);
		User savedUser = userService.save(user);
		System.out.print("Non Saved User:" + user);
		System.out.print("Non Saved User:" + savedUser);

		return "redirect:/login";
	}
}
