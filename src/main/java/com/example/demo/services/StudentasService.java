package com.example.demo.services;

import com.example.demo.entities.Studentas;
import com.example.demo.dao.StudentasDAO;
import com.example.demo.mybatis.mappers.StudentasMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class StudentasService {

    @Inject
    private StudentasDAO studentasDAO;

    @Inject
    private StudentasMapper studentasMapper;

    // Fetch all students (JPA)
    public List<Studentas> getAllStudentsJpa() {
        return studentasDAO.getAllStudents();
    }

    // Fetch all students (MyBatis)
    public List<Studentas> getAllStudentsMyBatis() {
        return studentasMapper.findAll();
    }

    // Add student (JPA)
    public void addStudentJpa(Studentas studentas) {
        studentasDAO.addStudent(studentas);
    }

    // Add student (MyBatis)
    public void addStudentMyBatis(Studentas studentas) {
        studentasMapper.insert(studentas);
    }
}
