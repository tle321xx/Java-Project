package com.restapi.restapi_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.restapi_spring.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
