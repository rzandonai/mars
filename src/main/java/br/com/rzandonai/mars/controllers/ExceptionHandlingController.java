package br.com.rzandonai.mars.controllers;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rzandonai.mars.dtos.ErrorDTO;
import br.com.rzandonai.mars.exceptions.MovimentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlingController extends ResponseEntityExceptionHandler {
	Logger logger = LoggerFactory.getLogger(ExceptionHandlingController.class);

	@ExceptionHandler(MovimentException.class)
	public void handleError(HttpServletResponse response, HttpServletRequest req, MovimentException ex) throws IOException {
		logger.error("Request: " + req.getRequestURL() + " raised " + ex);
		ErrorDTO error = new ErrorDTO();
		error.setMessage(ex.getMessage());
		error.setGuidance(ex.getGuidance());
		response.sendError(HttpStatus.BAD_REQUEST.value(),error.toString());
	}
}
