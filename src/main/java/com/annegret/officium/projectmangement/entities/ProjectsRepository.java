package com.annegret.officium.projectmangement.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ProjectsRepository extends JpaRepository<ProjectEntity, String> {

        ProjectEntity findProjectEntitiesById(String Id);
}
