package com.dev.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dev.spring.model.User;

public interface UserRepository<P> extends CrudRepository<User, Long> {
	
	List<User> findByFirstName(String firstName);

	User findByUsername(String username);
}
