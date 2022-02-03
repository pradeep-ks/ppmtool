package io.javatech.ppmtool.api.domain.service;

import java.util.Map;

import org.springframework.validation.BindingResult;

public interface FieldValidationErrorService {

	Map<String, String> handleFieldValidationError(BindingResult result);

}
