package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.TeacherModel;

@Controller
@RequestMapping("/teacher/")
public class TeacherController {
	@GetMapping("")
	public String teacherEdit(ModelMap model ) {
		TeacherModel teacher = new TeacherModel() ;
		model.addAttribute("teacher", teacher);
		return "teachers/edit";
	}
	
	@GetMapping("edit/{name}")
	public String teacherEditByname(@ModelAttribute("teacher") TeacherModel teacher, ModelMap model) {
		return "teachers/edit";
	}
	
	@PostMapping("update")
	public String teacherUpdate(RedirectAttributes redirectAttributes, @ModelAttribute("teacher") TeacherModel teacher) {
		
		// addFlashAttribute giúp dữ liệu sống sót qua 1 lần redirect
        redirectAttributes.addFlashAttribute("teacher", teacher);
		return "redirect:info";
	}
	
	@GetMapping("info")
	public String teacherInfo(ModelMap model) {
		if (!model.containsAttribute("teacher")) {
			model.addAttribute("teacher", new TeacherModel());
		}
		
		return "teachers/info";
	}
	
	// Cung cấp dữ liệu cho ComboBox "Đơn vị" (Nếu form của bạn có thẻ select)
    @ModelAttribute("departs")
    public Map<String, String> getDeparts() {
        Map<String, String> departs = new HashMap<>();
        departs.put("CNTT", "Khoa Công Nghệ Thông Tin");
        departs.put("CKM", "Khoa Cơ Khí Máy");
        departs.put("KT", "Khoa Kinh Tế");
        return departs;
    }
}
