package com.dev.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.dev.spring.model.Person;

import java.util.List;

public interface PersonRepository<P> extends CrudRepository<Person, Long> {
    List<Person> findByFirstName(String firstName);
}
