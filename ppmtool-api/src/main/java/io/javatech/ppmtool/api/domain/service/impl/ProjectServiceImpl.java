package io.javatech.ppmtool.api.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.javatech.ppmtool.api.domain.exception.NonUniqueValueException;
import io.javatech.ppmtool.api.domain.exception.ResourceNotFoundException;
import io.javatech.ppmtool.api.domain.model.Project;
import io.javatech.ppmtool.api.domain.repository.ProjectRepository;
import io.javatech.ppmtool.api.domain.service.ProjectService;

@Service
@Transactional(readOnly = true)
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	@Transactional
	@Override
	public Project saveOrUpdate(Project project) {
		project.setCode(project.getCode().toUpperCase());
		try {
			return this.projectRepository.saveAndFlush(project);
		} catch (Exception e) {
			throw new NonUniqueValueException("Project code " + project.getCode() + " already exists!");
		}
	}

	@Override
	public Project findByCode(String code) {
		return this.projectRepository.findByCode(code.toUpperCase())
				.orElseThrow(() -> new ResourceNotFoundException(Project.class.getSimpleName(), "code", code));
	}

	@Override
	public List<Project> findAll() {
		return this.projectRepository.findAll();
	}

	@Transactional
	@Override
	public void deleteByCode(String code) {
		this.projectRepository.delete(this.findByCode(code));
	}
}
