package com.java.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
	
	@GetMapping("/")
    public String getHomePage(Model model){
        model.addAttribute("view","home");
        return "base-layout";
    }
}
