package com.example.demo.controller;

import java.net.http.HttpRequest;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CategoryEntity;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/api/category")
public class CategoryAPIController {
	@Autowired 
	private CategoryRepository repository; // Tiêm (Inject) Repository vào để sử dụng
	@Autowired
	private CategoryService categoryService;
	
	//Lấy toàn bộ category 
	@GetMapping("")
	public ResponseEntity<?> list(){
		// Trả về HTTP 200 OK kèm theo danh sách lấy từ DB
		return ResponseEntity.ok().body(repository.findAll());
	}
	
	//Tìm Category theo name
	@GetMapping("/get")
	public ResponseEntity<CategoryEntity> getCategory(@RequestParam("name") String categoryname){
		Optional <CategoryEntity> category = categoryService.findByName(categoryname);
		
		if (category.isEmpty()) {
			return ResponseEntity.notFound().build();
			//Đây là response khác
			//return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not found");
			
		} else {
			return ResponseEntity.ok(category.get());
		}
	}
	
	//Tao category
	@PostMapping("/save")
	public CategoryEntity saveCate (@Valid @RequestBody CategoryEntity category) {
		return categoryService.save(category);
	}
	
	//Update catgory theo ID
	@RequestMapping(value = "/update/{id}", method= RequestMethod.PUT)
	public ResponseEntity<CategoryEntity> updateCategory (@PathVariable(value ="id") Long categoryId
															, @Valid @RequestBody CategoryEntity category){
		//Tìm Category cần phải chỉnh sửa
		Optional<CategoryEntity> cate = categoryService.findById(categoryId);
		if (cate == null) {
			return ResponseEntity.notFound().build();
		} else {
			//Đổi tên
			cate.get().setName(category.getName());
			CategoryEntity updatedcategory = categoryService.save(cate.get());
			return ResponseEntity.ok(updatedcategory);
		}
	}
	
	//Xoá Category
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<CategoryEntity> deleteCategory(@PathVariable(value="id") Long categoryId){
		//Tìm Category cần phải chỉnh sửa
		Optional<CategoryEntity> cate = categoryService.findById(categoryId);
		//Kiểm tra có null không
		if (cate == null) {
			return ResponseEntity.notFound().build();
		} else {
			categoryService.delete(cate.get());
			return ResponseEntity.ok().build();
		}
	}
	
}
