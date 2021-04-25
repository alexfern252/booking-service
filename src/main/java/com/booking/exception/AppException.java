/**
 * @(#) AppException.java
 */
package com.booking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class AppException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new exception with the specified detail message.
	 * 
	 * @param message
	 *            - the detail message. The detail message is saved for later
	 *            retrieval.
	 */
	public AppException(String message) {
		super(message);
	}

	/**
	 * Constructs a new exception with the specified detail message and the cause
	 * exception.
	 * 
	 * @param message
	 *            - the detail message. The detail message is saved for later
	 *            retrieval
	 * @param cause
	 *            - the cause (which is saved for later retrieval). A null value is
	 *            permitted, indicating that the cause is unknown.
	 */
	public AppException(String message, Throwable cause) {
		super(message, cause);
	}
}