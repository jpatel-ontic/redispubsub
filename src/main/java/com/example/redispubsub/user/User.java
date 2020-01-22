package com.example.redispubsub.user;

import org.springframework.stereotype.Component;

import java.io.Serializable;


public class User implements Serializable {

    private static final long serialVersionUID = -1;
    private String id;
    private String name;
    private Integer salary;

    public User(String id, String name, Integer salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}
