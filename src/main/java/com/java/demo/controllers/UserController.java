package com.java.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.demo.entities.User;
import com.java.demo.models.bindengModels.user.RegisterUser;
import com.java.demo.models.viewModels.user.ViewUser;
import com.java.demo.services.UserService;

@Controller
@RequestMapping("users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("")
	public String user (Model model) {
		model.addAttribute("view", "/home");
		return "base-layout";
	}

	@GetMapping("add")
	public String setUser (Model model) {
		RegisterUser user = new RegisterUser();
		model.addAttribute("user", user);
		model.addAttribute("view", "/user/new-user");
		model.addAttribute("type","Create");
		return "base-layout";
	}
	
	@PostMapping("add")
	public String saveUser (@ModelAttribute RegisterUser registerUser) {		
		userService.persist(registerUser);
		return "redirect:/users/allUsers";
	}
	
	@GetMapping("allUsers")
	public String getAllUsers (Model model) {
		List<ViewUser> users = this.userService.findAll();
		model.addAttribute("users", users);
		model.addAttribute("view", "/user/users");
		model.addAttribute("delete", "Delete");
		model.addAttribute("edit", "Edit");
		return "base-layout";
	}
	
	@GetMapping("delete/{id}")
	public String deleteUser (@ModelAttribute RegisterUser registerUser, @PathVariable Long id) {
		registerUser.setId(id);
		userService.deleteUser(registerUser);
		return "redirect:/users/allUsers";
	}
	
	@GetMapping("edit/{id}")
	public String getEditUser (Model model, @PathVariable Long id) {
		User user = this.userService.findById(id);
		model.addAttribute("view", "/user/edit-user");
        model.addAttribute("user", user);
        model.addAttribute("edit", "Edit");
        return "base-layout";
	}
	
	@PostMapping("edit/{id}")
	public String editUser (@ModelAttribute RegisterUser registerUser, @PathVariable Long id) {
		registerUser.setId(id);
		userService.updateUser(registerUser);
		return "redirect:/users/allUsers";
	}
	
	
//	@PostMapping("delete/{id}")
//	public String deleteUser (@ModelAttribute RegisterUser registerUser, @PathVariable Long id) {
//		registerUser.setId(id);
//		userService.deleteUser(registerUser);
//		return "redirect:/users/allUsers";
//	}
}
