package com.mphasis.ocs.exceptions;

public class BusinessException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;
	public BusinessException(String message) {
		super(message);
	}
}
