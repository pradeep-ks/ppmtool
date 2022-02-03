package io.javatech.ppmtool.api.web.controller.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import io.javatech.ppmtool.api.domain.exception.NonUniqueValueException;
import io.javatech.ppmtool.api.domain.exception.ResourceNotFoundException;
import io.javatech.ppmtool.api.web.dto.response.ApiResponseDTO;

@RestController
@ControllerAdvice
public class ErrorController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NonUniqueValueException.class)
	public ResponseEntity<ApiResponseDTO> handleNonUniqueValueException(NonUniqueValueException exception,
			WebRequest request) {
		ApiResponseDTO responseDTO = new ApiResponseDTO();
		responseDTO.setSuccess(false);
		responseDTO.setMessage(exception.getMessage());
		return ResponseEntity.badRequest().body(responseDTO);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponseDTO> handleResourceNotFoundException(ResourceNotFoundException exception,
			WebRequest request) {
		ApiResponseDTO responseDTO = new ApiResponseDTO();
		responseDTO.setMessage(exception.getMessage());
		return ResponseEntity.badRequest().body(responseDTO);
	}
}
