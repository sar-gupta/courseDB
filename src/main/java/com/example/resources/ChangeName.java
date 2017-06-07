package com.example.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by sarthak on 7/6/17.
 */
public class ChangeName {
    @JsonProperty("course_name")
    private String courseName;

    @JsonProperty("course_id")
    private int courseId;

    public String getCourseName() {
        System.out.println(courseName);
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseId() {
        System.out.println(courseId);
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

}
