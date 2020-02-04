package com.example.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam03")
public class Exam03Controller {
	
	@Autowired
	private ServletContext application;
	
	@RequestMapping("")
	public String index() {
		return "exam03";
	}
	
	@RequestMapping("/result")
	public String result(String pro1, String pro2, String pro3) {
		Integer withoutTaxTotal = Integer.parseInt(pro1) + Integer.parseInt(pro2)+ Integer.parseInt(pro3);
		Integer includeTaxTotal = (int)(withoutTaxTotal * 1.1);
		application.setAttribute("withoutTaxTotal", withoutTaxTotal);
		application.setAttribute("includeTaxTotal", includeTaxTotal);
		return "exam03-result";
	}
	
}
