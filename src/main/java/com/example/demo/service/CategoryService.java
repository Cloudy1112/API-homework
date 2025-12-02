package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.CategoryEntity;
import com.example.demo.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository repository;

	
	//Tìm theo tên
	public Optional<CategoryEntity> findByName(String categoryname) {
		Optional<CategoryEntity> categoryBox = repository.findByName(categoryname);
		
		return categoryBox;
		
	}
	
	//Tìm theo Id
	public Optional<CategoryEntity> findById(Long id) {
		Optional<CategoryEntity> categoryBox = repository.findById(id);
		return categoryBox;
		
	}
	
	//
	
	//Save Category 
	public CategoryEntity save(CategoryEntity category) {
		CategoryEntity cate = repository.save(category);
		return cate;
	}
	
	//Delete Category
	public void delete(CategoryEntity category) {
		repository.delete(category);
	}
}
