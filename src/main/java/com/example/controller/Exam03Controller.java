package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam03")
public class Exam03Controller {
	
	@RequestMapping("")
	public String index() {
		return "exam03";
	}
	
	@RequestMapping("/result")
	public String result(String pro1, String pro2, String pro3, Model model) {
		Integer total1 = Integer.parseInt(pro1) + Integer.parseInt(pro2)+ Integer.parseInt(pro3);
		Integer total2 = (int)(total1 * 1.1);
		model.addAttribute("total1", total1);
		model.addAttribute("total2", total2);
		return "exam03-result";
	}
	
}
