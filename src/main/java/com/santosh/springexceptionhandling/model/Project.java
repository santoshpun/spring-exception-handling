package com.santosh.springexceptionhandling.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Project {
    private int id;
    private String code;
    private String name;
    private String description;
    private int percentageComplete;
    private String owner;
    private ProjectType projectType;
    private Date startDate;
    private Date endDate;
    private Date addedDate;
    private Date lastModifiedDate;
}
