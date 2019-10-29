package org.javasavvy.tutorial.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.javasavvy.tutorial.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("userDAO")
@Transactional(propagation=Propagation.REQUIRED)
public class UserDAOImpl implements UserDAO {
	
	
	@PersistenceContext
	public EntityManager entityManager;

	
	@Transactional(readOnly=false)
	public User addUser(User user) {
		entityManager.persist(user);
		return user;
	}

	@Transactional(readOnly=true)
	public User getUser(long userId) {
		 Query query  = entityManager.createQuery("select user from User user where user.userId=:userId");
		 query.setParameter("userId", userId);
		 return (User)query.getSingleResult();
	}

	@Transactional(readOnly=true)
	public User getUser(String email) {
		return (User) entityManager.createQuery("select user from User user where"
				+ " user.email=:email").setParameter("email", email).getSingleResult();
	}

	@Transactional(readOnly=true)
	public User getUserById(long userId) {
		
		 Query query  = entityManager.createQuery("select user from User user where user.userId=:userId");
		 query.setParameter("userId", userId);
		 return (User)query.getSingleResult();
	}
}
