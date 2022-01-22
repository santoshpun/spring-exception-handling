package com.santosh.springexceptionhandling.controller;

import com.santosh.springexceptionhandling.model.Project;
import com.santosh.springexceptionhandling.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        List<Project> projects = projectService.fetchProjectList();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable("id") int id) {
        if (id == 0) {
            throw new RuntimeException("Project id is empty");
        }
        Project project = projectService.getProject(id);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Project> addProject(@RequestBody Project project) {
        Project created = projectService.addProject(project.getName(), project.getDescription());

        HttpHeaders headers = new HttpHeaders();
        headers.add("x-auth-token", "12345");

        return new ResponseEntity<>(created, headers, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable(name = "id") int id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }
}
