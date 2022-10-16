package com.alex.cursomc.services.exceptions;

public class DataIntegrityException  extends RuntimeException{

	
	private static final long serialVersionUID = -7378662941721256624L;
	
	public DataIntegrityException(String msg) {
		
		super(msg);
		
	}
	
	public DataIntegrityException(String msg, Throwable cause) {
		super(msg, cause);
	}
	

}
