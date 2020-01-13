package com.dev.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dev.spring.dto.ResponseDTO;
import com.dev.spring.model.Person;
import com.dev.spring.services.PersonService;

@RestController
public class PersonResource {

	@Autowired
	PersonService personService;

	@RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
	public @ResponseBody ResponseDTO getAllUsers(@PathVariable Long id) {
		return personService.getById(id);
	}

	@RequestMapping(value = "/person/aop/testing", method = RequestMethod.GET)
	public @ResponseBody Person aopTesting() {
		return personService.aopTesting();
	}

	@RequestMapping(value = "/personByName/{name}", method = RequestMethod.GET)
	public ResponseDTO getPersoneByName(@PathVariable String name) {
		return personService.findByName(name);
	}

	@RequestMapping(value = "/person", method = RequestMethod.GET)
	public ResponseDTO getAll() {
		return personService.getAllPersons();
	}

	@RequestMapping(value = "/person/{id}", method = RequestMethod.DELETE)
	public HttpStatus deletePersnone(@PathVariable Long id) {
		personService.deletePerson(id);
		return HttpStatus.NO_CONTENT;
	}

	@RequestMapping(value = "/person", method = RequestMethod.POST)
	public ResponseDTO insertPersone(@RequestBody Person person) {
		return personService.addPerson(person);
	}

	@RequestMapping(value = "/person", method = RequestMethod.PUT)
	public ResponseDTO updatePerson(@RequestBody Person person) {
		return personService.updatePerson(person);
	}
}
