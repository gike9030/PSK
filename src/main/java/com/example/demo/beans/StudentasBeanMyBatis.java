package com.example.demo.beans;

import com.example.demo.entities.Grupe;
import com.example.demo.entities.Studentas;
import com.example.demo.services.GrupeServiceMyBatis;
import com.example.demo.services.StudentasServiceMyBatis;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("studentasBeanMyBatis")
@RequestScoped
public class StudentasBeanMyBatis implements Serializable {

    private Studentas naujasStudentas = new Studentas();
    private List<Studentas> visiStudentai;
    private List<Grupe> visosGrupes;
    private Long selectedGrupeId;

    @Inject
    private StudentasServiceMyBatis studentasServiceMyBatis;

    @Inject
    private GrupeServiceMyBatis grupeServiceMyBatis;

    @PostConstruct
    public void init() {
        visiStudentai = studentasServiceMyBatis.getAllStudentai();
        visosGrupes = grupeServiceMyBatis.getAllGrupesMyBatis();
    }
    public Long getSelectedGrupeId() {
        return selectedGrupeId;
    }

    public void setSelectedGrupeId(Long selectedGrupeId) {
        this.selectedGrupeId = selectedGrupeId;
    }

    public List<Studentas> getVisiStudentai() {
        return visiStudentai;
    }

    public List<Grupe> getVisosGrupes() {
        return visosGrupes;
    }

    public Studentas getNaujasStudentas() {
        return naujasStudentas;
    }

    public void setNaujasStudentas(Studentas naujasStudentas) {
        this.naujasStudentas = naujasStudentas;
    }

    public void pridetiStudenta() {
        Grupe pasirinktaGrupe = grupeServiceMyBatis.getGrupeById(selectedGrupeId);
        naujasStudentas.setGrupe(pasirinktaGrupe);
        studentasServiceMyBatis.addStudentas(naujasStudentas);

        naujasStudentas = new Studentas();
        selectedGrupeId = null;  // resetinam ID
        visiStudentai = studentasServiceMyBatis.getAllStudentai();
    }
}
