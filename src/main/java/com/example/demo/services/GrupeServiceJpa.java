package com.example.demo.services;

import com.example.demo.dao.GrupeDAO;
import com.example.demo.entities.Grupe;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class GrupeServiceJpa {

    @Inject
    private GrupeDAO grupeDAO;

    public List<Grupe> getAllGrupesJpa() {
        return grupeDAO.getAllGroupes();
    }

    public void addGrupeJpa(Grupe grupe) {
        grupeDAO.addGrupe(grupe);
    }
}
