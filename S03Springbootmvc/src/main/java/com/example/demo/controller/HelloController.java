package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	@ResponseBody  //in order to tell that helloworld is not jsp,it is content
	public String hello() {
		return "hello World";
	}
	
	@RequestMapping("/greet")
	@ResponseBody
	public String greet(@RequestParam String name) {
		return "Hello " + name;
	}
	
}