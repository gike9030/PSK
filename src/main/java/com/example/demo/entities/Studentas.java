package com.example.demo.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Studentas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pavadinimas;
    private String vardas;

    @ManyToOne
    private Grupe grupe;

    @ManyToMany
    private List<PasirenkamasKursas> pasirenkamiKursai = new ArrayList<>();

    // Constructors
    public Studentas() {}

    public Studentas(String pavadinimas, String vardas) {
        this.pavadinimas = pavadinimas;
        this.vardas = vardas;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public Grupe getGrupe() {
        return grupe;
    }

    public void setGrupe(Grupe grupe) {
        this.grupe = grupe;
    }

    public List<PasirenkamasKursas> getPasirenkamiKursai() {
        return pasirenkamiKursai;
    }

    public void setPasirenkamiKursai(List<PasirenkamasKursas> pasirenkamiKursai) {
        this.pasirenkamiKursai = pasirenkamiKursai;
    }

    @Override
    public String toString() {
        return "Studentas{" +
                "id=" + id +
                ", pavadinimas='" + pavadinimas + '\'' +
                ", vardas='" + vardas + '\'' +
                ", grupe=" + (grupe != null ? grupe.getId() : "null") +
                ", pasirenkamiKursai=" + pasirenkamiKursai.size() +
                '}';
    }
}
