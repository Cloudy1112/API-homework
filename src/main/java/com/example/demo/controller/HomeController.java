package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.CompanyModel;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
	@Autowired
	CompanyModel company;
	
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
	
	@GetMapping("/index")
	public String index(ModelMap model) {
		model.addAttribute("company", company);
		return "clients/company" ; 
	}
}
