package com.example.dao;

import com.example.core.Course;
import com.example.core.Student;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.Optional;
import java.util.Set;

/**
 * Created by sarthak on 6/6/17.
 *
 * find course by id
 * find all students registered for a course
 * view course list
 * add course (without students)
 */
public class CourseDAO extends AbstractDAO<Course>{

    public CourseDAO(SessionFactory sessionFactory) {
        super(sessionFactory);

    }

    public Optional<Course> findById(int id) {
        return Optional.ofNullable(get(id));
    }


    public int create(Course course) {

        return persist(course).getId();
    }

    public int addStudent(Student student, Course course) {

//        Optional<Course> course = findById(courseId);
        Set<Student> students = course.getStudents();
        students.add(student);
        course.setStudents(students);
        return persist(course).getId();

    }

    public int changeCourseName(Course course, String newName) {
        course.setCourseName(newName);
        return persist(course).getId();
    }

    public void deleteCourse(Course course) {
        currentSession().delete(course);

    }

//    public int removeStudent(Student student, Course course) {
//
//        System.out.println("in coursedao");
//        Set<Student> students = course.getStudents();
//        students.remove(student);
//        course.setStudents(students);
//        return persist(course).getId();
//
//
//    }
}
