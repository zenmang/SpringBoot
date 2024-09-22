package com.zengmeng.heimaspringboot.mapper;

import com.zengmeng.heimaspringboot.entity.Student;
import org.apache.ibatis.annotations.*;

@Mapper
public interface StudentMapper {

    @Select("SELECT * FROM springboot_test.student where id = #{id}")
    Student getUserByIdd(Long id);
}
