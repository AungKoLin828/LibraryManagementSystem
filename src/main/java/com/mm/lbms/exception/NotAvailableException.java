package com.mm.lbms.exception;

import org.springframework.http.HttpStatus;

public class NotAvailableException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final String errorMessage;
	
    private final HttpStatus errorCode;
    
    public NotAvailableException(String errorMessage, HttpStatus errorCode) {
    	
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

	public String getErrorMessage() {
		return errorMessage;
	}

	public HttpStatus getErrorCode() {
		return errorCode;
	}
}
