package com.example.core;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by sarthak on 6/6/17.
 */

@Entity
@Table(name = "courses")
public class Course {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "courseName", nullable = false)
    private String courseName;


    public Course() {
    }

    public Course(String courseName) {
        this.courseName = courseName;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "courses_students", joinColumns = {
            @JoinColumn(name = "id_course",nullable = false) },
            inverseJoinColumns = {@JoinColumn(name = "id_student", nullable = false)
            })
    private Set<Student> students;

    public int getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

//    public Set<Student> getStudents() {
//        return students;
//    }
//
//    public void setStudents(Set<Student> students) {
//        this.students = students;
//    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
