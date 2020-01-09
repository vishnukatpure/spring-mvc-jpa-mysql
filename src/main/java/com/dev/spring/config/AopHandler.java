package com.dev.spring.config;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AopHandler {

	@AfterThrowing(pointcut = "execution(* com.dev.spring.services.*.*(..))", throwing = "ex")
	private void afterThrow(Exception ex) {
		System.out.println("in AfterThrowing");
		System.out.println(ex.getMessage());
	}
}
