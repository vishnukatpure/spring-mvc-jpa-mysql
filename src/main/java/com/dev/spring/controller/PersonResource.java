package com.dev.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dev.spring.dto.PersonDTO;
import com.dev.spring.dto.ResponseDTO;
import com.dev.spring.model.Person;
import com.dev.spring.services.PersonService;

@RestController
public class PersonResource {

	@Autowired
	PersonService personService;

	@GetMapping(value = "/person/{id}")
	public @ResponseBody ResponseDTO getAllUsers(@PathVariable Long id) {
		return personService.getById(id);
	}

	@GetMapping(value = "/person/aop/testing")
	public @ResponseBody Person aopTesting() {
		return personService.aopTesting();
	}

	@GetMapping(value = "/personByName/{name}")
	public ResponseDTO getPersoneByName(@PathVariable String name) {
		return personService.findByName(name);
	}

	@GetMapping(value = "/person")
	public ResponseDTO getAll() {
		return personService.getAllPersons();
	}

	@DeleteMapping(value = "/person/{id}")
	public HttpStatus deletePerson(@PathVariable Long id) {
		personService.deletePerson(id);
		return HttpStatus.NO_CONTENT;
	}

	@PostMapping(value = "/person")
	public ResponseDTO insertPersone(@RequestBody PersonDTO person) {
		return personService.addPerson(person);
	}

	@PutMapping(value = "/person")
	public ResponseDTO updatePerson(@RequestBody PersonDTO personDto) {
		return personService.updatePerson(personDto);
	}
}
