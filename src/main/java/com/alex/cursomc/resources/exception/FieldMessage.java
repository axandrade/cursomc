package com.alex.cursomc.resources.exception;

import java.io.Serializable;

public class FieldMessage implements Serializable{


	private static final long serialVersionUID = 5406223639398575499L;
	
	private String fieldName;
	private String message;
	
	public FieldMessage() {
	}

	public FieldMessage(String fieldName, String message) {
		super();
		this.setFieldName(fieldName);
		this.setMessage(message);
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
