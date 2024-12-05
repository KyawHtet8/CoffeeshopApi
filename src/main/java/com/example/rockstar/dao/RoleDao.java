package com.example.rockstar.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rockstar.entity.Role;

public interface RoleDao extends JpaRepository<Role, Integer> {

}
