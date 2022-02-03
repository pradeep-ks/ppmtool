package io.javatech.ppmtool.api.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NonUniqueValueException extends RuntimeException {

	private static final long serialVersionUID = 559378716850449482L;

	public NonUniqueValueException(String message, Throwable cause) {
		super(message, cause);
	}

	public NonUniqueValueException(String message) {
		super(message);
	}
}
