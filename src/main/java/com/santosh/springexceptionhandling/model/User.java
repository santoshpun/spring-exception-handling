package com.santosh.springexceptionhandling.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
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
