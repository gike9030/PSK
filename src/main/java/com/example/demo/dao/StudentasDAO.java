package com.example.demo.dao;

import com.example.demo.entities.PasirenkamasKursas;
import com.example.demo.entities.Studentas;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class StudentasDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Studentas> getAllStudents() {
        return entityManager.createQuery("SELECT s FROM Studentas s", Studentas.class).getResultList();
    }

    public void addStudent(Studentas studentas) {
        entityManager.persist(studentas);
    }
    public void addStudentWithCourses(Studentas studentas, List<Long> kursuIds) {
        List<PasirenkamasKursas> kursai = entityManager
                .createQuery("SELECT k FROM PasirenkamasKursas k WHERE k.id IN :ids", PasirenkamasKursas.class)
                .setParameter("ids", kursuIds)
                .getResultList();

        studentas.setPasirenkamiKursai(kursai);
        entityManager.persist(studentas);
    }

}
