package com.ecommercedemo.productservice.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ExceptionResponse {

	private ExceptionCode code;
	
	private HttpStatus status;
	
	private String message;
	
	private Date timestamp;
	
	public ExceptionResponse() {
	}

	public ExceptionResponse(ExceptionCode code, HttpStatus status, String message) {
		super();
		this.code = code;
		this.status = status;
		this.message = message;
		this.timestamp = new Date();
	}

	public ExceptionCode getCode() {
		return code;
	}

	public void setCode(ExceptionCode code) {
		this.code = code;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
}
