package com.example.demo.mybatis.dao;

import com.example.demo.entities.Studentas;
import com.example.demo.mybatis.mappers.StudentasMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class StudentasDAO {

    @Inject
    private SqlSessionFactory sqlSessionFactory;  // Inject MyBatis SQL session factory

    public Studentas getById(Long id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            StudentasMapper studentasMapper = session.getMapper(StudentasMapper.class);
            return studentasMapper.findById(id);
        }
    }

    public List<Studentas> getAll() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            StudentasMapper studentasMapper = session.getMapper(StudentasMapper.class);
            return studentasMapper.findAll();
        }
    }

    public void insert(Studentas studentas) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            StudentasMapper studentasMapper = session.getMapper(StudentasMapper.class);
            studentasMapper.insert(studentas);
            session.commit();
        }
    }

    public void update(Studentas studentas) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            StudentasMapper studentasMapper = session.getMapper(StudentasMapper.class);
            studentasMapper.update(studentas);
            session.commit();
        }
    }

    public void delete(Long id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            StudentasMapper studentasMapper = session.getMapper(StudentasMapper.class);
            studentasMapper.delete(id);
            session.commit();
        }
    }
}
