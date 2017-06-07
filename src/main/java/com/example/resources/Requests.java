package com.example.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by sarthak on 7/6/17.
 */
public class Requests {

    @JsonProperty("student_id")
    private int studentId;

    @JsonProperty("course_id")
    private int courseId;


    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
