 package com.example.resources;

 import com.example.core.Student;
import com.example.dao.StudentDAO;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

 /**
 * Created by sarthak on 6/6/17.
 */

@Path("/student")
@Produces(MediaType.APPLICATION_JSON)
public class StudentResources {

    final StudentDAO studentDAO;


     public StudentResources(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @POST
    @UnitOfWork
    public int createStudent(Student student) {
        return studentDAO.create(student);
    }

    @Path("/{id}")
    @GET
    @UnitOfWork
    public Student getStudentById(@PathParam("id") int id) {
        Optional<Student> studentOptional= studentDAO.findById(id);
        if(studentOptional.isPresent())
        {
             Student student = studentOptional.get();
            return student;
        }

        throw new WebApplicationException("Student not found", Response.Status.NOT_FOUND);





    }





//   @GET
//@UnitOfWork
//public List<Student> listStudents() {
//    return studentDAO.findAll();
//}

//@Path("{id}/courses")
//    @GET
//    @UnitOfWork
//    public Set<Course> getCourses(@PathParam("id") int id) {
//        Optional<Student> studentOptional = studentDAO.findById(id);
//
//        if(studentOptional.isPresent())
//        {
//            Student student= studentOptional.get();
//            return student.getCourses();
//
//        }
//
//        throw new WebApplicationException("Student not found", Response.Status.NOT_FOUND);
//    }
}