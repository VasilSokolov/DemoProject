package com.java.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.demo.models.viewModels.user.ViewUser;
import com.java.demo.services.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("allUsers")
	public String getAllUsers (Model model) {
		List<ViewUser> users = this.userService.findAll();
		
		model.addAttribute("users", users);
		
		return "users";
		
	}
}
