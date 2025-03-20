package com.example.demo.services;

import com.example.demo.entities.Grupe;
import com.example.demo.mybatis.mappers.GrupeMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class GrupeServiceMyBatis {

    @Inject
    private GrupeMapper grupeMapper; // Ensure this is properly injected

    @Inject
    private SqlSessionFactory sqlSessionFactory; // Inject SqlSessionFactory to manage sessions

    // Get all groups using MyBatis
    public List<Grupe> getAllGrupesMyBatis() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            GrupeMapper mapper = session.getMapper(GrupeMapper.class);
            return mapper.findAll(); // Fetch all groups
        }
    }

    // Add new group using MyBatis
    public void addGrupeMyBatis(Grupe grupe) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            GrupeMapper mapper = session.getMapper(GrupeMapper.class);
            mapper.insert(grupe);
            session.commit();  // Commit the transaction
        }
    }
}
