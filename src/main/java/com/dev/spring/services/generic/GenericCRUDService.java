package com.dev.spring.services.generic;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.dev.spring.dto.ResponseDTO;
import com.dev.spring.enums.StatusEnum;

@Service
public abstract class GenericCRUDService {

	public ModelMapper modelMapper = new ModelMapper();

	public ResponseDTO bindResponse(Object dto) {
		return new ResponseDTO().message("Success").object(dto).status(StatusEnum.SUCCESS);
	}

}