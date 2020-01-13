package com.dev.spring.repository.generic;

import org.springframework.data.repository.CrudRepository;

public interface GenericRepository<T> extends CrudRepository<T, Long> {

}
