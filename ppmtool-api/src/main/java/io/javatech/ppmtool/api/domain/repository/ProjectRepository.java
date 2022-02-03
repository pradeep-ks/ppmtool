package io.javatech.ppmtool.api.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.javatech.ppmtool.api.domain.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

	Optional<Project> findByCode(String code);

	List<Project> findAllByCode(List<String> codes);

}
