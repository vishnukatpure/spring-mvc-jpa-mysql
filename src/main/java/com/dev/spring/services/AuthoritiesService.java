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
	AuthoritiesRepository<Authorities> authoritiesRepository;

	@Transactional
	public List<Authorities> getAllAuthoritiess() {
		return (List<Authorities>) authoritiesRepository.findAll();
	}

	@Transactional
	public Authorities getById(Long id) {
		return authoritiesRepository.findOne(id);
	}

	@Transactional
	public void deleteAuthorities(Long AuthoritiesId) {
		authoritiesRepository.delete(AuthoritiesId);
	}

	@Transactional
	public boolean addAuthorities(Authorities Authorities) {
		return authoritiesRepository.save(Authorities) != null;
	}

	@Transactional
	public boolean updateAuthorities(Authorities Authorities) {
		return authoritiesRepository.save(Authorities) != null;
	}
}
