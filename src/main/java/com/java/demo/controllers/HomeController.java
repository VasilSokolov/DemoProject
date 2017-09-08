package com.java.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {

	@RequestMapping("/")
	public String getAllUsers (Model model) {
		model.addAttribute("name", "Again");	
		return "home";
		
	}

}
