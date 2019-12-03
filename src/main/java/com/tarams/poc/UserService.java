package com.tarams.poc;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service 
@Transactional
public class UserService {
	
private UserRepository store ;
	
	public UserService(UserRepository db) {
		this.store = db ;
	}
	
	public List<User> getAllUsers() {
		return this.store.findAll();
	}
	
	public Optional<User> getUser(int id) {
		return this.store.findById(id);
	}
	
	public List<User> getUsers(int first, int last) {
		if ((last == 0) || (last < first)) {
			// Ignore last if invalid value was specified
			last = (int) this.store.count();
		}
		return this.store.findAllById(
			IntStream.rangeClosed(first, last)
			.boxed()
			.collect(Collectors.toList())
		);
	}
	
//	public User newUser(String login, String name) {
//		User u = new User();
//		u.setLogin(login);
//		u.setName(name);
//		return this.store.save(u);
//	}
	
	public User updateUser(int id , String userName, String password, String email, String firstName, String lastName, String phone, String city) {
		User u = new User();
		u.setId(id);
		u.setUserName(userName);
		u.setPassword(password);
		u.setEmail(email);
		u.setFirstName(firstName);
		u.setLastName(lastName);
		u.setPhone(phone);
		u.setCity(city);
		return this.store.save(u);
		} 
	
	
		public User newUser(String userName, String password, String email, String firstName, String lastName, String phone, String city) {
		System.out.println("Am In New user serive" + userName);
	    User u = new User();
        int newUserid= u.getId();
        u.setId(newUserid);
		u.setUserName(userName);
		u.setPassword(password);
		u.setEmail(email);
		u.setFirstName(firstName);
		u.setLastName(lastName);
		u.setPhone(phone);
		u.setCity(city);
		System.out.println("New user object for create= " +u.toString());
		return this.store.save(u);
		}
	
	public User saveUser(User user) {
		return this.store.save(user);
	}
	
	public void deleteUser(int id) {
		this.store.deleteById(id);
	}

}
