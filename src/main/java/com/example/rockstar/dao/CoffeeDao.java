package com.example.rockstar.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rockstar.entity.Coffee;

public interface CoffeeDao extends JpaRepository<Coffee, Integer>{

}
