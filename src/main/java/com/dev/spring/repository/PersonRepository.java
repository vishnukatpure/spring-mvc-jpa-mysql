package com.dev.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dev.spring.model.Person;

public interface PersonRepository<P> extends CrudRepository<Person, Long> {

	List<Person> findByFirstName(String firstName);
}
