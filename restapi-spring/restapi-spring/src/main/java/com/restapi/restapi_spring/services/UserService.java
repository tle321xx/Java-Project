package com.restapi.restapi_spring.services;

import java.util.List;

import com.restapi.restapi_spring.entity.User;

public interface UserService {
	User save(User user);
	List<User> findAll();
	User findById(Integer id);
	void deleteById(Integer id);
}
