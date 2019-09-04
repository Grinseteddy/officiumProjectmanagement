package com.annegret.officium.projectmangement.entities;

import java.time.LocalDate;

public class ProjectRequest {

    private String name;
    private LocalDate dueDate;

    public ProjectRequest() {

    }

    public ProjectRequest(String name, LocalDate dueDate) {
        this.name=name;
        this.dueDate=dueDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
