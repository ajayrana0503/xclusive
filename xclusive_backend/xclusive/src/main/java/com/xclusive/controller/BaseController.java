package com.xclusive.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import com.xclusive.response.ResponseWrapper;

public class BaseController {

	protected <T> ResponseEntity<ResponseWrapper<T>> wrapResponse(T output, HttpStatus httpStatus,
			String description){
		String status= Integer.toString(httpStatus.value());
		return new ResponseEntity<ResponseWrapper<T>>(new ResponseWrapper<T>(output,
				status,description),httpStatus);
	}
	
}
