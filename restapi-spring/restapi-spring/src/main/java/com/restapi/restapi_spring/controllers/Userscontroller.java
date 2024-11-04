package com.restapi.restapi_spring.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.restapi_spring.entity.User;
import com.restapi.restapi_spring.repository.UserRepository;
import com.restapi.restapi_spring.services.UserService;
import com.restapi.restapi_spring.services.UserServiceAction;

@RestController
@RequestMapping("/api")
public class Userscontroller {
	private UserService userService;

	@Autowired
	public Userscontroller(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/users")
	public User addUser(@RequestBody User user) {
		user.setId(0); 
		return userService.save(user);
	}
	
	@GetMapping("/getAllUser")
	public List<User> getAllUser(@RequestBody User user) {
		return userService.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable int id) {
		User result = userService.findById(id);
		if(result == null) {
			throw new RuntimeException("ไม่พบข้อมูลรหัสผู้ใช้"+id);
		}
		return result;
	}
	
	@DeleteMapping("/users/{id}")
	public String deleteUser(@PathVariable int id) {
		User result = userService.findById(id);
		if(result == null) {
			throw new RuntimeException("ไม่พบข้อมูลรหัสผู้ใช้"+id);
		}
		userService.deleteById(id);
		return "Delete Successfully " + id;
	}
	
	@PutMapping("/users")
	public User updateUser(@RequestBody User user) {
		return userService.save(user);
	}
	
	
//	@GetMapping("users")
//	public List<User> getUsers() {
//		List<User> data = new ArrayList();
//		data.add(new User("title","vachi"));
//		data.add(new User("title2","vachi"));
//		return data;
//	}
//	
//	@GetMapping("about")
//	public String getAbout() {
//		return "About About About About About About";
//	}
}
