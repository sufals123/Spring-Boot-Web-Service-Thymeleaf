package com.boot.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.boot.model.User;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
    	
        model.addAttribute("name", "Jone");
        model.addAttribute("date", new Date());
        
        User user1 = new User(1, "sani", "India");
        User user2 = new User(2, "sanam", "UK");
        
        model.addAttribute("user", user1);
        model.addAttribute("user1", user2);
        return "index";
    }
    
    @GetMapping("/profile")
    public String Profile(Model m) {
    	m.addAttribute("status", true);
		return "profile";
		
    	
    }
}
