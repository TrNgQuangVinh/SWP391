package com.swp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CertificateNotFoundException extends RuntimeException {
	public CertificateNotFoundException(String msg) {
		super(msg);
	}
}
