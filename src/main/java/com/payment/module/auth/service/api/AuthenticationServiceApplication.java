package com.payment.module.auth.service.api;

import com.payment.module.auth.service.api.entity.User;
import com.payment.module.auth.service.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class AuthenticationServiceApplication {

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	public void initUser(){
		List<User> userList = Stream.of(new User(101,"venkat", "password", "venkat@gmail.com"),
				new User(102,"sekar", "password", "sekar@gmail.com")).collect(Collectors.toList());
		userRepository.saveAll(userList);
	}

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationServiceApplication.class, args);
	}

}
