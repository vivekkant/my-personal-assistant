package org.weekendsoft.mpa.masterdata.exception;

public class RecordNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public int id;
	public String message;
	
	public RecordNotFoundException(int id, String message, Exception parent) {
		super(message, parent);
		this.id = id;
		this.message = message;
	}
	
}
