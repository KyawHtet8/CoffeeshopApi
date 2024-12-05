package com.example.rockstar.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	@Column(unique = true)
	private String email;
	@Column(unique = true)
	private String userName;
	private String password;

	public User(String name, String email, String userName, String password) {
		super();
		this.name = name;
		this.email = email;
		this.userName = userName;
		this.password = password;
	}
	
	/*
	 List<User> users = findAllUsers();
	 for(User user:users){
	 	List<Role> roles = user.getRoles(); 
	 	
	 	This code can not achieve if u wanna make this work we must be set fetchType,Eager
	 */
	
	@ManyToMany(cascade = CascadeType.PERSIST ,fetch = FetchType.EAGER)
	private Set<Role> roles = new HashSet<>();
	
	public void addRole(Role role) {
		roles.add(role);
	}

}
