package com.swp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DeliveryNotFoundException extends RuntimeException {
	public DeliveryNotFoundException(String msg) {
		super(msg);
	}
}
