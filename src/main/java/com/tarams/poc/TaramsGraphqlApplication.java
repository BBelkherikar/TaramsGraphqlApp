package com.tarams.poc;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TaramsGraphqlApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(TaramsGraphqlApplication.class, args);
	}
	
	@Bean
	ApplicationRunner init(UserService userService) {
		return args -> {
			Stream.of(
					"student1:Student 11", 
					"student2:student 22", 
					"student3:ss 33"
			).forEach( data -> {
				User u = new User();
				String[] fields = data.split(":"); 
				u.setLogin(fields[0]);
				u.setName(fields[1]);
				userService.saveUser(u);
			});
			userService.getAllUsers().forEach(System.out::println);
		};
	}

}
