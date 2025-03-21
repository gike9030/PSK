package com.example.demo.services;

import com.example.demo.entities.Studentas;
import com.example.demo.mybatis.mappers.StudentasMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class StudentasServiceMyBatis {

    @Inject
    private StudentasMapper studentasMapper;

    public List<Studentas> getAllStudentai() {
        return studentasMapper.findAll();
    }

    public void addStudentas(Studentas studentas) {
        studentasMapper.insert(studentas);
    }
}
