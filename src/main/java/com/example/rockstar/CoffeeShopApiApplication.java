package com.example.rockstar;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.example.rockstar.dao.CoffeeDao;
import com.example.rockstar.dao.RoleDao;
import com.example.rockstar.dao.UserDao;
import com.example.rockstar.entity.Coffee;
import com.example.rockstar.entity.Role;
import com.example.rockstar.entity.User;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class CoffeeShopApiApplication {
	
	private final CoffeeDao coffeeDao;
	private final UserDao userDao;
	private final RoleDao roleDao;
	private final PasswordEncoder passwordEncoder;
	
	@Bean @Transactional @Profile("dev")
	public ApplicationRunner runner() {
		
		return args-> {
			
			User user1 = new User("John Doe","johndoe@gmail.com","john",passwordEncoder.encode("12345"));
			User user2 = new User("Marry Shally","marryshally@gmail.com","marry",passwordEncoder.encode("67890"));
			
			
			Role role1 = new Role();
			role1.setName("ROLE_USER");
			Role role2 = new Role();
			role2.setName("ROLE_ADMIN");
			
			user1.addRole(role1);
			user2.addRole(role2);
			
			userDao.save(user1);
			userDao.save(user2);
			
			
			 Coffee coffee1 = new Coffee("Americano","An Americano is a simple coffee drink made by diluting a shot of espresso with hot water. This results in a beverage that has the rich, robust flavor of espresso but is less intense and more similar in strength to traditional drip coffee. It's a favorite for those who enjoy a strong coffee taste without the concentrated intensity of straight espresso. Enjoyed black or with a splash of milk, it's a versatile and popular choice in many coffee shops.","americano.jpeg",12,10);
	            Coffee coffee2 = new Coffee("Cappuchino",
	                    "A cappuccino is a popular Italian coffee drink made with equal parts espresso, steamed milk, and milk foam. The result is a rich, creamy beverage with a balanced flavor profile, usually served in a small cup. The frothy milk on top can even be used for creating latte art, adding a touch of beauty to your coffee experience. It's a perfect choice for those who enjoy a strong coffee taste with a creamy texture.","Cappuchino.png",15,10);
	            Coffee coffee3 = new Coffee("Caramel","Caramel is a rich, sweet confection made by heating sugar until it melts and browns.","Caramel.jpeg",13,10);
	            Coffee coffee4=new Coffee("Mocha","Mocha is a chocolate-flavored coffee drink, combining espresso, steamed milk, and chocolate syrup.",
	                    "Mochareal.png",14,10);
	            Coffee coffee5=new Coffee("Espresso","Espresso is a strong, concentrated coffee shot, rich and bold.",
	                    "espresso.png",11,10);
	            Coffee coffee6=new Coffee("Green Tea","Green tea is a healthy, soothing beverage made from unfermented leaves.",
	                    "greentea.png",15,10);
	            Coffee coffee7=new Coffee("Chocolate","Chocolate is a sweet treat made from cacao beans.",
	                    "Chocolate.png",12,10);
	            Coffee coffee8=new Coffee("Hot Chocolate","Hot chocolate is a warm, creamy drink with melted chocolate.",
	                    "HotChocolate.png",15,10);
	            Coffee coffee9=new Coffee("IcedFrappe","Iced frappe is a chilled, blended coffee drink with ice","IcedFrappe.png",11,10);
	            Coffee coffee10=new Coffee("Latte","Latte is espresso with steamed milk, creamy and smooth","latter.jpeg",15,10);
	            coffeeDao.save(coffee1);
	            coffeeDao.save(coffee2);
	            coffeeDao.save(coffee3);
	            coffeeDao.save(coffee4);
	            coffeeDao.save(coffee5);
	            coffeeDao.save(coffee6);
	            coffeeDao.save(coffee7);
	            coffeeDao.save(coffee8);
	            coffeeDao.save(coffee9);
	            coffeeDao.save(coffee10);

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(CoffeeShopApiApplication.class, args);
	}

}
