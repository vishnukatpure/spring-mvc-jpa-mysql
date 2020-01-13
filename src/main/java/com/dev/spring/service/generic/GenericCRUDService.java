package com.dev.spring.service.generic;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.dev.spring.dto.ResponseDTO;
import com.dev.spring.enums.StatusEnum;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class GenericCRUDService {

	@Autowired
	public ObjectMapper mapper;

	@Autowired
	public ModelMapper modelMapper;

	public ResponseDTO bindResponse(Object dto) {
		return new ResponseDTO().message("Success").object(dto).status(StatusEnum.SUCCESS);
	}
}
