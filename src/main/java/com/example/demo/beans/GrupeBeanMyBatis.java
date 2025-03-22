package com.example.demo.beans;

import com.example.demo.dao.GrupeDAO;
import com.example.demo.entities.Grupe;
import com.example.demo.mybatis.mappers.GrupeMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("grupeBeanMyBatis")  // Make sure this name matches the one used in the XHTML
@RequestScoped
public class GrupeBeanMyBatis implements Serializable {

    private Grupe naujaGrupe = new Grupe();
    private List<Grupe> visosGrupes;

    @Inject
    private GrupeMapper grupeMapper;

    @PostConstruct
    public void init() {
        visosGrupes = grupeMapper.findAll();
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

    // Add a new group using MyBatis
    public void pridetiGrupe() {
        grupeMapper.insert(naujaGrupe);
        naujaGrupe = new Grupe();  // Reset after adding
        visosGrupes = grupeMapper.findAll();
    }
}
