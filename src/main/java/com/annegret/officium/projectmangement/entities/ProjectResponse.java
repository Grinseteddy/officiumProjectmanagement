package com.annegret.officium.projectmangement.entities;

import java.util.ArrayList;

public class ProjectResponse {

    private Message message;
    private ArrayList<Link> links;
    private ProjectEntity project;

    public ProjectResponse() {

    }

    public ProjectResponse(ProjectEntity project, Message message, ArrayList<Link> links) {
        this.project=project;
        this.message=message;
        this.links=links;
    }

    public ArrayList<Link> getLinks() {
        return links;
    }

    public void setLinks(ArrayList<Link> links) {
        this.links = links;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public ProjectEntity getProject() {
        return project;
    }

    public void setProject(ProjectEntity project) {
        this.project=project;
    }
}
