package com.example.demo.model;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Products")
public class ProductEntity implements Serializable{
	private static final long serialVerisonUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productID;
	
	@Column(name = "product_name", length = 200, columnDefinition = "nvarchar(200) not null")
    private String name;

    private Double price;

    private String image;

    private String description;

    // Quan trọng: Thiết lập quan hệ ngược lại với Category
    // @ManyToOne: Nhiều sản phẩm thuộc về một danh mục
    @ManyToOne
    @JoinColumn(name = "categoryId") // Tên cột khóa ngoại trong bảng Products liên kết với Categories
    @JsonIgnore // Tránh vòng lặp khi lấi API
    private CategoryEntity category;
	
}
