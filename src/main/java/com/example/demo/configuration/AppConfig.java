package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.CompanyModel;

@Configuration
public class AppConfig {
	@Bean
	public CompanyModel GetCompanyInfo() {
		CompanyModel company = new CompanyModel("FPT", "Slogan...", "logoFPT.jpg");
		return company;
	}
}
