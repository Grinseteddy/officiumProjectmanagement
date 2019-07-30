package com.annegret.officium.projectmangement.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectsRepostory extends JpaRepository<ProjectEntity, String> {
}
