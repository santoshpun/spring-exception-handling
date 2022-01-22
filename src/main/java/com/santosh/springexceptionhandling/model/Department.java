package com.santosh.springexceptionhandling.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Department {
    private int id;
    private String name;

    public Department(int id){
        this.id = id;
    }
}
