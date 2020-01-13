package com.dev.spring.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.spring.model.User;
import com.dev.spring.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository<User> userRepository;

	@Transactional
	public List<User> getAllUsers() {
		return (List<User>) userRepository.findAll();
	}

	@Transactional
	public List<User> findByName(String name) {
		return userRepository.findByFirstName(name);
	}

	@Transactional
	public User getById(Long id) {
		return userRepository.findOne(id);
	}

	@Transactional
	public void deleteUser(Long userId) {
		userRepository.delete(userId);
	}

	

	@Transactional
	public boolean updateUser(User user) {
		return userRepository.save(user) != null;
	}

	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	@Transactional
	public User addUser(String firstName, String lastName, String email, String sex, String password) {

		User user = new User();
		user.setCreateDate(new Date());
		user.setUpdatedDate(new Date());
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setSex(sex);
		user.setPassword(password);

		return userRepository.save(user);
	}

}
