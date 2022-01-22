package com.santosh.springexceptionhandling.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class User {
    private int id;
    private String username;
    private String password;
    private String name;
    private Department department;

    public User(int id){
        this.id = id;
    }
}
