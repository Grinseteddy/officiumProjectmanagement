package com.annegret.officium.projectmangement;

import com.annegret.officium.projectmangement.entities.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

@RestController
public class ProjectmanagementController {

    private final ProjectsRepository projectsRepository;

    //ToDo: Read environment variables correctly
    /*@Value("${taskManagementServer}")*/
    private static String taskManagementServer="ec2-3-120-34-138.eu-central-1.compute.amazonaws.com:5000";

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
        try {
            ArrayList<ProjectEntity> projects=(ArrayList<ProjectEntity>) projectsRepository.findAll();
            return projects;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No project found");
        }
    }

    @PostMapping("/projects")
    public ProjectEntity addProject(@RequestBody ProjectRequest newProject) {
        try {
            //TODO Get current user
            ProjectEntity project = new ProjectEntity(newProject.getName(), newProject.getDueDate());
            projectsRepository.save(project);
            return project;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "New project can't be created");
        }
    }

    @GetMapping("/projects/{projectId}")
    @ResponseBody
    public ProjectEntity getProjectById(@PathVariable String projectId) throws ResponseStatusException {
        try {
            ProjectEntity project=projectsRepository.findProjectEntitiesById(projectId);
            if (project==null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Project not found");
            }
            return  project;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Project not found");
        }
    }

    @PutMapping("/projects/{projectId}")
    public ProjectResponse updateProject(@PathVariable String projectId, @RequestBody ProjectRequest project) throws ResponseStatusException {
        try {
            //ToDo Check function
            //ToDo Get current user
            Message message=new Message();
            message.setSeverity(Message.severity.SUCCESS);
            message.setCode("PROJECT UPDATED");
            ProjectEntity projectToBeUpdated=projectsRepository.findProjectEntitiesById(projectId);
            if (projectToBeUpdated==null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Project not found");
            }
            if (!projectToBeUpdated.getName().equals(project.getName())) {
                message.setMessage("Project name: "+projectToBeUpdated.getName()+" -> "+project.getName());
                projectToBeUpdated.setName(project.getName());
            }
            if (projectToBeUpdated.getDueDate()==null || !projectToBeUpdated.getDueDate().equals(project.getDueDate())) {
                message.setMessage("Due date: "+projectToBeUpdated.getDueDate()+" ->"+project.getDueDate());
                projectToBeUpdated.setDueDate(project.getDueDate());
            }
            projectToBeUpdated.setUpdatedBy("21a2bac3-a2c4-4e45-b6da-2248bb36b82e");
            projectToBeUpdated.setUpdatedAt(LocalDateTime.now());
            projectsRepository.save(projectToBeUpdated);
            ArrayList<Link> links=new ArrayList<>();

            Link tasksLink=new Link();
            tasksLink.setHref(taskManagementServer+"/tasks/project/"+projectToBeUpdated.getId());
            tasksLink.setRelation(Link.relation.Object);
            tasksLink.setLinkType(Link.linkType.HyperLink);

            links.add(tasksLink);

            return new ProjectResponse(projectToBeUpdated, message, links);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Project not found");

        }
    }


}
