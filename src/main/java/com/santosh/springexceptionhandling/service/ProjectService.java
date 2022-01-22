package com.santosh.springexceptionhandling.service;

import com.santosh.springexceptionhandling.model.Project;

import java.util.List;

public interface ProjectService {

    List<Project> fetchProjectList();

    Project getProject(int id);

    Project addProject(String name,String description);

    boolean deleteProject(int id);
}
