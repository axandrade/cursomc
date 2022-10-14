package com.alex.cursomc.services.exceptions;

public class ObjectNotFoundException  extends RuntimeException{

	
	private static final long serialVersionUID = -7378662941721256624L;
	
	public ObjectNotFoundException(String msg) {
		
		super(msg);
		
	}
	
	public ObjectNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}
	

}
