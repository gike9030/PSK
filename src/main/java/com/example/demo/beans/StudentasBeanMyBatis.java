package com.example.demo.beans;

import com.example.demo.entities.Grupe;
import com.example.demo.entities.PasirenkamasKursas;
import com.example.demo.entities.Studentas;
import com.example.demo.mybatis.mappers.GrupeMapper;
import com.example.demo.mybatis.mappers.PasirenkamasKursasMapper;
import com.example.demo.mybatis.mappers.StudentasMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Named("studentasBeanMyBatis")
@RequestScoped
public class StudentasBeanMyBatis implements Serializable {

    private Studentas naujasStudentas = new Studentas();
    private List<Studentas> visiStudentai;
    private List<Grupe> visosGrupes;
    private Long selectedGrupeId;
    private List<Long> selectedKursaiIds  = new ArrayList<Long>();

    @Inject
    private StudentasMapper studentasMapper;
    @Inject
    private GrupeMapper grupeMapper;
    @Inject
    private PasirenkamasKursasMapper pasirenkamasKursasMapper;

    @PostConstruct
    public void init() {
        visiStudentai = studentasMapper.findAll();
        visosGrupes = grupeMapper.findAll();
    }
    public void pridetiStudenta() {
        Grupe pasirinktaGrupe = grupeMapper.findById(selectedGrupeId);
        naujasStudentas.setGrupe(pasirinktaGrupe);
        List<PasirenkamasKursas> kursai = selectedKursaiIds.stream()
                .map(id -> pasirenkamasKursasMapper.findById(id))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        naujasStudentas.setPasirenkamiKursai(kursai);
        studentasMapper.insert(naujasStudentas);

        for (PasirenkamasKursas kursas : kursai) {
            studentasMapper.insertStudentoKursas(naujasStudentas.getId(), kursas.getId());
        }
        naujasStudentas = new Studentas();
        selectedGrupeId = null;  // resetinam ID
        selectedKursaiIds.clear();
        visiStudentai = studentasMapper.findAll();
    }
    //getters & setters
    public Long getSelectedGrupeId() {return selectedGrupeId;}
    public void setSelectedGrupeId(Long selectedGrupeId) {this.selectedGrupeId = selectedGrupeId;}
    public List<Studentas> getVisiStudentai() {return visiStudentai;}
    public List<Grupe> getVisosGrupes() {
        return visosGrupes;
    }
    public Studentas getNaujasStudentas() {
        return naujasStudentas;
    }
    public void setNaujasStudentas(Studentas naujasStudentas) {
        this.naujasStudentas = naujasStudentas;
    }
    public List<Long> getSelectedKursaiIds() {return selectedKursaiIds;}
    public void setSelectedKursaiIds(List<Long> selectedKursaiIds) {this.selectedKursaiIds = selectedKursaiIds;}

}
