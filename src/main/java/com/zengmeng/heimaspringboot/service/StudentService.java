package com.zengmeng.heimaspringboot.service;

import com.zengmeng.heimaspringboot.dto.StudentDTO;
import com.zengmeng.heimaspringboot.entity.Student;

public interface StudentService {
    public StudentDTO getStudentById(long id);

    Long addNewStudent(StudentDTO studentDTO);

    void deleteStudentById(long id);

    StudentDTO updateStudentById(long id, String name, String email);

    public StudentDTO getStudentByIdd(long id);
}
