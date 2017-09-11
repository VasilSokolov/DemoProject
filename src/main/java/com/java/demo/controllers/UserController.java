package com.java.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.demo.entities.User;
import com.java.demo.models.viewModels.user.ViewUser;
import com.java.demo.services.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	

	@GetMapping("")
	public String user (Model model) {
		model.addAttribute("view", "/user/new-user");
		return "base-layout";
	}	
	
	@PostMapping("register")
	@ResponseBody
	public String save (@RequestBody User user) {		
		userService.saveUser(user);
		return "redirect:/users";
	}
	
	@GetMapping("allUsers")
	public String getAllUsers (Model model) {
		List<ViewUser> users = this.userService.findAll();
		
		model.addAttribute("users", users);
		model.addAttribute("view", "/user/users");
		return "base-layout";
	}
}
