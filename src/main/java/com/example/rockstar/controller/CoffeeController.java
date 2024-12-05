package com.example.rockstar.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rockstar.dto.CoffeeDto;
import com.example.rockstar.service.CoffeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/coffees")
@CrossOrigin("*")
public class CoffeeController {
	
	private final CoffeeService coffeeService;
	
	@GetMapping
	public List<CoffeeDto> getAllCoffees(){
		
		return coffeeService.getAllCoffees();
		
	}
	
	@PostMapping("/secured")
	public String securedMethod() {
		return	 coffeeService.securedString();
	}
	
	

}
