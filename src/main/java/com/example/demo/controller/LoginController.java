package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.UserModel;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
	
	@GetMapping("/dang-nhap")
	public String showForm() {
		return "clients/login";
	}
	
	@PostMapping("/dang-nhap")
	public String login(HttpServletRequest req, ModelMap model, 
						@RequestParam (value="username", defaultValue = "") String username, //Dùng RequestParam để lấy tham số username & password và ép kiểu dữ liệu
						@RequestParam (value="password", defaultValue="") String password) { //Defaule value nếu không truyền mặc định là ""
		//String username = req.getParameter("username").toString();
		//String password = req.getParameter("password").toString();
		
		if (username.equals("trung") && password.equals("123")) {
			model.addAttribute("uuid", username);
			model.addAttribute("pwd", password);
			return "clients/info";
		} else {
			model.addAttribute("message", "Username / password incorrect");
			return "clients/login";
		}
	} 
	
	@GetMapping("/user-dang-nhap")
	public String showFormUser() {
		return "clients/user-login";
	}
	
	@PostMapping("/user-dang-nhap")
	public String userLogin (ModelMap model, UserModel user) {
		
		model.addAttribute("uuid", user.getUsername());
		model.addAttribute("pwd", user.getPassword());
		
		return "clients/userinfo";
	}
	
	@RequestMapping("/user/edit/{username}")
	public String EditUser (ModelMap model, 
							@PathVariable ("username") String username){
		model.addAttribute("uuid", username);
		return "clients/useredit";
	}
	
	@PostMapping("/user-edit")
	public String Edit(ModelMap model, UserModel user, RedirectAttributes redirectAttributes) {
		
		model.addAttribute("uuid", user.getUsername());
		model.addAttribute("pwd", user.getPassword());
		// Dùng addFlashAttribute để truyền tin nhắn sang trang sau khi redirect
	    redirectAttributes.addFlashAttribute("message", "Đã cập nhật thông tin thành công! Vui lòng đăng nhập lại.");
		return "redirect:/user-dang-nhap";
	    //return "clients/userinfo";
	}
	

}
