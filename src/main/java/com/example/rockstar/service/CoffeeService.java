package com.example.rockstar.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.stereotype.Service;

import com.example.rockstar.dao.CoffeeDao;
import com.example.rockstar.dto.CoffeeDto;
import com.example.rockstar.utils.CoffeeUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CoffeeService {
	
	private final CoffeeDao coffeeDao;
	
	@Secured("ROLE_ADMIN")                 // if u want to use @secured  u need to set @EnableMethodSecurity(securedEnabled = true)
	public String securedString() {
		return " Secured String";
	}
	
	@Secured({"ROLE_USER","ROLE_ADMIN"}) //@PreAuthorize("hasAnyRole(USER,ADMIN)")
	public List<CoffeeDto> getAllCoffees(){
		
		return coffeeDao.findAll()
				.stream()
				.map(CoffeeUtil :: toCoffeeDto)
				.collect(Collectors.toUnmodifiableList());
				
	}

}
