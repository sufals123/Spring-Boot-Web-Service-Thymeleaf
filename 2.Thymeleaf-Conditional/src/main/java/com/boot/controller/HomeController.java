package com.boot.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.boot.model.Student;

@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("condition", true); // or false
        model.addAttribute("items", Arrays.asList("Item 1", "Item 2", "Item 3","Item 4"));
		return "index";
	}
	
	@GetMapping("/profile")
	public String profile(Model m) {
		Student s1 = new Student(1,"sufal","India");
		Student s2 = new Student(2,"Lixa", "Japan");
		Student s3 = new Student(3,"Jone", "USA");
		Student s4 = new Student(4,"Moon9", "WORLD");
		Student s5 = new Student(5,"return8", "helping homeless man World");
		
		List<Student> list = new ArrayList<>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		list.add(s5);
		
		m.addAttribute("student", list);		
		
		return "profile";
		
	}
}
