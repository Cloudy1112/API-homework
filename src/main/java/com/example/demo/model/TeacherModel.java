package com.example.demo.model;

public class TeacherModel {
	private String name;
	private int age;
	private String depart;
	public TeacherModel(String name, int age, String depart) {
		super();
		this.name = name;
		this.age = age;
		this.depart = depart;
	}
	public TeacherModel() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	
	

}
