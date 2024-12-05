package com.example.rockstar.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.rockstar.entity.User;

public interface UserDao extends JpaRepository<User, Integer>{

		@Query("""
				select u from User u where u.userName = ?1or u.email = ?1
				
				""")

	
	Optional<User> findUserName(String userNameOrEmail);
	
	
}
