package com.annegret.officium.projectmangement.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="projects")
public class ProjectEntity {

    @Id
    @Column(name="id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "team")
    private String team;

    @Column(name = "createdat")
    private LocalDateTime createdAt;

    @Column(name="createdby")
    private String createdBy;

    @Column(name="updatedat")
    private LocalDateTime updatedAt;

    @Column(name="updatedby")
    private String updatedBy;

    @Column(name="thread")
    private String thread;

    @Column(name="duedate")
    private LocalDate dueDate;

    public ProjectEntity() {

    }

    public ProjectEntity(String name, LocalDate dueDate) {
        this.id= UUID.randomUUID().toString();
        this.name=name;
        this.team=null;
        this.createdAt=LocalDateTime.now();
        this.createdBy="21a2bac3-a2c4-4e45-b6da-2248bb36b82e";
        this.updatedAt=LocalDateTime.now();
        this.updatedBy="21a2bac3-a2c4-4e45-b6da-2248bb36b82e";
        this.dueDate= dueDate;
        /*this.thread=null;*/
    }

    public String getId() { return this.id;}

    public String getName() { return this.name;}
    public void setName(String name) {this.name=name;}

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public LocalDateTime getCreatedAt() { return this.createdAt;}

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() { return this.createdBy;}

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getUpdatedAt() {return this.updatedAt;}
    public void setUpdatedAt(LocalDateTime updatedAt) {this.updatedAt=updatedAt;}

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDate getDueDate() { return this.dueDate;}
    public void setDueDate(LocalDate dueDate) { this.dueDate=dueDate;}

    public String getThread() {
        return thread;
    }

    public void setThread(String thread) {
        this.thread = thread;
    }

}
