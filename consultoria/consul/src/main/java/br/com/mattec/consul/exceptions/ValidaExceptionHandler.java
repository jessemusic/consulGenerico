package br.com.mattec.consul.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import javassist.tools.rmi.ObjectNotFoundException;

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

		ValidationError err = new ValidationError(Instant.now(),HttpStatus.BAD_REQUEST.value(), "Erro no sistema!", "Erro de Validação!", request.getRequestURI());
		for(FieldError erros : e.getBindingResult().getFieldErrors()){
			err.addError(erros.getField(), erros.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<StandardError> Validation(HttpMessageNotReadableException e, HttpServletRequest request){

		String error = "Erro no sistema!";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(),status.value(), error, "Não há corpo na menssagem, não é possível fazer o upDate!", request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<StandardError> Validation(HttpRequestMethodNotSupportedException e, HttpServletRequest request){

		String error = "Erro no sistema!";
		HttpStatus status = HttpStatus.METHOD_NOT_ALLOWED;
		StandardError err = new StandardError(Instant.now(),status.value(), error, "Erro no método HTTP!", request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<StandardError> Validation(HttpClientErrorException e, HttpServletRequest request){

		String error = "Erro no sistema!";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(),status.value(), error, "Não é um cep!", request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<StandardError> Validation(ValidationException e, HttpServletRequest request){

		String error = "Erro no sistema!";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(),status.value(), error, "Opção do tipo inválida de cadastro de documentos, impossível verificar se é cpf ou cnpj!", request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<StandardError> Validation(IllegalArgumentException e, HttpServletRequest request){

		String error = "Erro no sistema!";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(),status.value(), error, "Opção do tipo inválida de cadastro de documentos", request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> Validation(ObjectNotFoundException e, HttpServletRequest request){

		String error = "Erro no sistema!";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(),status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	


	
	
	
}
