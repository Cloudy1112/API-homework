package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;


import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
	@GetMapping("/home")
	public String Index(HttpServletRequest req) {
		req.setAttribute("name", "Nguyen Trung");
		return "clients/index";
	}
	
	@GetMapping ({"/", "/trang-chu"})
	public String Index2(ModelMap model) {
		model.addAttribute("name", "Nguyen Trung");
		return "clients/index";
	}
}
