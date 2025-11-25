package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
	
	@GetMapping("/dang-nhap")
	public String showForm() {
		return "clients/login";
	}
	
	@PostMapping("/dang-nhap")
	public String login(HttpServletRequest req) {
		String username = req.getParameter("username").toString();
		String password = req.getParameter("password").toString();
		
		if (username.equals("trung") && password.equals("123")) {
			req.setAttribute("uuid", username);
			req.setAttribute("pwd", password);
			return "clients/info";
		} else {
			req.setAttribute("message", "Username / password incorrect");
			return "clients/login";
		}
	} 
	
	
	

}
