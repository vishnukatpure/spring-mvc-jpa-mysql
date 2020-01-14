package com.dev.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dev.spring.dto.UserDTO;
import com.dev.spring.dto.UserStatusDTO;
import com.dev.spring.model.User;
import com.dev.spring.services.UserService;

@RestController
public class UserResource {

	@Autowired
	private UserService userService;

	@GetMapping(value = { "/user-json-meta" })
	public UserDTO getUser() {
		UserDTO userDTO = new UserDTO();
		userDTO.setEmail("jajfaddf");
		userDTO.setFirstName("jayaram");
		userDTO.setLastName("poks");
		userDTO.setPassword("passwd");
		userDTO.setSex("male");
		userDTO.setUserId("101");
		return userDTO;
	}

	@GetMapping(value = { "/user-info/{userId}" })
	public UserStatusDTO getUser(@PathVariable("userId") String userId) {

		UserStatusDTO userStatus = new UserStatusDTO();
		User user = userService.findByUsername(userId);
		UserDTO userDTO = new UserDTO();
		if (user != null) {
			userStatus.setStatus(200);
			userStatus.setMessage("User info");
			userDTO.setEmail(user.getEmail());
			userDTO.setFirstName(user.getFirstName());
			userDTO.setLastName(user.getLastName());
			userDTO.setSex(user.getSex());
			userDTO.setUserId(userId);
			userStatus.setUser(userDTO);
		} else {
			userStatus.setStatus(205);
			userStatus.setMessage("User info");
		}
		return userStatus;
	}

	@PostMapping(value = { "/create-user" })
	public UserStatusDTO createUser(@RequestBody UserDTO userDTO) {
		UserStatusDTO status = new UserStatusDTO();
		try {
			User user = userService.addUser(userDTO.getFirstName(), userDTO.getLastName(), userDTO.getEmail(),
					userDTO.getSex(), userDTO.getPassword());
			userDTO.setUserId(user.getUsername());
			status.setUser(userDTO);
			status.setMessage("User Created Successfully");

		} catch (Exception e) {
			status.setStatus(205);
			status.setMessage("Error in Creating users:" + e.getMessage());
		}

		return status;

	}

}
