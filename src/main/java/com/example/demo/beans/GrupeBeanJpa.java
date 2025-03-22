package com.example.demo.beans;

import com.example.demo.dao.GrupeDAO;
import com.example.demo.entities.Grupe;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("grupeBeanJpa")
@RequestScoped
public class GrupeBeanJpa implements Serializable {

    private Grupe naujaGrupe = new Grupe();
    private List<Grupe> visosGrupes;

    @Inject
    private GrupeDAO grupeDAO;

    @PostConstruct
    public void init() {
        visosGrupes = grupeDAO.getAllGroupes();  // Initialize group list
    }

    public void pridetiGrupe() {
        grupeDAO.addGrupe(naujaGrupe);
        naujaGrupe = new Grupe();  // Reset after adding
        visosGrupes = grupeDAO.getAllGroupes();
    }

    //getters, setters
    public List<Grupe> getVisosGrupes() {
        return visosGrupes;
    }
    public Grupe getNaujaGrupe() {
        return naujaGrupe;
    }
    public void setNaujaGrupe(Grupe naujaGrupe) {
        this.naujaGrupe = naujaGrupe;
    }
}
