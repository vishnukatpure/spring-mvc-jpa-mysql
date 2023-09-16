package com.dev.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.spring.model.Authorities;
import com.dev.spring.repository.AuthoritiesRepository;

@Service
public class AuthoritiesService {

	@Autowired
	AuthoritiesRepository authoritiesRepository;

	@Transactional
	public List<Authorities> getAllAuthoritiess() {
		return (List<Authorities>) authoritiesRepository.findAll();
	}

	@Transactional
	public Authorities getById(Long id) {
		return authoritiesRepository.findById(id).get();
	}

	@Transactional
	public void deleteAuthorities(Long authoritiesId) {
		authoritiesRepository.deleteById(authoritiesId);
	}

	@Transactional
	public boolean addAuthorities(Authorities authorities) {
		return authoritiesRepository.save(authorities) != null;
	}

	@Transactional
	public boolean updateAuthorities(Authorities authorities) {
		return authoritiesRepository.save(authorities) != null;
	}
}
