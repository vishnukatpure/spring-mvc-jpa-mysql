package org.javasavvy.tutorial.services;

import org.javasavvy.tutorial.entity.User;
import org.springframework.stereotype.Service;


public interface UserService {
	
	
	public User getUser(long userId);
	public User getUser(String email);
	public User addUser(String firstName,String lastName,String email,String sex,String password);

}
