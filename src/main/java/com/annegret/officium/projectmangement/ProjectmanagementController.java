package com.annegret.officium.projectmangement;

import com.annegret.officium.projectmangement.entities.ProjectEntity;
import com.annegret.officium.projectmangement.entities.ProjectsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ProjectmanagementController {

    private final ProjectsRepository projectsRepository;

    public ProjectmanagementController(ProjectsRepository projectsRepository) {
        this.projectsRepository=projectsRepository;
    }

    @GetMapping("/projects/test")
    @ResponseBody
    public String getTest() {
        return "Hello Annegret";
    }


    @GetMapping("/projects")
    @ResponseBody
    public ArrayList<ProjectEntity> getProjects() {
        ArrayList<ProjectEntity> projects=(ArrayList<ProjectEntity>) projectsRepository.findAll();
        return projects;
    }


}
