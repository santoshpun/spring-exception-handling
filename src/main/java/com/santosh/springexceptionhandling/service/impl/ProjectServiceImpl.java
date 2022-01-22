package com.santosh.springexceptionhandling.service.impl;

import com.santosh.springexceptionhandling.exception.RecordNotFoundException;
import com.santosh.springexceptionhandling.model.Project;
import com.santosh.springexceptionhandling.repository.ProjectRepository;
import com.santosh.springexceptionhandling.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    private ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> fetchProjectList() {
        return projectRepository.getAllProjects();
    }

    @Override
    public Project getProject(int id) {
        Project project = projectRepository.findProjectById(id);

        if (project == null) {
            throw new RecordNotFoundException("Project with id " + id + " not found");
        }
        return project;
    }

    @Override
    public Project addProject(String name, String description) {
        Project project = new Project();
        project.setName(name);
        project.setDescription(description);

        projectRepository.addProject(project);

        return project;
    }

    @Override
    public boolean deleteProject(int id) {
        projectRepository.deleteProjectById(id);
        return true;
    }
}
