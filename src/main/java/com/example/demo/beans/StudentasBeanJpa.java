package com.example.demo.beans;

import com.example.demo.dao.GrupeDAO;
import com.example.demo.dao.StudentasDAO;
import com.example.demo.entities.Grupe;
import com.example.demo.entities.PasirenkamasKursas;
import com.example.demo.entities.Studentas;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("studentasBeanJpa")
@RequestScoped
public class StudentasBeanJpa implements Serializable {

    private Studentas naujasStudentas = new Studentas();
    private List<Studentas> visiStudentai;
    private List<Grupe> visosGrupes;
    private Long selectedGrupeId;
    private List<Long> selectedKursaiIds = new ArrayList<>();

    public List<Long> getSelectedKursaiIds() {
        return selectedKursaiIds;
    }

    public void setSelectedKursaiIds(List<Long> selectedKursaiIds) {
        this.selectedKursaiIds = selectedKursaiIds;
    }

    @Inject
    private StudentasDAO studentasDAO;

    @Inject
    private GrupeDAO grupeDAO;

    @Inject
    private EntityManager em;

    @PostConstruct
    public void init() {
        visiStudentai = studentasDAO.getAllStudents();
        visosGrupes = grupeDAO.getAllGroupes();
    }

    public void pridetiStudenta() {
        Grupe pasirinktaGrupe = grupeDAO.findById(selectedGrupeId);
        naujasStudentas.setGrupe(pasirinktaGrupe);

        List<PasirenkamasKursas> kursai = em.createQuery("SELECT k FROM PasirenkamasKursas k WHERE k.id IN :ids", PasirenkamasKursas.class)
                .setParameter("ids", selectedKursaiIds)
                .getResultList();

        naujasStudentas.setPasirenkamiKursai(kursai);

        studentasDAO.addStudent(naujasStudentas);

        naujasStudentas = new Studentas();
        selectedGrupeId = null;
        selectedKursaiIds.clear();
        visiStudentai = studentasDAO.getAllStudents();
    }

    public List<PasirenkamasKursas> getVisiKursai() {
        return em.createQuery("SELECT k FROM PasirenkamasKursas k", PasirenkamasKursas.class).getResultList();
    }

    //getters, setters
    public Studentas getNaujasStudentas() {
        return naujasStudentas;
    }
    public void setNaujasStudentas(Studentas naujasStudentas) {
        this.naujasStudentas = naujasStudentas;
    }
    public List<Studentas> getVisiStudentai() {
        return visiStudentai;
    }
    public List<Grupe> getVisosGrupes() {
        return visosGrupes;
    }
    public Long getSelectedGrupeId() {
        return selectedGrupeId;
    }
    public void setSelectedGrupeId(Long selectedGrupeId) {
        this.selectedGrupeId = selectedGrupeId;
    }
}
