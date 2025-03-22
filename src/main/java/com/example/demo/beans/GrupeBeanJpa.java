package com.example.demo.beans;

import com.example.demo.dao.GrupeDAO;
import com.example.demo.entities.Grupe;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("grupeBeanJpa")  // THIS name must match the name used in the XHTML
@RequestScoped        // You can also use @ViewScoped if needed
public class GrupeBeanJpa implements Serializable {

    private Grupe naujaGrupe = new Grupe();
    private List<Grupe> visosGrupes;

    @Inject
    private GrupeDAO grupeDAO;

    @PostConstruct
    public void init() {
        visosGrupes = grupeDAO.getAllGroupes();  // Initialize group list
    }

    public List<Grupe> getVisosGrupes() {
        return visosGrupes;
    }

    public Grupe getNaujaGrupe() {
        return naujaGrupe;
    }

    public void setNaujaGrupe(Grupe naujaGrupe) {
        this.naujaGrupe = naujaGrupe;
    }

    public void pridetiGrupe() {
        grupeDAO.addGrupe(naujaGrupe);
        naujaGrupe = new Grupe();  // Reset after adding
        visosGrupes = grupeDAO.getAllGroupes();
    }
}
