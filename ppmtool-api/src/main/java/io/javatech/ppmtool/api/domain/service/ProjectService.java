package io.javatech.ppmtool.api.domain.service;

import java.util.List;

import io.javatech.ppmtool.api.domain.model.Project;

public interface ProjectService {

	Project saveOrUpdate(Project project);

	Project findByCode(String code);
	
	List<Project> findAll();
	
	void deleteByCode(String code);
}
