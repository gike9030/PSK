package com.example.demo.dao;

import com.example.demo.entities.Grupe;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class GrupeDAO {

    @PersistenceContext
    private EntityManager entityManager;

    // Find group by ID
    public Grupe findById(Long id) {
        return entityManager.find(Grupe.class, id);
    }

    // List all groups
    public List<Grupe> getAllGroupes() {
        return entityManager.createQuery("SELECT g FROM Grupe g", Grupe.class).getResultList();
    }

    // Save new group (optional if needed)
    public void addGrupe(Grupe grupe) {
        entityManager.persist(grupe);
    }
}
