package com.example.demo.dao;

import com.example.demo.entities.PasirenkamasKursas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PasirenkamasKursasDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<PasirenkamasKursas> getAllKursai() {
        return entityManager.createQuery("SELECT p FROM PasirenkamasKursas p", PasirenkamasKursas.class).getResultList();
    }

    public void addKursas(PasirenkamasKursas kursas) {
        entityManager.persist(kursas);
    }

    public PasirenkamasKursas findById(Long id) {
        return entityManager.find(PasirenkamasKursas.class, id);
    }
}
