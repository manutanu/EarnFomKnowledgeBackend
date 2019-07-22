package com.KnowledgeQuizApp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.KnowledgeQuizApp.exceptions.TestException;
import com.KnowledgeQuizApp.model.ErrorMessage;

@ControllerAdvice
@CrossOrigin({"http://localhost:4200"})
public class ExceptionHandlingController {

	@PreAuthorize("hasAnyRole('ADMIN')")
	@ExceptionHandler(TestException.class)
	@ResponseStatus(code =HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorMessage testExceptionMethod(HttpServletRequest request,Exception ex) {
		ErrorMessage error=new ErrorMessage(ex.getMessage(),HttpStatus.BAD_REQUEST.value(),request.getRequestURI());
		return error;
	}
}
