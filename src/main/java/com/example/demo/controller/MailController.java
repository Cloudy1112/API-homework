package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.EmailInfo;
import com.example.demo.service.MailerService;

@Controller
public class MailController {
	@Autowired
	MailerService mailservice;
	
	@GetMapping("/send-mail")
	public String MailForm(ModelMap model) {
		model.addAttribute("mail",new EmailInfo());
		return "clients/mailform";
	}
	
	// 2. Xử lý gửi mail (POST)
    @PostMapping("/send-mail")
    public String send(ModelMap model, 
                       @ModelAttribute("mail") EmailInfo mailInfo, 
                       @RequestParam("attachment") MultipartFile file) {
        try {
            // Gọi service gửi mail (đã viết ở bước trước)
            // Lưu ý: Cần sửa service để nhận thêm tham số file nếu muốn đính kèm thật
            mailservice.send(mailInfo.getTo(), mailInfo.getSubject(), mailInfo.getBody());
            
            model.addAttribute("message", "Gửi email thành công!");
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi: " + e.getMessage());
        }
        return "clients/mailform";
    }
	
	
}
