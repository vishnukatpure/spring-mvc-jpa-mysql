package com.dev.spring.repository;

import java.util.List;

import com.dev.spring.model.Person;
import com.dev.spring.repository.generic.GenericRepository;

public interface PersonRepository<P> extends GenericRepository<P> {
	List<Person> findByFirstName(String firstName);
}
