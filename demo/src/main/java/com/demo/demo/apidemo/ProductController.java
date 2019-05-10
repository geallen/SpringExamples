package com.demo.demo.apidemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	@GetMapping("/")
	public String get() {
		return "Laptop";
	}
	
	@GetMapping("/getall")
	public String getAll() {
		return "Laptop, mouse, keyboard, Pencil";
	}
	
	@GetMapping("/getPen")
	public String getPen() {
		return "Pen";
	}
}
