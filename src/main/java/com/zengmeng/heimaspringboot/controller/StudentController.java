package com.zengmeng.heimaspringboot.controller;

import com.zengmeng.heimaspringboot.Response;
import com.zengmeng.heimaspringboot.dto.StudentDTO;
import com.zengmeng.heimaspringboot.entity.Student;
import com.zengmeng.heimaspringboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

/*    @GetMapping("/student/{id}")
    public Response<StudentDTO> getStudentById(@PathVariable long id){
        return Response.success(studentService.getStudentById(id));
    }*/

    @PostMapping("/student")
    public Response<Long> addStudent(@RequestBody StudentDTO studentDTO){
        return Response.success(studentService.addNewStudent(studentDTO));

    }

    @DeleteMapping("/student/{id}")
    public void deleteStudentById(@PathVariable long id){
        studentService.deleteStudentById(id);
    }

    @PutMapping("/student/{id}")
    public Response<StudentDTO> updateStudentById(@PathVariable long id, @RequestParam(required = false) String name, @RequestParam(required = false) String email){
        return Response.success(studentService.updateStudentById(id,name,email));
    }

    @GetMapping("/student/{id}")
    public Response<StudentDTO> getUserByIdd(@PathVariable long id){
        return Response.success(studentService.getStudentByIdd(id));
    }
}
