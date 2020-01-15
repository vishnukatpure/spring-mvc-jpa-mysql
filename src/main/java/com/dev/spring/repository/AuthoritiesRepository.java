package com.dev.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.dev.spring.model.Authorities;

public interface AuthoritiesRepository extends CrudRepository<Authorities, Long> {

}
