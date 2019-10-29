package org.javasavvy.rest.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.javasavvy.rest.modal.UserModal;
import org.javasavvy.rest.modal.UserStatusModal;
import org.javasavvy.tutorial.entity.User;
import org.javasavvy.tutorial.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Path("/user")
public class UserRestResource {

	
	@Autowired(required=true)
	@Qualifier("userService")
	private UserService userService;
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/user-json-meta")
	public UserModal getUser(){
		
		UserModal userModal = new UserModal();
		userModal.setEmail("jajfaddf");
		userModal.setFirstName("jayaram");
		userModal.setLastName("poks");
		userModal.setPassword("passwd");
		userModal.setSex("male");
		userModal.setUserId(101);
		return userModal;
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/user-info/{userId}")
	public UserStatusModal getUser(@PathParam("userId") long userId){
		
		System.out.println("user-info:userId"+userId);
		
		UserStatusModal userStatus = new UserStatusModal();
		User user = userService.getUser(userId);
		UserModal userModal = new UserModal();
		if(user!=null){
			userStatus.setStatus(200);
			userStatus.setMessage("User info");
			userModal.setEmail(user.getEmail());
			userModal.setFirstName(user.getFirstName());
			userModal.setLastName(user.getLastName());
			userModal.setSex(user.getSex());
			userModal.setUserId(userId);
			userStatus.setUser(userModal);
		}else{
			userStatus.setStatus(205);
			userStatus.setMessage("User info");
		}
		return userStatus;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/create-user")
	public UserStatusModal createUser(UserModal userModal){
		System.out.println("create User:"+userModal.getEmail());
		User user = null;
		UserStatusModal status = new UserStatusModal();
		try{
			 user = userService.addUser(userModal.getFirstName(), userModal.getLastName(), userModal.getEmail(), userModal.getSex(), userModal.getPassword());
			 userModal.setEmail(user.getEmail());
				userModal.setFirstName(user.getFirstName());
				userModal.setLastName(user.getLastName());
				userModal.setSex(user.getSex());
				userModal.setUserId(user.getUserId());
				status.setUser(userModal);
			 status.setMessage("User Created Successfully");
			
		}catch(Exception e){
			status.setStatus(205);
			 status.setMessage("Error in Creating users:"+e.getMessage());
		}
		
		
		
		return status;
		
	}
	
}
