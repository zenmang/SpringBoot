package com.zengmeng.heimaspringboot.service;

import com.zengmeng.heimaspringboot.dao.StudentRepository;
import com.zengmeng.heimaspringboot.dto.StudentDTO;
import com.zengmeng.heimaspringboot.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentDTO getStudentById(long id) {
        Student student = studentRepository.findById(id).orElseThrow(RuntimeException::new);
        StudentDTO studentDTO  = new StudentDTO();
        BeanUtils.copyProperties(student, studentDTO);
        return studentDTO;
    }

    @Override
    public Long addNewStudent(StudentDTO studentDTO) {
        List<Student> list = studentRepository.findByEmail(studentDTO.getEmail());
        if(!CollectionUtils.isEmpty(list)){
            throw new IllegalStateException("email already exist " + studentDTO.getEmail());
        }
        Student student = new Student();
        BeanUtils.copyProperties(studentDTO, student);
        Student save = studentRepository.save(student);
        return save.getId();
    }

    @Override
    public void deleteStudentById(long id) {
        studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("id not exist"+ id));
        studentRepository.deleteById(id);

    }

    @Override
    @Transactional
    public StudentDTO updateStudentById(long id, String name, String email) {
        Student student = studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("id not exist"+ id));
        if(!StringUtils.isEmpty(name) && !student.getName().equals(name)){
            student.setName(name);
        }
        if(!StringUtils.isEmpty(email) && !student.getEmail().equals(email)){
            student.setEmail(email);
        }
        Student save = studentRepository.save(student);
        StudentDTO studentDTO  = new StudentDTO();
        BeanUtils.copyProperties(student, studentDTO);
        return studentDTO;
    }
}
