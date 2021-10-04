package br.com.mattec.consul.exceptions;

public class ValidaException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ValidaException(String  msg) {
		super(msg);
	}
	
	public ValidaException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
}
