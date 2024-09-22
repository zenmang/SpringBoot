package com.zengmeng.heimaspringboot.dao;

import com.zengmeng.heimaspringboot.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    List<Student> findByEmail(String email);



}
