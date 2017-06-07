package com.example.core;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by sarthak on 6/6/17.
 */

@Entity
@Table(name = "students")

public class Student {

//    @ManyToMany(mappedBy = "students", targetEntity = Course.class)
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Course.class)
    @JoinTable(name = "courses_students", joinColumns = {
            @JoinColumn(name = "id_course",nullable = false) },
            inverseJoinColumns = {@JoinColumn(name = "id_student", nullable = false)
            })
    private Set<Course> courses;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fullName", nullable = false)
    private String fullName;



    public Student() {
    }

    public Student(String fullName) {
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

//    public Set<Course> getCourses() {
//        return courses;
//    }
//
//    public void setCourses(Set<Course> courses) {
//        this.courses = courses;
//    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
