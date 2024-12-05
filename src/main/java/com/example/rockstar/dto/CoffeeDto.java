package com.example.rockstar.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CoffeeDto {
	
	private Integer id;
	private String name;
	private String description;
	private String imgaeUrl;
	private double price;
	
	
}
