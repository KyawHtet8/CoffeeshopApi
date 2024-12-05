package com.example.rockstar.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Coffee {
	
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	
	@Column(columnDefinition = "text") //for more than 255 words in string (best solution)
	private String description;
	private String imgaeUrl;
	private double price;
	private int stock;
	public Coffee(String name, String description, String imgaeUrl, double price , int stock) {
		super();
		this.name = name;
		this.description = description;
		this.imgaeUrl = imgaeUrl;
		this.price = price;
		this.stock = stock;
	}
	
	

}
