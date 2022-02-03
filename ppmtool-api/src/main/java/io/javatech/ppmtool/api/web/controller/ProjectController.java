package io.javatech.ppmtool.api.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javatech.ppmtool.api.domain.model.Project;
import io.javatech.ppmtool.api.domain.service.FieldValidationErrorService;
import io.javatech.ppmtool.api.domain.service.ProjectService;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@Autowired
	private FieldValidationErrorService fieldValidationErrorService;

	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody Project project, BindingResult result) {
		if (result.hasErrors()) {
			return new ResponseEntity<>(this.fieldValidationErrorService.handleFieldValidationError(result),
					HttpStatus.BAD_REQUEST);
		}
		project = this.projectService.saveOrUpdate(project);
		return new ResponseEntity<>(project, HttpStatus.CREATED);
	}
	
	@GetMapping("/{code}")
	public ResponseEntity<?> findOne(@PathVariable("code") String code) {
		return ResponseEntity.ok(this.projectService.findByCode(code));
	}
	
	@GetMapping
	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok(this.projectService.findAll());
	}
	
	@DeleteMapping("/{code}")
	public ResponseEntity<?> deleteOne(@PathVariable("code") String code) {
		this.projectService.deleteByCode(code);
		return ResponseEntity.noContent().build();
	}
}
