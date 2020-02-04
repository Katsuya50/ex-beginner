package com.example.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

public class UserForm {
	
	@NotEmpty(message="必ず入力してください")
	private String name;
	@NotNull(message="必ず入力してください")
	@Range(min=0, max=150, message="年齢を入力してください")
	private String age;
	@NotEmpty(message="必ず入力してください")
	private String comment;
	
	public Integer getIntAge() {
		return Integer.parseInt(age);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	

}
