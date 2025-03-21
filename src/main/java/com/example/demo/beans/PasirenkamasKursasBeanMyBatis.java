package com.example.demo.beans;

import com.example.demo.entities.PasirenkamasKursas;
import com.example.demo.services.PasirenkamasKursasServiceMyBatis;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("pasirenkamasKursasBeanMyBatis")
@RequestScoped
public class PasirenkamasKursasBeanMyBatis implements Serializable {

    private PasirenkamasKursas naujasKursas = new PasirenkamasKursas();
    private List<PasirenkamasKursas> visiKursai;

    @Inject
    private PasirenkamasKursasServiceMyBatis kursasServiceMyBatis;

    @PostConstruct
    public void init() {
        visiKursai = kursasServiceMyBatis.getAllKursai();
    }

    public void pridetiKursa() {
        kursasServiceMyBatis.addKursas(naujasKursas);
        naujasKursas = new PasirenkamasKursas();
        visiKursai = kursasServiceMyBatis.getAllKursai();
    }

    // Getters ir setters
    public PasirenkamasKursas getNaujasKursas() {
        return naujasKursas;
    }

    public void setNaujasKursas(PasirenkamasKursas naujasKursas) {
        this.naujasKursas = naujasKursas;
    }

    public List<PasirenkamasKursas> getVisiKursai() {
        return visiKursai;
    }
}
