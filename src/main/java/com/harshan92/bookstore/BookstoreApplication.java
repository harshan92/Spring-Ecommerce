package com.harshan92.bookstore;

import com.harshan92.bookstore.domain.User;
import com.harshan92.bookstore.domain.security.Role;
import com.harshan92.bookstore.domain.security.UserRole;
import com.harshan92.bookstore.service.UserService;
import com.harshan92.bookstore.utility.SecurityUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {
	@Autowired
	private UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user1=new User();
		user1.setFirstname("John");
		user1.setLastname("Doe");
		user1.setUsername("johndoe");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		user1.setEmail("johndoe@mail.com");
		Set<UserRole> userRoles=new HashSet<>();
		Role role1=new Role();
		role1.setRoleId(1);
		role1.setName("ROLE_USER");
		userRoles.add(new UserRole(user1, role1));
		userService.createUser(user1, userRoles);
	}
}
