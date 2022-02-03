package io.javatech.ppmtool.api.domain.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import io.javatech.ppmtool.api.domain.service.FieldValidationErrorService;

@Service
public class FieldValidationErrorServiceImpl implements FieldValidationErrorService {

	@Override
	public Map<String, String> handleFieldValidationError(BindingResult result) {
		Map<String, String> errorMap = new HashMap<>();
		for (var fieldError : result.getFieldErrors()) {
			errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return errorMap;
	}
}
