package br.com.mattec.consul.exceptions;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
	private static final long serialVersionUID = 1L;
	private List<FieldMessageCustom> errors = new ArrayList<>();
	
	public ValidationError(Instant now, int value, String error, String message, String requestURI) {
	}

	public List<FieldMessageCustom> getErrors() {
		return errors;
	}
	public void addError(String fieldName, String message) {
		errors.add(new FieldMessageCustom(fieldName, message));
	}

}
