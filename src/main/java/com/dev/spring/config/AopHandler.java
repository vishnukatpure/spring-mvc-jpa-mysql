package com.dev.spring.config;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import com.dev.spring.dto.ResponseDTO;
import com.dev.spring.enums.StatusEnum;

@Aspect
@Configuration
public class AopHandler {

	@AfterThrowing(pointcut = "execution(* com.dev.spring.services.*.*(..))", throwing = "ex")
	private ResponseDTO afterThrow(Exception ex) {
		return new ResponseDTO().message(ex.getMessage()).object(null).status(StatusEnum.EXCEPTION_OCCIRED);
	}
}
