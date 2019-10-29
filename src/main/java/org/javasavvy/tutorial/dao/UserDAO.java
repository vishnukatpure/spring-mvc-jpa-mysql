package org.javasavvy.tutorial.dao;

import org.javasavvy.tutorial.entity.User;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public interface UserDAO {

	
	public User addUser(User user);
	public User getUser(long userId);
	public User getUser(String email);
}
