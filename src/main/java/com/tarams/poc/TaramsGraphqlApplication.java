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
	
//	@Bean
//	ApplicationRunner init(UserService userService) {
//		return args -> {
//			Stream.of(
//					"Sreejith: S Variyath", 
//					"Sridahr: S Panchami", 
//					"Baswa: BB Belkherikar"
//			).forEach( data -> {
//				User u = new User();
//				String[] fields = data.split(":"); 
//				u.setLogin(fields[0]);
//				u.setName(fields[1]);
//				userService.saveUser(u);
//			});
//			userService.getAllUsers().forEach(System.out::println);
//		};
//	}
	
	@Bean
	ApplicationRunner init(UserService userService) {
	return args -> {
	Stream.of(
	"studentOne:St123456:stone@gmail.com:student:one:12345678:NY"

	).forEach( data -> {
	User u = new User();
	String[] fields = data.split(":"); 
	u.setUserName(fields[0]);
	u.setPassword(fields[1]);
	u.setEmail(fields[2]);
	u.setFirstName(fields[3]);
	u.setLastName(fields[4]);
	u.setPhone(fields[5]);
	u.setCity(fields[6]);
	userService.saveUser(u);
	});
	userService.getAllUsers().forEach(System.out::println);
	};
	
	}

}
