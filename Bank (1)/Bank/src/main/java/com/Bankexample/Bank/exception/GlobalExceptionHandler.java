package com.Bankexample.Bank.exception;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

	@ExceptionHandler(AccountCreateException.class)
	public ErrorMessage accountCreateException(Exception e) {
		return new ErrorMessage(HttpStatus.BAD_REQUEST, e.getMessage());
	}

	@ExceptionHandler(AccountReadException.class)
	public ErrorMessage accountReadException(Exception e) {
		return new ErrorMessage(HttpStatus.BAD_REQUEST, e.getMessage());
	}

	@ExceptionHandler(AccountUpdateException.class)
	public ErrorMessage accountUpdateException(Exception e) {
		return new ErrorMessage(HttpStatus.BAD_REQUEST, e.getMessage());
	}

	@ExceptionHandler(AccountDeleteException.class)
	public ErrorMessage accountDeleteException(Exception e) {
		return new ErrorMessage(HttpStatus.BAD_REQUEST, e.getMessage());
	}
	
	@ExceptionHandler(CustomerReadException.class)
	public ErrorMessage customertReadException(Exception e) {
		return new ErrorMessage(HttpStatus.BAD_REQUEST, e.getMessage());
	}
}