package com.muktai.exhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CommonCustomExceptionHandler
{
	@ExceptionHandler(PersonNotFoundException.class)
	public ResponseEntity<String> handlePersonNotFoundException(PersonNotFoundException e)
	{
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
}
