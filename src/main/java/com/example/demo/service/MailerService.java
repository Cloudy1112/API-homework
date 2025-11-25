package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service("mailer") // 1. Khai báo đây là một Bean có tên là 'mailer'
public class MailerService {
	@Autowired // 2. Tiêm Bean JavaMailSender của hệ thống vào để dùng
    JavaMailSender mailSender;

    public void send(String to, String subject, String body) throws MessagingException {
        // Tạo mail
        MimeMessage message = mailSender.createMimeMessage();
        
        // Sử dụng Helper để thiết lập các thông tin (theo trang 62 tài liệu)
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
        
        helper.setFrom("chonglevan2004@gmail.com");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(body, true); // true = cho phép nội dung HTML

        // Gửi mail
        mailSender.send(message);
    }
	
}
