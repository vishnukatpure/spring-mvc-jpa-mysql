package com.dev.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dev.spring.dto.UserModal;
import com.dev.spring.dto.UserStatusModal;
import com.dev.spring.model.User;
import com.dev.spring.services.UserService;

@RestController
public class UserRestResource {

	@Autowired(required = true)
	@Qualifier("userService")
	private UserService userService;

	@RequestMapping(value = { "/user-json-meta" }, method = RequestMethod.GET)
	public UserModal getUser() {

		UserModal userModal = new UserModal();
		userModal.setEmail("jajfaddf");
		userModal.setFirstName("jayaram");
		userModal.setLastName("poks");
		userModal.setPassword("passwd");
		userModal.setSex("male");
		userModal.setUserId("101");
		return userModal;
	}

	@RequestMapping(value = { "/user-info/{userId}" }, method = RequestMethod.GET)
	public UserStatusModal getUser(@PathVariable("userId") String userId) {

		System.out.println("user-info:userId" + userId);

		UserStatusModal userStatus = new UserStatusModal();
		User user = userService.findByUsername(userId);
		UserModal userModal = new UserModal();
		if (user != null) {
			userStatus.setStatus(200);
			userStatus.setMessage("User info");
			userModal.setEmail(user.getEmail());
			userModal.setFirstName(user.getFirstName());
			userModal.setLastName(user.getLastName());
			userModal.setSex(user.getSex());
			userModal.setUserId(userId);
			userStatus.setUser(userModal);
		} else {
			userStatus.setStatus(205);
			userStatus.setMessage("User info");
		}
		return userStatus;
	}

	@RequestMapping(value = { "/create-user" }, method = RequestMethod.POST)
	public UserStatusModal createUser(@RequestBody UserModal userModal) {
		System.out.println("create User:" + userModal.getEmail());
		User user = null;
		UserStatusModal status = new UserStatusModal();
		try {
			user = userService.addUser(userModal.getFirstName(), userModal.getLastName(), userModal.getEmail(),
					userModal.getSex(), userModal.getPassword());
			userModal.setEmail(user.getEmail());
			userModal.setFirstName(user.getFirstName());
			userModal.setLastName(user.getLastName());
			userModal.setSex(user.getSex());
			userModal.setUserId(user.getUsername());
			status.setUser(userModal);
			status.setMessage("User Created Successfully");

		} catch (Exception e) {
			status.setStatus(205);
			status.setMessage("Error in Creating users:" + e.getMessage());
		}

		return status;

	}

}
