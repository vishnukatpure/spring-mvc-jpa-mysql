package com.dev.spring.repository;

import org.springframework.data.repository.CrudRepository;

public interface AuthoritiesRepository<P> extends CrudRepository<P, Long> {

}
