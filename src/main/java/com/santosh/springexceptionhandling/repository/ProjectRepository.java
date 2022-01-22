package com.santosh.springexceptionhandling.repository;

import com.santosh.springexceptionhandling.model.Project;
import com.santosh.springexceptionhandling.model.ProjectType;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Repository
public class ProjectRepository {
    private List<Project> projects = new ArrayList<>();

    public List<Project> getAllProjects() {

        if (projects.isEmpty()) {

            Project project1 = new Project();
            project1.setId(1);
            project1.setCode("ECOMMERCE");
            project1.setName("Ecommerce app");
            project1.setDescription("Ecommerce app for groceries items");
            project1.setAddedDate(new Date());
            project1.setOwner("Santosh Pun");
            project1.setProjectType(ProjectType.NEW_PRODUCT);
            project1.setPercentageComplete(0);
            project1.setStartDate(new Date());
            project1.setEndDate(this.addMonths(6));

            projects.add(project1);

            Project project2 = new Project();
            project2.setId(2);
            project2.setCode("ONLINE_COURSE");
            project2.setName("Online Course app");
            project2.setDescription("Online course platform");
            project2.setAddedDate(new Date());
            project2.setOwner("Santosh Pun");
            project2.setProjectType(ProjectType.NEW_PRODUCT);
            project2.setPercentageComplete(0);
            project2.setStartDate(new Date());
            project2.setEndDate(this.addMonths(12));

            projects.add(project2);
        }

        return projects;
    }

    public Project findProjectById(int id) {
        for (Project project : projects) {
            if (project.getId() == id) {
                return project;
            }
        }
        return null;
    }

    public Project addProject(Project project) {
        int projectId = 1;

        if (projects.size() > 0) {
            int recentProjectId = projects.get(projects.size() - 1).getId();
            projectId = recentProjectId + 1;
        }

        project.setId(projectId);
        projects.add(project);
        return project;
    }

    public void deleteProjectById(int id) {
        List<Project> projectList = new ArrayList<>();
        for (Project project : projects) {
            if (project.getId() != id) {
                projectList.add(project);
            }
        }
        this.projects = projectList;
    }

    public Date addMonths(int months) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, months);
        return cal.getTime();
    }
}
