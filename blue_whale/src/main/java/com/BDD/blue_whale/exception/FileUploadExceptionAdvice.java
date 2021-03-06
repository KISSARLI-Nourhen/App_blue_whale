package com.BDD.blue_whale.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.BDD.blue_whale.message.ResponseMessage;

@ControllerAdvice
public class FileUploadExceptionAdvice extends ResponseEntityExceptionHandler  {
	
	@ExceptionHandler(MaxUploadSizeExceededException.class)
	  public ResponseEntity<ResponseMessage> handleMaxSizeException(MaxUploadSizeExceededException exc) {
	    return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage("File too large!"));
	  }
	
	@ExceptionHandler(ErrorFileException.class)
	public ResponseEntity<ResponseMessage> exceptionFile(ErrorFileException exception) {
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("Your file is not a valid document!"));
	  }
}
