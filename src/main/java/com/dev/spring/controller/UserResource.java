package com.dev.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dev.spring.dto.UserDTO;
import com.dev.spring.dto.UserStatusDTO;
import com.dev.spring.model.User;
import com.dev.spring.services.UserService;

@RestController
public class UserResource {

	@Autowired(required = true)
	@Qualifier("userService")
	private UserService userService;

	@RequestMapping(value = { "/user-json-meta" }, method = RequestMethod.GET)
	public UserDTO getUser() {
		UserDTO UserDTO = new UserDTO();
		UserDTO.setEmail("jajfaddf");
		UserDTO.setFirstName("jayaram");
		UserDTO.setLastName("poks");
		UserDTO.setPassword("passwd");
		UserDTO.setSex("male");
		UserDTO.setUserId("101");
		return UserDTO;
	}

	@RequestMapping(value = { "/user-info/{userId}" }, method = RequestMethod.GET)
	public UserStatusDTO getUser(@PathVariable("userId") String userId) {

		System.out.println("user-info:userId" + userId);

		UserStatusDTO userStatus = new UserStatusDTO();
		User user = userService.findByUsername(userId);
		UserDTO UserDTO = new UserDTO();
		if (user != null) {
			userStatus.setStatus(200);
			userStatus.setMessage("User info");
			UserDTO.setEmail(user.getEmail());
			UserDTO.setFirstName(user.getFirstName());
			UserDTO.setLastName(user.getLastName());
			UserDTO.setSex(user.getSex());
			UserDTO.setUserId(userId);
			userStatus.setUser(UserDTO);
		} else {
			userStatus.setStatus(205);
			userStatus.setMessage("User info");
		}
		return userStatus;
	}

	@RequestMapping(value = { "/create-user" }, method = RequestMethod.POST)
	public UserStatusDTO createUser(@RequestBody UserDTO UserDTO) {
		System.out.println("create User:" + UserDTO.getEmail());
		User user = null;
		UserStatusDTO status = new UserStatusDTO();
		try {
			user = userService.addUser(UserDTO.getFirstName(), UserDTO.getLastName(), UserDTO.getEmail(),
					UserDTO.getSex(), UserDTO.getPassword());
			UserDTO.setEmail(user.getEmail());
			UserDTO.setFirstName(user.getFirstName());
			UserDTO.setLastName(user.getLastName());
			UserDTO.setSex(user.getSex());
			UserDTO.setUserId(user.getUsername());
			status.setUser(UserDTO);
			status.setMessage("User Created Successfully");

		} catch (Exception e) {
			status.setStatus(205);
			status.setMessage("Error in Creating users:" + e.getMessage());
		}

		return status;

	}

}
