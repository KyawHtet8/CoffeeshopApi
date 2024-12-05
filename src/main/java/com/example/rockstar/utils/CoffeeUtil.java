package com.example.rockstar.utils;

import org.springframework.beans.BeanUtils;

import com.example.rockstar.dto.CoffeeDto;
import com.example.rockstar.entity.Coffee;

public class CoffeeUtil {
	
	
	public static CoffeeDto toCoffeeDto(Coffee coffee) {
		CoffeeDto coffeeDto = new CoffeeDto();
		BeanUtils.copyProperties(coffee, coffeeDto);
		return coffeeDto;
	}
	
	public static Coffee toCoffeeEntity(CoffeeDto coffeeDto) {
		Coffee coffee = new Coffee();
		BeanUtils.copyProperties(coffeeDto, coffee); 
		return coffee;
	}

}
