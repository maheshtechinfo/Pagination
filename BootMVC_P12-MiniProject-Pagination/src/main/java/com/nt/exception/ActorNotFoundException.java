package com.nt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_GATEWAY)
public class ActorNotFoundException extends RuntimeException {

	public ActorNotFoundException() {
		super();
	}

	public ActorNotFoundException(String msg) {
		super(msg);
	}
}
