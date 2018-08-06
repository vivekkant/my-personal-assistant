package org.weekendsoft.mpa.masterdata.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.weekendsoft.mpa.masterdata.model.ErrorInfo;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	
	   @Override
	   protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
			ErrorInfo error = new ErrorInfo();
			error.setCode(ERROR_CODES.RECORD_NOT_FOUND);
			error.setMessage("Malformed JSON request");
			error.setStatus(HttpStatus.BAD_REQUEST);
			return buildResponseEntity(error);
	   }
	   
	   private ResponseEntity<Object> buildResponseEntity(ErrorInfo error) {
	       return new ResponseEntity<>(error, error.getStatus());
	   }
}
