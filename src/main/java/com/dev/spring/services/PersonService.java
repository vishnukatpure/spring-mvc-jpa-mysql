package com.dev.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.spring.dto.PersonDTO;
import com.dev.spring.dto.ResponseDTO;
import com.dev.spring.model.Person;
import com.dev.spring.repository.PersonRepository;
import com.dev.spring.services.generic.GenericCRUDService;

@Service
public class PersonService extends GenericCRUDService {

	@Autowired
	PersonRepository personRepository;

	@Transactional
	public ResponseDTO getAllPersons() {
		List<PersonDTO> dto = new ArrayList<>();
		personRepository.findAll().forEach(ob -> dto.add(modelMapper.map(ob, PersonDTO.class)));

		return bindResponse(dto);
	}

	@Transactional
	public ResponseDTO findByName(String name) {
		List<PersonDTO> dto = new ArrayList<>();
		personRepository.findByFirstName(name).forEach(ob -> dto.add(modelMapper.map(ob, PersonDTO.class)));
		return bindResponse(dto);
	}

	@Transactional
	public ResponseDTO getById(Long id) {
		return bindResponse(modelMapper.map(personRepository.findById(id).get(), PersonDTO.class));
	}

	@Transactional
	public void deletePerson(Long personId) {
		personRepository.deleteById(personId);
	}

	@Transactional
	public ResponseDTO addPerson(PersonDTO personDto) {
		Person person = modelMapper.map(personDto, Person.class);
		return bindResponse(modelMapper.map(personRepository.save(person), PersonDTO.class));
	}

	@Transactional
	public ResponseDTO updatePerson(PersonDTO personDto) {
		Person person = modelMapper.map(personDto, Person.class);
		person.setFirstName("");
		return bindResponse(modelMapper.map(personRepository.save(person), PersonDTO.class));
	}

	public Person aopTesting() {
		throw new NullPointerException("in AOP runtime exception");
	}
}
