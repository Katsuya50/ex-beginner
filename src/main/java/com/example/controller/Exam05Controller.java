package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Member;
import com.example.repository.MemberRepository;

@Controller
@RequestMapping("/exam05")
public class Exam05Controller {
	
	@Autowired
	private MemberRepository repository;
	
	@RequestMapping("")
	public String index() {
		return "exam05";
	}
	
	@RequestMapping("/result")
	public String result(String name, Model model) {
		List<Member> memberList = new ArrayList<>();
		memberList = repository.findByName(name);
		List<String> nameList = new ArrayList<>();
		for(int i = 0; i < memberList.size(); i++) {
			nameList.add(memberList.get(i).getName());
		}
		model.addAttribute("nameList", nameList);
		return "exam05-result";
	}
}
