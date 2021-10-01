package br.com.mattec.consul.controller.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.mattec.consul.service.exception.ValidaException;

@ControllerAdvice
public class ValidaExceptionHandler {
	
	@ExceptionHandler(ValidaException.class)
	public ResponseEntity<StandardError> ValidaException(ValidaException e, HttpServletRequest request){
		
		String error = "Erro no sistema!";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(),status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> Validation(MethodArgumentNotValidException e, HttpServletRequest request){
		
		String error = "Erro no sistema!";

		ValidationError err = new ValidationError(Instant.now(),HttpStatus.BAD_REQUEST.value(), "Erro no sistema!", "Erro de Validação!", request.getRequestURI());
		for(FieldError erros : e.getBindingResult().getFieldErrors()){
			err.addError(erros.getField(), erros.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}

	
	
	
}
