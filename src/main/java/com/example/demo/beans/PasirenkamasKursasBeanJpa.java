package com.example.demo.beans;

import com.example.demo.dao.PasirenkamasKursasDAO;
import com.example.demo.entities.PasirenkamasKursas;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("pasirenkamasKursasBeanJpa")
@RequestScoped
public class PasirenkamasKursasBeanJpa implements Serializable {

    private PasirenkamasKursas naujasKursas = new PasirenkamasKursas();
    private List<PasirenkamasKursas> visiKursai;

    @Inject
    private PasirenkamasKursasDAO kursasDAO;

    @PostConstruct
    public void init() {
        visiKursai = kursasDAO.getAllKursai();
    }

    public void pridetiKursa() {
        kursasDAO.addKursas(naujasKursas);
        naujasKursas = new PasirenkamasKursas();
        visiKursai = kursasDAO.getAllKursai();
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
