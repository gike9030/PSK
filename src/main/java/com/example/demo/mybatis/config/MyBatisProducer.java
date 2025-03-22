package com.example.demo.mybatis.config;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;

import com.example.demo.mybatis.mappers.GrupeMapper;
import com.example.demo.mybatis.mappers.PasirenkamasKursasMapper;
import com.example.demo.mybatis.mappers.StudentasMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.io.Resources;
import java.io.IOException;
import java.io.Reader;

@ApplicationScoped
public class MyBatisProducer {

    private static final String MYBATIS_CONFIG = "mybatis-config.xml";

    private SqlSessionFactory sqlSessionFactory;

    public MyBatisProducer() {
        try {
            Reader reader = Resources.getResourceAsReader(MYBATIS_CONFIG);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load MyBatis configuration file: " + MYBATIS_CONFIG, e);
        }
    }

    @Produces
    @Singleton
    public SqlSessionFactory produceSqlSessionFactory() {
        return sqlSessionFactory;
    }

    @Produces
    @ApplicationScoped
    public SqlSession produceSqlSession(SqlSessionFactory sqlSessionFactory) {
        return sqlSessionFactory.openSession(true);
    }

    @Produces
    @ApplicationScoped
    public StudentasMapper produceStudentasMapper(SqlSession sqlSession) {
        return sqlSession.getMapper(StudentasMapper.class);
    }

    @Produces
    @ApplicationScoped
    public GrupeMapper produceGrupeMapper(SqlSession sqlSession) {
        return sqlSession.getMapper(GrupeMapper.class);
    }

    @Produces
    @ApplicationScoped
    public PasirenkamasKursasMapper producePasirenkamasKursasMapper(SqlSession sqlSession) {
        return sqlSession.getMapper(PasirenkamasKursasMapper.class);
    }
}
