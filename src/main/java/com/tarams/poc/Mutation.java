package com.tarams.poc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;


@Component
public class Mutation implements GraphQLMutationResolver {
	
	@Autowired
	private UserService userService;

//	public User createUser(String login, String name) {
//		return this.userService.newUser(login, name);
//	}
	
	
	public User createUser(String userName, String password, String email, String firstName, String lastName, String phone, String city) {
		return this.userService.newUser(userName, password, email, firstName, lastName, phone, city);
		}
	
	public User updateUser(int id , String userName, String password, String email, String firstName, String lastName, String phone, String city) {
		return this.userService.updateUser(id, userName, password, email, firstName, lastName, phone, city);
		}

}
