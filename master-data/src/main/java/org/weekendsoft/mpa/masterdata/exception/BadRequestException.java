package org.weekendsoft.mpa.masterdata.exception;

public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public String message;
	
	public BadRequestException(String message, Exception parent) {
		super(message, parent);
		this.message = message;
	}
	
}
