package com.example.dao;


import com.example.core.Student;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.Optional;

/**
 * Created by sarthak on 6/6/17.
 *
 * find by id and display all courses
 * add student with multiple courses
 * view students list
 *
 */
public class StudentDAO extends AbstractDAO<Student>{

    public StudentDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Optional<Student> findById(int id) {
        return Optional.ofNullable(get(id));
    }


    public int create(Student student) {
        return persist(student).getId();
    }


//    public int addCourses(Student student, List<Course> courses)
//    {
//        return persist(student).getId();
//    }

}


