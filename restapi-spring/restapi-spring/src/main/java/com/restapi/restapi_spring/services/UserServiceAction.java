package com.restapi.restapi_spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.restapi_spring.entity.User;
import com.restapi.restapi_spring.repository.UserRepository;

@Service
public class UserServiceAction implements UserService {

	private UserRepository userRepository;
	
	@Autowired
	public UserServiceAction(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User findById(Integer id) {
//		With Optional contain isPresent() ที่เอาไว้เป็นทางเลือกเพื่อบอกว่ามีอยู่หรือไม่มี
		Optional<User> result =  userRepository.findById(id);
		User data = null;
		if(result.isPresent()) {
			data = result.get();
		} else {
			throw new RuntimeException("ไม่พบข้อมูลรหัสผู้ใช้"+id);
		}
		return data;
	}

	@Override
	public void deleteById(Integer id) {
		userRepository.deleteById(id);
	}


}
